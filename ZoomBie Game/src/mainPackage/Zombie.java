package mainPackage;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//import java.util.Timer;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;



public class Zombie extends JPanel implements ActionListener,KeyListener  {
	
	
	
	public int[][] arrStar=new int[30][3];
	public int[][]arr2;
	
	private BufferedImage img1,img2,img3,img4;
	Timer timer;
	public int x=1250,y=570,delay=6;
	
	public int count=0;
	boolean intersects=false;
	
	int[][] arrZombie= {{150,540,1},{800,435,1},{1000,330,1},{1195,225,1},{100,120,1},{5,15,1}};
	
	int[] dirValue= {-5,-3,-2,-1,-4,-3};
	
	boolean shoot=false;
	
	ArrayList<Integer> bullet=new ArrayList<Integer>();
	int[] difference= {5,40,75,110,145};

	
	public Zombie(JFrame frame)  {
		
		
		MenuBar mn=new MenuBar();
		Menu menu=new Menu("Menu");
		menu.setFont(new Font("thoma",Font.BOLD,16));
		mn.setFont(new Font("thoma",Font.BOLD,16));

		
		MenuItem item1=new MenuItem("New Game");
		MenuItem item2=new MenuItem("Highest Score");
		MenuItem item3=new MenuItem("Exit");
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		
		mn.add(menu);
		
		frame.setMenuBar(mn);
		
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				 
				
			}
			
		});

		
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
		
		
		
		
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
				
				
				
			}
			
		});
		

		
			try {
			img1=ImageIO.read(getClass().getResourceAsStream("/a2.jpg"));
			
			img2=ImageIO.read(getClass().getResourceAsStream("/b.png"));
			
			img3=ImageIO.read(getClass().getResourceAsStream("/a1.png"));
			
			img4=ImageIO.read(getClass().getResourceAsStream("/atiq.png"));
			
			
			
			
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
				
				g.fillRect(650,i,50,5);
				
			}
		
			
			g.setColor(Color.red);
			
			g.fillRect(650,105,5, 105);
			g.fillRect(700,105,5, 105);
			

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
			
			for(int i=0;i<6;i++) {
				
				if(arrZombie[i][2]==1) g.drawImage(img4,arrZombie[i][0],arrZombie[i][1],100,100, this);
			}
			
			
			
			
			for(int x:bullet) {
				
				g.setColor(Color.RED);
				g.fillRoundRect(x, y+25,15,5,3,3);
			}
			
			if(shoot==true) {
				
				for(int i=0;i<1;i++) {
					
					bullet.add(x-difference[i]);
				}
				
				
				
				shoot=false;
				
			}
			
			
		
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
		
		if((e.getKeyCode()==KeyEvent.VK_UP)&&((x>645&&x<680&&y>45&&y<258)||(x>245&&x<265&&y>258&&y<465)
				||(x>495&&x<515&&y>465&&y<670)||(x>495&&x<520&&y>152&&y<360)||(x>895&&x<920&&y>360&&y<560))) {
			
		
			y=y-5;
			
		}
		
		if((e.getKeyCode()==KeyEvent.VK_DOWN)&&((x>645&&x<680&&y>0&&y<158)||(x>245&&x<265&&y>158&&y<365)
				||(x>495&&x<515&&y>365&&y<570)||(x>495&&x<515&&y>52&&y<260)||(x>895&&x<920&&y>260&&y<460))) {
		
			
		
			y=y+5;
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
			System.out.println(bullet.size());
			String soundName = "C:\\Users\\Atiq\\eclipse-workspace\\ZoomBie Game\\res\\Gun+1.wav";    
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			} catch (UnsupportedAudioFileException | IOException e1) {
				
				e1.printStackTrace();
			}
			Clip clip = null;
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			}
			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clip.start();
			
			shoot=true;
		}
		
		
		
		
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		
		if(x==1075 && y==45 ) {
			 
			 
			 
			 
	    	UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
	    	UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
	    	JOptionPane.showMessageDialog(null, "Level Complete");
	    	
	    	
	    	try        
	    	{
	    	    Thread.sleep(1000);
	    	} 
	    	catch(InterruptedException ex) 
	    	{
	    	    Thread.currentThread().interrupt();
	    	}
	    	
	    	System.exit(0);
	    	
	    	//g.setVisible(false);
	    
	    	
	    }
		
		
		for(int i=0;i<30;i++) {
		
			if(new Rectangle(arrStar[i][0],arrStar[i][1],15,15).intersects(new Rectangle(x,y,40,60))&& arrStar[i][2]==1) {
			
				arrStar[i][2]=0;
				
				count++;
				
				String soundName = "C:\\Users\\Atiq\\eclipse-workspace\\ZoomBie Game\\res\\s.wav";    
				AudioInputStream audioInputStream = null;
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				} catch (UnsupportedAudioFileException | IOException e1) {
					
					e1.printStackTrace();
				}
				Clip clip = null;
				try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
				try {
					clip.open(audioInputStream);
				} catch (LineUnavailableException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clip.start();
				
		
				break;
			}
		}
		
		
		
		for(int i=0;i<bullet.size();i++) {
			
			for(int j=0;j<arrZombie.length;j++) {
				
				 if(new Rectangle(bullet.get(i),y+15,15,5).intersects(new Rectangle(arrZombie[j][0],arrZombie[j][1],100,100))){
					
					
					 
					 String soundName = "C:\\Users\\Atiq\\eclipse-workspace\\ZoomBie Game\\res\\8.wav";    
						AudioInputStream audioInputStream = null;
						try {
							audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
						} catch (UnsupportedAudioFileException | IOException e1) {
							
							e1.printStackTrace();
						}
						Clip clip = null;
						try {
							clip = AudioSystem.getClip();
						} catch (LineUnavailableException e1) {
							e1.printStackTrace();
						}
						try {
							clip.open(audioInputStream);
						} catch (LineUnavailableException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						clip.start();
					 
					 
					 
					 arrZombie[j][2]=0;
					
					
					
					
				}
				 else if(new Rectangle(arrZombie[j][0],arrZombie[j][1],20,20).intersects(new Rectangle(x,y,20,20)) && arrZombie[j][2]==1)
				{
					
					
					//System.out.println("bullet"+bullet.get(i)+"  "+(y+15)+"zombie"+arrZombie[j][0]+" "+arrZombie[j][1]);
					
					
					 
			    	UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
			    	UIManager.put("OptionPane.minimumSize",new Dimension(200,100));
			    	JOptionPane.showMessageDialog(null, "Loser");
			    	
			    	
			    	try        
			    	{
			    	    Thread.sleep(1000);
			    	} 
			    	catch(InterruptedException ex) 
			    	{
			    	    Thread.currentThread().interrupt();
			    	}
			    	
			    
		    	
					System.exit(0);
					
					
				}
			
			
			}
		
		}
		
		
		
		//zombie run
		
		arrZombie[0][0]+=dirValue[0];
		arrZombie[1][0]-=dirValue[1];
		arrZombie[2][0]-=dirValue[2];
		arrZombie[3][0]+=dirValue[3];
		arrZombie[4][0]+=dirValue[4];
		arrZombie[5][0]+=dirValue[5];
		
		
		
		for(int i=0;i<6;i++) {
			
			if(arrZombie[i][0]>1200) {
				
				arrZombie[i][0]=1200;
				
				dirValue[i]=dirValue[i]*-1;
				
			}
			
			if(arrZombie[i][0]<0) {
				
				arrZombie[i][0]=0;
				
				dirValue[i]=dirValue[i]*-1;
				
			}
			
			
		}
		
		
		
		
		
		//bullet run
		
			
			for(int i=0;i<bullet.size();i++) {
				
				
				if(bullet.get(i)>-20 ) bullet.set(i,bullet.get(i)-4);
				
			}
			
			
			if(bullet.size()>40) bullet.removeAll(bullet);
			
		
		
		
		
			
	
		repaint();
	}
	
	

	}
