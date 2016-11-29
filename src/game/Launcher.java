package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Launcher{
	public Point position;
	public Projectile missile;
	public int angle;
	public double initialVelocity;
	private static final int LENGTH_ARM = 15;
	
	public Launcher(int x, int y){
		angle = 75;
		position = new Point(x, y);
		initialVelocity = 0;
	}
	public void increaseAngle(int a){
		
	}
	public void decreaseAngle(int a){
		
	}
	public void showTrajectory(double percent){
		
	}
	public void draw(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(position.x, position.y, 50, 20);
		g.setColor(Color.darkGray);
		g.fillRect(position.x + 15, position.y - 10, 20, 10);
		g.setColor(Color.GRAY);
		int[] xPoints = {position.x + 35, (int) (position.x + 35 + LENGTH_ARM*Math.cos(Math.toRadians(angle))), (int) (position.x + 35 + LENGTH_ARM*Math.cos(Math.toRadians(angle + 5))), position.x + 35};
		int[] yPoints = {position.y - 10, (int) (position.y - 10 - LENGTH_ARM*Math.sin(Math.toRadians(angle))),  (int) (position.y - 5 - LENGTH_ARM*Math.sin(Math.toRadians(angle + 5))), position.y - 5};
		g.fillPolygon(xPoints, yPoints, 4);
		//g.fillRect(x, y, width, height);
		
	}
	public int getAngle(){
		return angle;
	}
	public void move(Point p){
		position = p;
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
