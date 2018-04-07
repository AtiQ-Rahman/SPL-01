package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Zombie extends JPanel implements ActionListener,KeyListener  {
	
	
	
	public int[][] arrStar=new int[30][3];
	public int[][]arr2;
	
	private BufferedImage img1,img2,img3,img4;
	Timer timer;
	public int x=1250,y=570,delay=6;
	
	public int count=0;
	boolean intersects=false;
	

	
	public Zombie()  {
		
		
		
		setPreferredSize(new Dimension(1360,675)); 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	
		Random randData = new Random();
		
		for(int i=0;i<5;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=615;
		}

		for(int i=5;i<10;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=510;
		}		
		
		for(int i=10;i<15;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=405;
		}
		
		for(int i=15;i<20;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=300;
		}
		
		for(int i=20;i<25;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=195;
		}
		
		for(int i=25;i<30;i++) {
			arrStar[i][0] = randData.nextInt(1000);
			arrStar[i][1]=90;
		}
		
		
		for(int i=0;i<30;i++) {
			
			arrStar[i][2]=1;
		}
		
		
		

		
		try {
		img1=ImageIO.read(new File("C:\\Users\\Atiq\\Downloads\\images\\image1.jpg"));
		
		img2=ImageIO.read(new File("C:\\Users\\Atiq\\Downloads\\images\\image2.png"));
		
		img3=ImageIO.read(new File("C:\\Users\\Atiq\\Downloads\\images\\image3.png"));
		
		
		//img4=ImageIO.read(getClass().getResourceAsStream("/girl.png"));

	}catch(IOException e) {
		
		e.printStackTrace();

		
		
		
	}
	
		timer=new Timer(delay,this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		
			
				
			g.setColor(Color.yellow);
			g.fillRect(0, 0, 1420, 710);
			
			
			g.setColor(Color.green);
				
			//stair1
			for(int i=105;i<=210;i=i+21) {
				
				g.fillRect(100,i,50,5);
				
			}
		
			
			g.setColor(Color.red);
			
			g.fillRect(100,105,5, 105);
			g.fillRect(150,105,5, 105);
			

			//stair2
			
			g.fillRect(250, 315, 5, 105);
			g.fillRect(300,315, 5, 105);
				
			g.setColor(Color.green);
			
			for(int i=315;i<=420;i=i+21) {
				
				g.fillRect(255,i,45,5);
				
			}
			
			
			//stair3
			
			for(int i=210;i<=315;i=i+21) {
				
				g.fillRect(500,i,50,5);
				
			}
			g.setColor(Color.red);
		
			
			g.fillRect(500,210,5, 105);
			g.fillRect(550,210,5, 105);
			
			
			//stair4
			
			g.fillRect(500,525,5, 105);
			g.fillRect(550,525,5, 105);
			
			g.setColor(Color.green);
			
			for(int i=525;i<=735;i=i+21) {
				
				g.fillRect(505,i,45,5);
				
			}

			//stair5
			
			g.setColor(Color.green);
		
			for(int i=420;i<=525;i=i+21) {
				
				g.fillRect(900,i,50,5);
				
			}
		
			g.setColor(Color.red);
			
			g.fillRect(900,420,5, 105);
			g.fillRect(950,420,5, 105);
			
			
			

			
		
			
			
			//Draw STARS
			//balls
		
			

			g.setColor(Color.RED);
			
			for(int i=0;i<30;i++) {
				 
				if(arrStar[i][2]==1)	g.drawImage(img2,arrStar[i][0],arrStar[i][1],15,15,this);
			}
			
			
			//ways
			
			
			g.setColor(Color.black);
			
			
			for(int i=105;i<631;i+=105) {
				
				g.fillRect(0, i, 1300, 5);
				
			}
			
			
	
			
			g.drawImage(img3,x,y,40,60,this);
		
			g.drawImage(img1,1100,0,160,105, this);
			
			g.setColor(Color.RED);
			
			//Score Board
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,24));
			g.drawString("Score is: "+count,550,50);
			
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		

		if((e.getKeyCode()==KeyEvent.VK_LEFT)&&x>5) {
			
			
			x=x-5;			
			
			
		}
		
		if((e.getKeyCode()==KeyEvent.VK_RIGHT)&&x<1250) {
			
			
			x=x+5;
			
		}
		
		if((e.getKeyCode()==KeyEvent.VK_UP)&&((x>100&&x<150&&y>40&&y<355)||(x>240&&x<315&&y>245&&y<560)
				||(x>500&&x<550&&y>465&&y<670)||(x>500&&x<550&&y>145&&y<460)||(x>900&&x<950&&y>360&&y<670))) {
			
		
			y=y-5;
			
		}
		
		if((e.getKeyCode()==KeyEvent.VK_DOWN)&&((x>100&&x<150&&y>40&&y<355)||(x>240&&x<315&&y>245&&y<560)
				||(x>500&&x<550&&y>465&&y<670)||(x>500&&x<550&&y>145&&y<460)||(x>900&&x<950&&y>360&&y<670))) {
			
			
		
			
		
			y=y+5;
			
		}
		
		
		
		
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<30;i++) {
		
			if(new Rectangle(arrStar[i][0],arrStar[i][1],15,15).intersects(new Rectangle(x,y,40,60))&& arrStar[i][2]==1) {
			
				arrStar[i][2]=0;
				
				count++;
				
		
				break;
			}
		}	
			
	
		repaint();
	}
	
	

	}
