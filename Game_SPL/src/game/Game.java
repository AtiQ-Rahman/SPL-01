package main;

//JPanel (Panel.java) is added to this JFrame
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
public class Game extends JFrame{

	public JLabel health = new JLabel("Health = 0 |" );
	public JLabel scoreAndTime = new JLabel(" Score: 0 | Time: 0.00");
	public int playerHealth = 0;
	public int enemyHealth = 0;
	public int score = 0;
	public double time = 0.00;
	Panel panel;
	Game() {
		super("Last Stand");		
		panel = new Panel();
		setSize(800,600);
		//just working with JPanel atm
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		getContentPane().setCursor(blankCursor);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Game();
	}
}
