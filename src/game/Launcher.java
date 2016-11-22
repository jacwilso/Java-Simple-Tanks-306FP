package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Launcher extends JComponent {
	private Point position;
	private Projectile missile;
	private int angle;
	private double initialVelocity;
	
	public Launcher(int x, int y){
		angle = 0;
		position = new Point(x, y);
		initialVelocity = 0;
	}
	public void increaseAngle(int a){
		
	}
	public void decreaseAngle(int a){
		
	}
	public void showTrajectory(double percent){
		
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(position.x, position.y, 50, 20);
		g.setColor(Color.darkGray);
		g.fillRect(position.x + 15, position.y - 10, 20, 10);
		g.setColor(Color.GRAY);
		g.fillRect(position.x + 35, position.y-10, 15, 5);
		
	}
	public int getAngle(){
		return angle;
	}
	public void move(Point p){
		
	}
	public Point getLocation(){
		return position;
	}
	public void increaseVelocity(double v){
		
	}
	public void decreaseVelocity(double v){
		
	}
	public double getInitialVelocity(){
		return initialVelocity;
	}
	
	
}
