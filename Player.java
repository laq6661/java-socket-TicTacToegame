
import java.io.*;
import java.net.*;

//定义玩家类
    class Player {
        Socket player = null;
        DataOutputStream dataoutput = null;
        DataInputStream datainput = null;
        String name;
        String mark;
        //构造函数，初始化soket对象
        Player (Socket j) {
            this.player = j;
            try {
                InputStream input = j.getInputStream();
                this.datainput = new DataInputStream(input);                
                OutputStream output = j.getOutputStream();
                this.dataoutput = new DataOutputStream(output);
            } catch (IOException e) {
                System.err.println("Server open error");
                System.exit(1);
            }
        }
        void initPlayer (String name, String mark) {
            this.name = name;
            this.mark = mark;
        }
    }
