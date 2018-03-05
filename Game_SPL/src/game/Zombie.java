package main;

public class Zombie {
	public int dmg = 10;
	private int x = 0;
	private int y = 0;
private int health = 50; //figure half of player's health should be okay 
public boolean isAlive = false;
public Zombie() {
	
}
public int getHealth() {
	return health;
}
public void setHealth(int health) {
this.health = health;
}
public int getX() { 
	return x;
}
public void setX(int m_x) {
	x = m_x;
}
public int getY() {
	return y;
}
public void setY(int m_y) {
	y = m_y;
}
}
