
package mainPackage;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//import java.util.Timer;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
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



public class NextLevel extends JPanel implements ActionListener,KeyListener  {
	
	
	
	public int[][] arrStar=new int[48][3];
	public int[][]arr2;
	
	private BufferedImage img1,img2,img3,img4,img5,img6,img7;
	boolean killer=true,GO=false,win=false ,sound=false,highScore=false,intersects=false, fire=true,shoot=false;

	Timer timer;
	
	public int x=1240,y=570,delay=6;
	
	public int count=48;

	
	int[][] arrNextLevel= {{150,540,1},{800,435,1},{1000,330,1},{1195,225,1},{100,120,1},{5,15,1}};
	
	int[] dirValue= {-8,-6,-5,-6,-8,-6};
	

	
	ArrayList<Integer> bullet=new ArrayList<Integer>();

	
	
	Clip clip = null;

	String number = null ;
	
	JFrame frame, frame1, frame2, frame3 ;
	
	
	
	int counter=0;
	String time;
	
	int seconds ,minutes, hours;

	
	File file=new File("resource/input.txt");

	
	public NextLevel(JFrame frame)  {
		
		this.frame=frame;
		

	
		//Game Over Picture Add
		
		
		frame1 = new JFrame();
		
		frame1.setBounds(420, 200, 590,330);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(false);
		frame1.setVisible(false);
		
		
		try
		{
			
			 img5 = ImageIO.read(getClass().getResourceAsStream("/590x330.jpg"));
			 
			 JPanel panel1 = new JPanel() {
				 
				 @Override
				    public void paintComponent(Graphics g){
				       
				        g.drawImage(img5, 0, 0,  590,330, this);
				        
				        
						
						time=String.format(" You took 0nly %2d Minutes  & %2d Seconds\n",minutes,seconds);
						
						
						
						g.setColor(Color.yellow);
						g.setFont(new Font("serif",Font.BOLD,20));
						g.drawString(time,125,280);
						
				        
				        //System.out.println(counter);
				        
				    }
			 };
			 
			 
			 panel1.setBounds(0, 725, 488, 1);
			 panel1.setForeground(Color.BLACK);
			 frame1.add(panel1);
			 
			 JButton UL = new JButton("TRY !! AGAIN !!");
			 UL.setFont(new Font("Times New Roman", Font.BOLD, 14));
			 UL.setBackground(Color.black);
			 UL.setForeground(Color.white);
			 UL.setBounds(215, 345, 90, 60);
			 panel1.add(UL);
		
			 
			 
			 
				UL.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						frame1.setVisible(false);
						
						x=-100;
						y=-100;
						MainClass main=new MainClass();
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					
					
					
					
		});
			
			 
			 
			 
			 
			 
			 
		}catch(IOException e) {

			e.printStackTrace();
			
			
			
		}
		
	//High Score Picture ADD	
		
		frame3 = new JFrame();
		
		frame3.setBounds(150,30, 1000,700);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setResizable(false);
		frame3.setVisible(false);
		
		
		try
		{
			
			 img7 = ImageIO.read(getClass().getResourceAsStream("/hs.jpg"));
			 
			 JPanel panel3 = new JPanel() {
				 
				 @Override
				    public void paintComponent(Graphics g){
				       
				        g.drawImage(img7, 0, 0,  1100,678, this);
				        
				        
						
						time=String.format("\t\t\t\tHIGH SCORE!You took only %2d Minutes  & %2d Seconds\n",minutes,seconds);
						
						
						
						g.setColor(Color.black);
						g.setFont(new Font("serif",Font.BOLD,20));
						g.drawString(time,250,650);
						
				        
				        
				        
				    }
			 };
			 
			 
			 panel3.setBounds(0, 725, 488, 1);
			 panel3.setForeground(Color.BLACK);
			 frame3.add(panel3);
			 
			 JButton UL2 = new JButton("NEW GAME");
			 UL2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			 UL2.setBackground(Color.black);
			 UL2.setForeground(Color.white);
			 UL2.setBounds(215, 345, 90, 60);
			 panel3.add(UL2);
		
			 
			 
			 
				UL2.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						frame3.setVisible(false);
						
						
						MainClass main=new MainClass();
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					
					
					
					
		});
			
			 
			 
			 
			 
			 
			 
		}catch(IOException e) {

			e.printStackTrace();
			
			
			
		}
		

	
		
		
		
		//Win Game picture Add
		
		frame2 = new JFrame();
		
		frame2.setBounds(50,80, 820,500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setResizable(false);
		frame2.setVisible(false);
		
		
		try
		{
			
			 img6 = ImageIO.read(getClass().getResourceAsStream("/win.jpg"));
			 
			 JPanel panel2 = new JPanel() {
				 
				 @Override
				    public void paintComponent(Graphics g){
				       
				        g.drawImage(img6, 0, 0,  820,500, this);
				        
				        
						time=String.format("Congrates,HERO !! YOU TOOK ONLY %2d Minutes  & %2d Seconds\n",minutes,seconds);
						
						
						
						g.setColor(Color.red);
						g.setFont(new Font("Arial",Font.BOLD,20));
						g.drawString(time,170,450);
						
				        
				        
				        
				    }
			 };
			 
			 
			 panel2.setBounds(0, 725, 488, 1);
			 panel2.setForeground(Color.BLACK);
			 frame2.add(panel2);
			 
			 JButton UL1 = new JButton("BREAK THE CHALLENGE....PLAY AGAIN.....!");
			 UL1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			 UL1.setBackground(Color.black);
			 UL1.setForeground(Color.white);
			 UL1.setBounds(400, 200, 200, 150);
			 panel2.add(UL1);
		
			 
			
			
			 
				UL1.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						frame2.setVisible(false);
						
						
						MainClass main=new MainClass();
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					
					
					
					
		});
			
			 
			 
			 
			 
			 
		}catch(IOException e) {

			e.printStackTrace();
			
			
			
		}
		



		//Menu Add
		
		MenuBar mn=new MenuBar();
		Menu menu=new Menu("Menu");
		menu.setFont(new Font("thoma",Font.BOLD,16));
		mn.setFont(new Font("thoma",Font.BOLD,16));

		
		MenuItem item1=new MenuItem("New Game");
		MenuItem item2=new MenuItem("Best Time");
		MenuItem item4=new MenuItem("Help");
		MenuItem item3=new MenuItem("Exit");
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item4);
		menu.add(item3);
		
		mn.add(menu);
		
		frame.setMenuBar(mn);
		
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				 
				
			}
			
		});
		
		
		
		
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
		    	UIManager.put("OptionPane.minimumSize",new Dimension(720,400));
		    	JOptionPane.showMessageDialog(null,"1. To finish the game you have to collect 30 stars and go to the finish point\r\n" + 
		    			"2. For control the Killer use “ARROW KEYs”\r\n" + 
		    			"3. It’s not necessary to kill all NextLevels for finishing game\r\n" + 
		    			"4. To kill NextLevels you have to press “Enter”, by pressing “Enter” killer will fire the NextLevel.\r\n" + 
		    			"5. Killer can only shoot “LEFT SIDE”\r\n" + 
		    			"6. If NextLevel and Killer intersect each other the game will be over.\r\n" + 
		    			"7. Who finish the game in minimum time, will be the High Scorer. \r\n" + 
		    			"" );
				 
				
			}
			
		});
		
		
		
		
		
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
		    	UIManager.put("OptionPane.minimumSize",new Dimension(300,100));
		    	JOptionPane.showMessageDialog(null,"Best Time is "+number+" Seconds" );
				 
				
			}
			
		});

		
		setPreferredSize(new Dimension(1360,675)); 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	
		Random randData = new Random();
		
		for(int i=0;i<8;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=615;
		}

		for(int i=8;i<16;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=510;
		}		
		
		for(int i=16;i<24;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=405;
		}
		
		for(int i=24;i<32;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=300;
		}
		
		for(int i=32;i<40;i++) {
			arrStar[i][0] = randData.nextInt(1200);
			arrStar[i][1]=195;
		}
		
		for(int i=40;i<48;i++) {
			arrStar[i][0] = randData.nextInt(1000);
			arrStar[i][1]=90;
		}
		
		
		for(int i=0;i<48;i++) {
			
			arrStar[i][2]=1;
		}
		
		
		
		
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainClass main = new MainClass();			
				
			}
			
		});
		

		
			try {
			img1=ImageIO.read(getClass().getResourceAsStream("/a2.jpg"));
			
			img2=ImageIO.read(getClass().getResourceAsStream("/b.png"));
			
			img3=ImageIO.read(getClass().getResourceAsStream("/a1.png"));
			
			img4=ImageIO.read(getClass().getResourceAsStream("/atiq.png"));
			
			
			
			
			//img5=ImageIO.read(getClass().getResourceAsStream("/590x330.jpg"));
	
		}catch(IOException e) {
			
			e.printStackTrace();
	
			
			
				
		}
	
		timer=new Timer(delay,this);
		timer.start();
		
	}
	
	

	
	public void NextLevel(JFrame f1) {
		// TODO Auto-generated constructor stub
	}




	public void paintComponent(Graphics g) {
		
			
				
			g.setColor(Color.lightGray);
			g.fillRect(0, 0, 1420, 710);
			
			
			g.setColor(Color.yellow);
				
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
				
			g.setColor(Color.yellow);
			
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
			
			g.setColor(Color.yellow);
			
			for(int i=525;i<=735;i=i+21) {
				
				g.fillRect(505,i,45,5);
				
			}

			//stair5
			
			g.setColor(Color.yellow);
		
			for(int i=420;i<=525;i=i+21) {
				
				g.fillRect(900,i,50,5);
				
			}
		
			g.setColor(Color.red);
			
			g.fillRect(900,420,5, 105);
			g.fillRect(950,420,5, 105);
			
			
			

			
		
			
			
			//Draw STARS
			//balls
		
			

			g.setColor(Color.RED);
			
			for(int i=0;i<48;i++) {
				 
				if(arrStar[i][2]==1)	g.drawImage(img2,arrStar[i][0],arrStar[i][1],15,15,this);
			}
			
			
			//ways
			
			
			g.setColor(Color.black);
			
			
			for(int i=105;i<631;i+=105) {
				
				g.fillRect(0, i, 1300, 5);
				
			}
			
			
	
		
			
			
			
			if(killer ==true) g.drawImage(img3,x,y,40,60,this);
			
			
		
		
			g.drawImage(img1,1100,0,160,105, this);
			
			g.setColor(Color.RED);
			
			//Score Board
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,24));
			g.drawString("Stones Remaing- "+count,550,30);
			
			for(int i=0;i<6;i++) {
				
				if(arrNextLevel[i][2]==1) g.drawImage(img4,arrNextLevel[i][0],arrNextLevel[i][1],100,100, this);
			}
			
			
			//bullet drawing
			
			for(int x:bullet) {
				
				g.setColor(Color.RED);
				
				if(fire==true) g.fillRoundRect(x, y+25,15,5,3,3);
				}
			
			if(shoot==true) {
				
				for(int i=0;i<1;i++) {
					
					bullet.add(x-5);
				}
				
				
				
				shoot=false;
				
			}
			
			
			


			
			if(GO==true) {
				
			
				
				frame.setVisible(false);
				
				frame1.setVisible(true);
				
				
			
				
				
				
				
				
				
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
				

				
				
				
				
			}
			
		
			
			if(win==true) {
				
			
				
				frame.setVisible(false);
				
				frame2.setVisible(true);
				
				
			
				
				
				
				
				
				
				String soundName = "C:\\Users\\Atiq\\eclipse-workspace\\ZoomBie Game\\res\\s2.wav";    
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
				

				
				
				
				
			}
			
			
			
			
			
			if(highScore==true) {
				
			
				
				frame.setVisible(false);
				
				frame3.setVisible(true);
				
				
			
				
				
				
				
				
				
				String soundName = "C:\\Users\\Atiq\\eclipse-workspace\\ZoomBie Game\\res\\s2.wav";    
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
				

				
				
				
				
			}
			
			
			 counter+=14;
			
			 seconds=(counter/1000)%60;
			 minutes=(counter/1000)/60;
			 hours=(counter/1000)/3600;
			
			
			
			time=String.format("Time||%02d:%02d:%02d\n",hours,minutes,seconds);
			
			
			
			try {
				
				
				BufferedReader read = new BufferedReader(new FileReader(file));
				//Scanner scan = new Scanner(new File("input.txt"));
				number = read.readLine();
				read.close();
				
				
			

		    	
				
				
			}catch(IOException x) {
				
				x.printStackTrace();
			}
		
			
			
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD,15));
			g.drawString(time, 5,20);
		
			g.drawString("Best Time: "+number+" Seconds", 938,20);
			
			
			
			
			
			
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		
		//System.out.println("X "+x+" "+" Y  "+y);

		if((e.getKeyCode()==KeyEvent.VK_LEFT)&&x>5&&!((y>465&&y<568)||(y>360&&y<465)||(y>255&&y<360)||(y>152&&y<254)||(y>45&&y<149))) {
			
		
			
			
			x=x-5;			
			
			
		}
		
		if((e.getKeyCode()==KeyEvent.VK_RIGHT)&&x<1200&&!((y>465&&y<568)||(y>360&&y<465)||(y>255&&y<360)||(y>152&&y<254)||(y>45&&y<149))) {
			
			
			
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
			
			//System.out.println(bullet.size());
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
			fire=true;
		}
		
		
		
		
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		/*System.out.println("X  "+x+" Y "+y);*/
		if(x==1070 && y==45 && count==0) {
			
			 
			
			

			
			
		try {
				
				
				BufferedReader read = new BufferedReader(new FileReader(file));
				
				String number = read.readLine();
				long  x;
				
				read.close();
				x= Integer.parseInt(number);// scan.nextInt();
				System.out.println(x);
					
				int totalTime= seconds+(minutes*60);
		    	 if(x>totalTime){
		    		
		    	
			    	
		    		//BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		    		FileWriter writer = new FileWriter(file);
		    		writer.write(""+totalTime);
		    		//writer.newLine();
			    	
		    		writer.close();
		    		highScore=true;
			    	
			    }
			  
			 	
				
		    	 else win=true;
				
				
				
				
			}catch(IOException x) {
				
				x.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
/*	    	UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
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
*/	    
	    	
	    }
		
		
		else if(x==1070 && y==45 && count!=0) {
			 
			 
			 
			
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 16)));       
	    	UIManager.put("OptionPane.minimumSize",new Dimension(400,200));
	    	JOptionPane.showMessageDialog(null, "Collect All Stars to finish the game :( !");
	    	
	    	
	    	x=1060;
	    	
	    	/*
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
	    	 * 
	    	 * 
	    	 * 
*/	    
	    	
	    	
	    	
	    }
		
		
		
		for(int i=0;i<30;i++) {
		
			//Star Collecting
			
			if(new Rectangle(arrStar[i][0],arrStar[i][1],15,15).intersects(new Rectangle(x,y,40,60))&& arrStar[i][2]==1) {
			
				arrStar[i][2]=0;
				
				count--;
				
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
				
					
					e1.printStackTrace();
				}
				clip.start();
				
		
				break;
			}
		}
		
		
		
		for(int i=0;i<bullet.size();i++) {
			
			for(int j=0;j<arrNextLevel.length;j++) {
				
				
				//NextLevel Kill
				
				
				 if(new Rectangle(bullet.get(i),y+15,15,5).intersects(new Rectangle(arrNextLevel[j][0],arrNextLevel[j][1],70,70))){
					
					 //bullet.removeAll(bullet);
					 
					 fire=false;
					 
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
					 
					 
						arrNextLevel[j][2]=0;
						
						
												
					

				    	
				    	
				    	
				 
					
				}
				
			
			
			}
		
		}
		
		
		
		//NextLevel run
		
		arrNextLevel[0][0]+=dirValue[0];
		arrNextLevel[1][0]-=dirValue[1];
		arrNextLevel[2][0]-=dirValue[2];
		arrNextLevel[3][0]+=dirValue[3];
		arrNextLevel[4][0]+=dirValue[4];
		arrNextLevel[5][0]+=dirValue[5];
		
		
		
		for(int i=0;i<6;i++) {
			
			if(arrNextLevel[i][0]>1200) {
				
				arrNextLevel[i][0]=1200;
				
				dirValue[i]=dirValue[i]*-1;
				
			}
			
			if(arrNextLevel[i][0]<0) {
				
				arrNextLevel[i][0]=0;
				
				dirValue[i]=dirValue[i]*-1;
				
			}
			
			
		}
		
		
		
		
		
		//bullet run
		
			
			for(int i=0;i<bullet.size();i++) {
				
				
				if(bullet.get(i)>-20 ) bullet.set(i,bullet.get(i)-4);
				
			}
			
			
			if(bullet.size()>40) bullet.removeAll(bullet);
			
		
			
			for(int j=0;j<6;j++) {
			
				 if(new Rectangle(arrNextLevel[j][0],arrNextLevel[j][1],70,70).intersects(new Rectangle(x,y,40,60)) && arrNextLevel[j][2]==1)
					{
						
					 

					    
						 //NextLevel & Killer Intersect
						
						//System.out.println("bullet"+bullet.get(i)+"  "+(y+15)+"NextLevel"+arrNextLevel[j][0]+" "+arrNextLevel[j][1]);
						
					 	
					 
					 	String soundName = "C:\\Users\\Atiq\\eclipse-workspace\\ZoomBie Game\\res\\s1.wav";    
						AudioInputStream audioInputStream = null;
						try {
							audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
						} catch (UnsupportedAudioFileException | IOException e1) {
							
							e1.printStackTrace();
						}
						
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
						
						
					

					
						
				
					 
					 
						killer=false;
						GO=true;

						
						
						 
				    /*	UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
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
						*/
						
					}
			}
		
		
		
			
	
		repaint();
	}
	
	

	}
