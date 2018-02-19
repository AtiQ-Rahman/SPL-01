package main;

import java.awt.*;
import javax.swing.*;

import game.Zombie;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
public class Panel extends JPanel {
	public boolean alwaysDraw = true;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public int ypos = 0;
	public int xpos = 0;
	public boolean zombieSpawnsPainted = false;
	public boolean bulletDataStored = false;
	private int currentZombie = 0;
	public int zombiesMax = 6;
	private boolean started = true;
	public Zombie[] zombies = new Zombie[zombiesMax];
	Panel pane; // make a panel class available throughout class
	Image zombieImage;
	Image bgImage;

	Panel() {
		setSize(WIDTH, HEIGHT);
		// load images routine:
			ImageIcon bgIMGICON = new ImageIcon("bg.jpg");
		if (bgIMGICON == null) {
			System.exit(0);
		}
	
		ImageIcon zombieIMGICON = new ImageIcon("zombie.png");
		if (zombieIMGICON == null) {
			System.exit(0);
		}
	
		for (int i = 0; i < zombiesMax; i++ ) {
			zombies[i] = new Zombie();
		}
		bgImage = bgIMGICON.getImage();
		prepareImage(bgImage, this);
		zombieImage = zombieIMGICON.getImage();
		prepareImage(zombieImage,this);
		new Timer(200, updateTimer).start();
		 new Timer(20, animateZombies).start();
	}

	Action updateTimer = new AbstractAction() { // Swing Timer
		public void actionPerformed(ActionEvent e) {
			if (alwaysDraw) {
				repaint();

			}
		}
	};


	
	Action animateZombies = new AbstractAction() { // Swing Timer
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
		int i = 0;
			for ( i = 0; i < zombiesMax; i++) {
		
	zombies[i].setX(zombies[i].getX()+5);			
			}
repaint();
			}

	};




	public void paintBg(Graphics g) {
		// draw background image:
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(bgImage, 0, 0, this);

		}

	



	public double getAngle(double a, double o) {

		double rat = o / a;
		double ang = Math.atan(rat);
		double rAng = Math.toDegrees(ang);
		if (a < 0) {
			rAng += 180;
		}
		if (o < 0 && a > 0) {
			rAng += 360;
		}

		return rAng;

	}




	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (started) {
			paintBg(g);
		
			paintZombies(g);
		} 


		setVisible(true);
	}

	public void randomizecurrentZombie() {
 currentZombie = (int)(Math.random()*zombiesMax);

	}
	public void paintSpawnLocations(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	
	
		
		
			g2d.drawImage(zombieImage, 20, 20, pane);
			zombies[currentZombie].setX(20);
			zombies[currentZombie].setY(20);
		

			g2d.drawImage(zombieImage, 20, 40, pane);
			zombies[currentZombie].setX(20);
			zombies[currentZombie].setY(40);

			g2d.drawImage(zombieImage, 20, 60, pane);
			zombies[currentZombie].setX(20);
			zombies[currentZombie].setY(60);
	
			g2d.drawImage(zombieImage, 20, 200, pane);
			zombies[currentZombie].setX(20);
			zombies[currentZombie].setY(200);

			g2d.drawImage(zombieImage, 80, 80, pane);
			zombies[currentZombie].setX(80);
			zombies[currentZombie].setY(80);
	
			g2d.drawImage(zombieImage, 20, 60, pane);
			zombies[currentZombie].setX(20);
			zombies[currentZombie].setY(60);
			zombieSpawnsPainted = true;
		}
	
	
	public void paintZombies(Graphics g) {
	//	super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (zombieSpawnsPainted == false) {
			paintSpawnLocations(g);
		}
	
		for (int i = 0; i < zombiesMax; i++) {
				double o = 400 - zombies[i].getY();
				double a = zombies[i].getX() - 400;
				double angle = Math.toRadians(getAngle(o, a));
				AffineTransform origXform = g2d.getTransform();
				AffineTransform newXform = (AffineTransform) (origXform.clone());
				newXform.rotate(angle, 400, 300);
				g2d.setTransform(newXform);
		g2d.drawImage(zombieImage, zombies[i].getX(), zombies[i].getY(),
				pane);
		repaint();
		Toolkit.getDefaultToolkit().sync();
		g2d.setTransform(origXform);
						}		     
		}
		
}
