import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	public static int pos =-1;
	public boolean pos2= false;
	public static String Mark="";
	public static boolean flag = false;
	//public static int postion_in=-1;
	public BufferedImage board =null;
	public BufferedImage redX =null;
	public BufferedImage buluO=null;
	public int frameWidth =506;
	public int frameHeight = 527;
	public boolean mouseFlag=true;


	public GameFrame(){
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int frameX =(screenWidth-frameWidth)/2;
		int frameY =(screenHeight-frameHeight)/2;
		this.setBounds(frameX, frameY, frameWidth, frameHeight);
		loadImage();
		
		getContentPane().setLayout(null);
		JLabel label =new JLabel(new ImageIcon(board));
		getContentPane().add(label);
		label.setBounds(0,0,board.getWidth(),board.getHeight());
		JLabel label2 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label2);   
		JLabel label3 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label3); 
		JLabel label4 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label4);
		JLabel label5 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label5);
		JLabel label6 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label6);
		JLabel label7 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label7);
		JLabel label8 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label8);
		JLabel label9 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label9);
		JLabel label10 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label10);
		JLabel labela =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labela);   
		JLabel labelb =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelb);   
		JLabel labelc =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelc);   
		JLabel labeld =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labeld);   
		JLabel labele =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labele);   
		JLabel labelf =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelf);   
		JLabel labelg =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelg);  
		JLabel labelh =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelh);  
		JLabel labeli =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labeli);   
		


	
        this.addMouseListener(new MouseListener() {  
        @Override
        public void mousePressed(MouseEvent e) {
			if(mouseFlag){
				if(Mark=="X"){
					if(e.getX()<=frameWidth/3&&e.getY()<=frameHeight/3){ 
						pos=0;
						pos2=true;
						label2.setBounds(0,0,160,160);
					   }
					   else if(e.getX()<=frameWidth/3*2&& e.getX()>=frameWidth/3&& e.getY()<=frameHeight/3){
						pos=1;
						pos2=true;
						label3.setBounds(frameWidth/3,0,160,160);
					   }
					   else if(e.getX()<=frameWidth && e.getX()>=frameWidth/3*2&& e.getY()<=frameHeight/3){
						pos=2;
						pos2=true;
						label4.setBounds(frameWidth/3*2,0,160,160);
					   }
					   else if(e.getX()<=frameWidth/3&&e.getY()>=frameHeight/3&&e.getY()<=frameHeight/3*2){     
						pos =3;
						pos2=true;
						label5.setBounds(0,frameHeight/3,160,160);
					   }
					   else if(e.getX()<=frameWidth/3*2&& e.getY()>=frameHeight/3&&e.getY()<=frameHeight/3*2){
						pos =4;
						pos2=true;
						label6.setBounds(frameWidth/3,frameHeight/3,160,160);
					   }
					   else if(e.getX()<=frameWidth && e.getY()>=frameHeight/3&&e.getY()<=frameHeight/3*2){
						pos =5;
						pos2=true;
						label7.setBounds(frameWidth/3*2,frameHeight/3,160,160);
					   }
					   else if(e.getX()<=frameWidth/3 && e.getY()>=frameHeight/3*2&&e.getY()<=frameHeight){
						pos =6;
						pos2=true;
						label8.setBounds(0,frameHeight/3*2,160,160);
					   }
					   else if(e.getX()<=frameWidth/3*2&& e.getX()>=frameWidth/3&&  e.getY()>=frameHeight/3*2&&e.getY()<=frameHeight){
						pos =7;
						pos2=true;
						label9.setBounds(frameWidth/3,frameHeight/3*2,160,160);
					   }
					   else if(e.getX()<=frameWidth &&  e.getY()>=frameHeight/3*2&&e.getY()<=frameHeight){
						pos =8;
						pos2=true;
						label10.setBounds(frameWidth/3*2,frameHeight/3*2,160,160);
					   }
				}
				else if(Mark=="O"){
					if(e.getX()<=frameWidth/3&&e.getY()<=frameHeight/3){ 
						pos=0;
						pos2=true;
						labela.setBounds(0,0,160,160);
					   }
					   else if(e.getX()<=frameWidth/3*2&& e.getX()>=frameWidth/3&& e.getY()<=frameHeight/3){
						pos=1;
						pos2=true;
						labelb.setBounds(frameWidth/3,0,160,160);
					   }
					   else if(e.getX()<=frameWidth && e.getX()>=frameWidth/3*2&& e.getY()<=frameHeight/3){
						pos=2;
						pos2=true;
						labelc.setBounds(frameWidth/3*2,0,160,160);
					   }
					   else if(e.getX()<=frameWidth/3&&e.getY()>=frameHeight/3&&e.getY()<=frameHeight/3*2){     
						pos =3;
						pos2=true;
						labeld.setBounds(0,frameHeight/3,160,160);
					   }
					   else if(e.getX()<=frameWidth/3*2&& e.getY()>=frameHeight/3&&e.getY()<=frameHeight/3*2){
						pos =4;
						pos2=true;
						labele.setBounds(frameWidth/3,frameHeight/3,160,160);
					   }
					   else if(e.getX()<=frameWidth && e.getY()>=frameHeight/3&&e.getY()<=frameHeight/3*2){
						pos =5;
						pos2=true;
						labelf.setBounds(frameWidth/3*2,frameHeight/3,160,160);
					   }
					   else if(e.getX()<=frameWidth/3 && e.getY()>=frameHeight/3*2&&e.getY()<=frameHeight){
						pos =6;
						pos2=true;
						labelg.setBounds(0,frameHeight/3*2,160,160);
					   }
					   else if(e.getX()<=frameWidth/3*2&& e.getX()>=frameWidth/3&&  e.getY()>=frameHeight/3*2&&e.getY()<=frameHeight){
						pos =7;
						pos2=true;
						labelh.setBounds(frameWidth/3,frameHeight/3*2,160,160);
					   }
					   else if(e.getX()<=frameWidth &&  e.getY()>=frameHeight/3*2&&e.getY()<=frameHeight){
						pos =8;
						pos2=true;
						labeli.setBounds(frameWidth/3*2,frameHeight/3*2,160,160);
					   }
				}
			
			}
		   

		   
        }
        @Override
        public void mouseClicked(MouseEvent e) {
			
 
        }
 
        @Override
        public void mouseReleased(MouseEvent e) {
         
 
        }
 
        @Override
        public void mouseEntered(MouseEvent e) {
          
 
        }
 
        @Override
        public void mouseExited(MouseEvent e) {
        
 
		}
	
 
 
	  });
	
	}
	
	public void loadImage(){
			
		
		try{
			board =ImageIO.read(this.getClass().getResource("\\res\\board.png"));
			redX =ImageIO.read(this.getClass().getResource("\\res\\redX.png"));
			buluO =ImageIO.read(this.getClass().getResource("\\res\\blueCircle.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void painterx(int postion_in){
		JLabel label2 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label2);   
		JLabel label3 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label3); 
		JLabel label4 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label4);
		JLabel label5 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label5);
		JLabel label6 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label6);
		JLabel label7 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label7);
		JLabel label8 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label8);
		JLabel label9 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label9);
		JLabel label10 =new JLabel(new ImageIcon(redX));
		getContentPane().add(label10);
		
		if(postion_in==0){ 
			label2.setBounds(0,0,160,160);
		   }
		else if(postion_in==1){
			
			label3.setBounds(frameWidth/3,0,160,160);
		   }
		else if(postion_in==2){
			
			label4.setBounds(frameWidth/3*2,0,160,160);
		   }
		else if(postion_in==3){     
			label5.setBounds(0,frameHeight/3,160,160);
		   }
		else if(postion_in==4){
		
			label6.setBounds(frameWidth/3,frameHeight/3,160,160);
		   }
		else if(postion_in==5){
			
			label7.setBounds(frameWidth/3*2,frameHeight/3,160,160);
		   }
		else if(postion_in==6){
			
			label8.setBounds(0,frameHeight/3*2,160,160);
		   }
		else if(postion_in==7){
			
			label9.setBounds(frameWidth/3,frameHeight/3*2,160,160);
		   }
		else if(postion_in==8){
			
			label10.setBounds(frameWidth/3*2,frameHeight/3*2,160,160);
		   }
	}

	public void paintero(int postion_in){
		JLabel labela =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labela);   
		JLabel labelb =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelb);   
		JLabel labelc =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelc);   
		JLabel labeld =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labeld);   
		JLabel labele =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labele);   
		JLabel labelf =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelf);   
		JLabel labelg =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelg);  
		JLabel labelh =new JLabel(new ImageIcon(buluO));
		getContentPane().add(labelh);  
		JLabel labeli =new JLabel(new ImageIcon(buluO));
		if(postion_in==0){ 
			labela.setBounds(0,0,160,160);
		   }
		else if(postion_in==1){
			
			labelb.setBounds(frameWidth/3,0,160,160);
		   }
		else if(postion_in==2){
			
			labelc.setBounds(frameWidth/3*2,0,160,160);
		   }
		else if(postion_in==3){     
			labeld.setBounds(0,frameHeight/3,160,160);
		   }
		else if(postion_in==4){
		
			labele.setBounds(frameWidth/3,frameHeight/3,160,160);
		   }
		else if(postion_in==5){
			
			labelf.setBounds(frameWidth/3*2,frameHeight/3,160,160);
		   }
		else if(postion_in==6){
			
			labelg.setBounds(0,frameHeight/3*2,160,160);
		   }
		else if(postion_in==7){
			
			labelh.setBounds(frameWidth/3,frameHeight/3*2,160,160);
		   }
		else if(postion_in==8){
			
			labeli.setBounds(frameWidth/3*2,frameHeight/3*2,160,160);
		   }
	}

	public void title(String x){
		this.setTitle(x);
	}
	public void Win(String x){
		if(x.equals("WIN")){
			JLabel labelW =new JLabel("YOU WIN!");
			Font largerFont = new Font("Verdana", Font.BOLD, 50);
			labelW.setFont(largerFont);
			labelW.setForeground(Color.RED);
			getContentPane().add(labelW); 
			labelW.setBounds(80,0,500,500);

		}
		else if(x.equals("LOSS")){
			JLabel labelW =new JLabel("YOU LOSS!");
			Font largerFont = new Font("Verdana", Font.BOLD, 50);
			labelW.setFont(largerFont);
			labelW.setForeground(Color.BLACK);
			getContentPane().add(labelW); 
			labelW.setBounds(80,0,500,500);
		}
		else if(x.equals("DRAW")){
			JLabel labelW =new JLabel("ITS DRAW!");
			Font largerFont = new Font("Verdana", Font.BOLD, 50);
			labelW.setFont(largerFont);
			labelW.setForeground(Color.BLUE);
			getContentPane().add(labelW); 
			labelW.setBounds(80,0,500,500);
		}
		else{
			//System.out.println(x);
		}
		
	}
	public void Button(boolean x){
		
		JButton bu = new JButton("next step");
		bu.setBounds(0,0,500,500);

		if(x){
			bu.setVisible(false);
		}
		
		
		
		getContentPane().add(bu);
		bu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button");
				
			}
		});
		
		
	}
	

	
	
	public static void main(String[] args){
		new GameFrame();
	}
}
