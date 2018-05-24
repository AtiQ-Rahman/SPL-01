package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;



public class MainClass {

	public   JFrame frame;
	private  JLabel background_1;
	private  JLabel background_2;
	private  JPanel jp_1;
	File file=new File("resource/input.txt");
	String number = null ;
	
	public MainClass() {
		
		initialize();
	}
	 
	public static void main(String[] args) throws IOException{
		
		MainClass mainclass=new MainClass();
		
	}
	
	public void initialize() {
		
		JPanel jp=null;
		JLabel background=null;
		BufferedImage img;
		
		frame = new JFrame();
		frame.setBounds(420, 35, 400, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		try
		{
			
		 img = ImageIO.read(getClass().getResourceAsStream("/IIT1.png")); 
		 jp_1=new JPanel() {
			 
			 	@Override
			    public void paintComponent(Graphics g){
			       
			        g.drawImage(img, 0, 0,400,690, this);
			        
			    }
		 };
		 
		
		 
		
		 
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
		frame.getContentPane().add(jp_1);
		
		JButton btnNewButton_1 = new JButton("New Game");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(153, 255, 51));
		btnNewButton_1.setBounds(130, 300, 145, 32);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
					
					frame.setVisible(false);
					
					
					JFrame f1 = new JFrame("<--SPL-->"); //frame er object nilam
					
					Zombie z1 = new Zombie(f1);
					f1.setSize(1300,700);
					f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f1.add(z1);
					f1.setVisible(true);
					
					
					
					f1.setResizable(false);
				
				}
				
		});
		jp_1.setLayout(null);
		jp_1.add(btnNewButton_1);
		
		
		
		
		
		
		
		
		
		JButton BestTime = new JButton("Best Time");
		BestTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		BestTime.setBackground(Color.RED);
		BestTime.setBounds(140, 350, 126, 32);
		jp_1.add(BestTime);
		
		BestTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					
					BufferedReader read = new BufferedReader(new FileReader(file));
					
					number = read.readLine();
					read.close();
					
					
					
					
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
					UIManager.put("OptionPane.minimumSize",new Dimension(350,250));
					JOptionPane.showMessageDialog(null,"Best Time is "+number+" Seconds" );
					
					
					
					
				}catch(IOException x) {
					
					x.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		
				

				
				
				
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(173, 450, 60, 32);
		jp_1.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.setVisible(false);
			}
		});
		
				
				
				
				
		
		
		JButton btn = new JButton("Help");
		btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn.setBackground(new Color(153, 255, 51));
		btn.setBounds(160, 400, 83, 32);
		jp_1.add(btn);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font( "Arial", Font.BOLD, 18)));       
		    	UIManager.put("OptionPane.minimumSize",new Dimension(720,400));
		    	JOptionPane.showMessageDialog(null,"1. To finish the game you have to collect 30 stars and go to the finish point\r\n" + 
		    			"2. For control the Killer use “ARROW KEYs”\r\n" + 
		    			"3. It’s not necessary to kill all zombies for finishing game\r\n" + 
		    			"4. To kill zombies you have to press “Enter”, by pressing “Enter” killer will fire the zombie.\r\n" + 
		    			"5. Killer can only shoot “LEFT SIDE”\r\n" + 
		    			"6. If Zombie and Killer intersect each other the game will be over.\r\n" + 
		    			"7. Who finish the game in minimum time, will be the High Scorer. \r\n" + 
		    			"" );
				 
				
				
				
				
				
			}
		});
		
	frame.setVisible(true);
				
	}

		
}

