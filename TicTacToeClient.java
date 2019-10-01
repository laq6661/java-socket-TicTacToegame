import java.io.*;
import java.net.*;
import java.util.*;

    

    public class TicTacToeClient {

        static final String MARK_1 = "X";
        static final String MARK_2 = "O";
        static final String MARK_NONE = " ";
        static final String WIN = "WIN";
        static final String DRAW = "DRAW";
        static final String LOSS = "LOSS";
        

static String cases[] = {MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE,MARK_NONE};



        public static void main(String [] argv) throws IOException, SecurityException {


            InetAddress IPaddress = null;
            Socket client = null;
            DataOutputStream dataoutput = null;
            DataInputStream datainput = null;
            String mark;
            String markAdv;
            int position = -1;
            int positionAdv =-1;
            boolean fini = false;
            GameFrame gameFrame = new GameFrame();
            String ifchange;
            String ifchangeAdv;
            

            try {
                System.out.println("Connection with the serveur");
                IPaddress = InetAddress.getLocalHost();
                client = new Socket(IPaddress,50000);

            } catch (IOException e) {
                System.err.println ("Error for connection");
                System.exit(1);
            }

    
            try {
                InputStream input = client.getInputStream();
                datainput = new DataInputStream(input);             
                OutputStream output = client.getOutputStream();
                dataoutput = new DataOutputStream(output);
            } catch (IOException e) {
                System.err.println("Error opening Player Flows");
                System.exit(1);
            }
            dataoutput.writeUTF(argv[0]);
   
            mark = datainput.readUTF();
            if (mark.equals(MARK_NONE)) {
                System.out.println("Nom player incorrect");
                client.close();
                System.exit(1);
            }
            if (mark.equals(MARK_1)) {
                markAdv = new String(MARK_2);
                gameFrame.Mark="X";
            } else {
                markAdv = new String(MARK_1);
                gameFrame.Mark="O";
            }

            Scanner sc = new Scanner(System.in);
            while (!fini) {              
                    mark = datainput.readUTF();
                    //System.out.println(mark);
                    gameFrame.Win(mark);
                    positionAdv = datainput.readInt();
                    //System.out.println("ADV  "+positionAdv);                  
                    if (gameFrame.Mark=="X") {
                        dataoutput.writeUTF(argv[0]);
                        gameFrame.paintero(positionAdv);
                    } else if(gameFrame.Mark=="O"){
                        dataoutput.writeUTF(argv[0]);
                       
                        gameFrame.painterx(positionAdv);
                            
                    }
                    else{
                        dataoutput.writeUTF("0");
                    }
                        
                   // System.out.println("Position est "+ position);
                        
                        position= gameFrame.pos;
                        dataoutput.writeInt(position);
                        gameFrame.title("Player name : " + datainput.readUTF());
                        
                        ifchange=datainput.readUTF();
                        if(ifchange.equals("no")){

                        }
                        else if(ifchange.equals("mychange")){
                            //gameFrame.Button(false);
                            gameFrame.mouseFlag=false;
                            System.out.println(ifchange);
                        }
                        else if(ifchange.equals("advchange")){
                            //gameFrame.Button(true);
                            gameFrame.mouseFlag=true;
                            System.out.println(ifchange);
                        }
               
            }
           
                sc.close();
                client.close();
            
           
        }
    }
