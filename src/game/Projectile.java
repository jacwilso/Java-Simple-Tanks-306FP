package game;

import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.JPanel;


public class Projectile extends JPanel{
	//private double angle;
	private Point position;
	private Point2D velocity;
	public final static double GRAVITY = -32;
	public Projectile(Point position, double velocity, int angle){
		this.position = position;
		this.velocity = new Point2D.Double(velocity * Math.cos(angle), velocity * Math.sin(angle));
	}
	public void update(){
		
	}
	public void draw(){
		
	}
	public Point getPosition(){
		return position;
	}
	public Point2D getVelocity(){
		return velocity;
	}
}
