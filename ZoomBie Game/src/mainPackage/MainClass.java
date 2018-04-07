package mainPackage;

import java.io.IOException;

import javax.swing.JFrame;

public class MainClass {

	 
	public static void main(String[] args) throws IOException{
		
		Zombie z1 = new Zombie();
		
		
		JFrame f1 = new JFrame("<--SPL-->"); //frame er object nilam
		f1.setSize(1300,675);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.add(z1);
		f1.setVisible(true);
		
		f1.setResizable(false);
		
	
		
		
				
	}

		
}

