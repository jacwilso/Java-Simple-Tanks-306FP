package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class Projectile extends JComponent{
	//private double angle;
	private Point position;
	private Point2D velocity;
	public final static double GRAVITY = -32;
	
	
	public Projectile(Point position, double velocity, int angle){
		this.position = position;
		this.velocity = new Point2D.Double(velocity * Math.cos(angle), velocity * Math.sin(angle));
	}
	
	public void update(){
		//equations to update x,y locations and y velocity
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(position.x -2, position.y-2, 5, 5);	
	}
	public Point getPosition(){
		return position;
	}
	public Point2D getVelocity(){
		return velocity;
	}
}
