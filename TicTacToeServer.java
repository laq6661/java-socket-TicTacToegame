
import java.io.*;
import java.net.*;
class TicTacToeServer {
        static final String MARK_1 = "X";
        static final String MARK_2 = "O";
        static final String MARK_NONE = " ";
        static final String CONTINUE = "CONTINUE";
        static final String WIN = "WIN";
        static final String DRAW = "DRAW";
        static final String LOSS = "LOSS";
        static int flag1= -1;
        static int flag2= -1;
        static String jid ="";
        static boolean jidf =false;

        static String cases[] = {MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE}; 
                public static void main(String [] argv) throws IOException, SecurityException {

            ServerSocket connection = null;
            Socket client1 = null;
            Socket client2 = null;
            Player playerCurrent = null;
            Player playerNext = null;
            int position = -1;
            boolean fini = false;
         

         
            try {
                connection = new ServerSocket(50000);
                System.out.println("Server port 50000");
            } catch (IOException e) {
                System.err.println("Server error");
                System.exit(1);
            }

         
            try {
                System.out.println("Waitting for the connection of player1");
                client1 = connection.accept();
            } catch (IOException e) {
                System.err.println ("Error for connection");
                System.exit(1);
            } catch (SecurityException e) {
                System.err.println("Error for connection");
                System.exit(1);
            }
            playerCurrent = new Player(client1);     

            String nom1 = playerCurrent.datainput.readUTF();   
            System.out.println("Player 1 : "+ nom1);
            playerCurrent.dataoutput.writeUTF(MARK_1);                          
            playerCurrent.initPlayer(nom1, MARK_1);     

            
            try {
                System.out.println("Waitting for the connection of player2");
                client2 = connection.accept();
            } catch (IOException e) {
                System.err.println ("Error for connection");
                System.exit(1);
            } catch (SecurityException e) {
                System.err.println("Error for connection");
                System.exit(1);
            }

           
            playerNext = new Player(client2);
            String nom2 = playerNext.datainput.readUTF();
            if (!nom2.equals(nom1)) {                       
                System.out.println("Player 2 : "+ nom2);
                playerNext.dataoutput.writeUTF(MARK_2);
                playerNext.initPlayer(nom2, MARK_2);
            } else {
                playerNext.dataoutput.writeUTF(MARK_NONE);
                playerCurrent.dataoutput.writeUTF(DRAW);
                client1.close();
                client2.close();
                System.exit(1);
            }

            while (!fini) {                                         

                playerCurrent.dataoutput.writeUTF(CONTINUE);               
                playerCurrent.dataoutput.writeInt(position);             

                String message = playerCurrent.datainput.readUTF();
                position = playerCurrent.datainput.readInt();
                System.out.println(message + " " + position);
                playerCurrent.dataoutput.writeUTF(message);  
                if(message.equals(nom1)){
                    if(flag1!=position){
                        jid="mychange";
                        jidf=true;
                        

                    }
                    else{
                        if(jidf){
                            jid="advchange";
                            jidf=false;
                        }
                        else{
                            jid="no";
                        }
                       
                    }
                    flag1=position;
                }  
                
                if(message.equals(nom2)){
                    if(flag2!=position){
                        jid="mychange";
                        jidf=true;

                    }
                    else{
                        if(jidf){
                            jid="advchange";
                            jidf=false;
                        }
                        else{
                            jid="no";
                        }
                    }
                    flag2=position;
                }  
               
                playerCurrent.dataoutput.writeUTF(jid); 
                
                        
                

if((position >= 0)&&(position <=8)&&(cases[position].equals(MARK_NONE))) {//能下子有空位
                        cases[position] = new String(playerCurrent.mark);

                        String Judgment1 = ifwin();                                   

                       if(Judgment1.equals("WIN")) {
                           playerCurrent.dataoutput.writeUTF(WIN);
                           playerNext.dataoutput.writeUTF(LOSS);
                           fini = true;
                       }

                       else if(Judgment1.equals("DRAW")) {
                           playerCurrent.dataoutput.writeUTF(DRAW);
                           playerNext.dataoutput.writeUTF(DRAW);
                           fini = true;
                       }
                           
                       else {
                           Player temp = playerNext;
                           playerNext = playerCurrent;
                           playerCurrent = temp;
                       }
                } 
                else {
                       Player temp = playerNext;
                       playerNext = playerCurrent;
                       playerCurrent = temp;
                }
            }
               playerCurrent.player.close();
               playerNext.player.close();
               connection.close();
            }


            public static String ifwin() {//检测是否胜利
            if(iffull()){
            return "DRAW";
            }
                for(int i = 0; i <= 6; i+=3) {
                if((!cases[i].equals(MARK_NONE)) && cases[i].equals(cases[i+1]) && cases[i+1].equals(cases[i+2])) {
                    return "WIN";
                }
            }
            for(int i = 0; i <= 2; i+=1) {
                if((!cases[i].equals(MARK_NONE)) && cases[i].equals(cases[i+3]) && cases[i+3].equals(cases[i+6])){
                    return "WIN";
                }
            }
            if((!cases[0].equals(MARK_NONE)) && cases[0].equals(cases[4]) && cases[4].equals(cases[8])){
                return "WIN";
            }
            if((!cases[2].equals(MARK_NONE)) && cases[2].equals(cases[4]) && cases[4].equals(cases[6])){
                return "WIN";
            }
            return "CONTINUE";
        }

        public static boolean iffull(){//检测有没有下满格子
            for(int i = 0; i < cases.length; i++){
                if(cases[i].equals(MARK_NONE)){
                    return false;
                }
            }
            return true;
        }
}