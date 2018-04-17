package mainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainClass {

	public   JFrame frame;
	private  JLabel background_1;
	private  JLabel background_2;
	private  JPanel jp_1;
	
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
		frame.setBounds(100, 100, 384, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		try
		{
			
		 img = ImageIO.read(getClass().getResourceAsStream("/images4.jpg")); 
		 jp_1=new JPanel() {
			 
			 	@Override
			    public void paintComponent(Graphics g){
			       
			        g.drawImage(img, 0, 0,468,600, this);
			        
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
		btnNewButton_1.setBounds(105, 160, 121, 32);
		btnNewButton_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
					
					frame.setVisible(false);
					
					
					JFrame f1 = new JFrame("<--SPL-->"); //frame er object nilam
					
					Zombie z1 = new Zombie(f1);
					f1.setSize(1300,700);
					f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f1.add(z1);
					f1.setVisible(true);
					
					
					
					f1.setResizable(true);
				
				}
				
		});
		jp_1.setLayout(null);
		jp_1.add(btnNewButton_1);
		
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(125, 295, 78, 32);
		jp_1.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.setVisible(false);
			}
		});
		
		
		
		
		
		
		//background.setLayout(new FlowLayout());
		/*JLabel l1=new JLabel("Here is a button");
		JButton b1=new JButton("I am a button");
		frame.getContentPane().add(background);
		background.add(l1);
		background.add(b1);*/
		//frame.setSize(new Dimension(img.getWidth(null), img.getHeight(null)));

		
		frame.setVisible(true);
		
		
		
		
	

		
				
	}

		
}

