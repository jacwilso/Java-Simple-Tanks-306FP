package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class Launcher{
	public Point position, justTheTip;
	public Projectile missile;
	public int angle;
	public double initialVelocity, vX, vY;
	private static final int LENGTH_ARM = 15, BARREL_X_ADJ = 30, BARREL_Y_ADJ = -8;
	public static final double GRAVITY = 9.8;
	
	public Launcher(int x, int y){
		angle = 45;
		position = new Point(x, y);
		initialVelocity = 50;
		vX = initialVelocity*Math.cos(Math.toRadians(angle));
		vY = initialVelocity*Math.sin(Math.toRadians(angle));
	}
	public void setAngle(int a){
		angle = a;
	}
	public void showTrajectory(Graphics g, int percent){
		double tFinal = vY/GRAVITY + Math.sqrt(Math.pow(vY/GRAVITY,2) + 2*(position.y-justTheTip.y)/GRAVITY);
		double x = justTheTip.x + vX * tFinal;
		double y = justTheTip.y -  vY * tFinal + 0.5*GRAVITY*Math.pow(tFinal,2);
		g.fillOval((int)x,(int)y, 15, 15);
		for(int i=1; i<=100; i++){
			x = justTheTip.x + vX * i*tFinal/(double)100;
			y = justTheTip.y -  vY * i*tFinal/(double)100 + 0.5*GRAVITY*Math.pow(i*tFinal/(double)100,2);
			g.fillOval((int)x,(int)y, 2, 2);
		}
	}
	public void draw(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(position.x, position.y, 50, 20);
		g.setColor(Color.darkGray);
		g.fillRect(position.x + 15, position.y - 10, 20, 10);
		g.setColor(Color.GRAY);
		/*
		int[] xPoints = {position.x + 35, (int) (position.x + 35 + LENGTH_ARM*Math.cos(Math.toRadians(angle))), (int) (position.x + 35 + LENGTH_ARM*Math.cos(Math.toRadians(angle + 5))), position.x + 35};
		int[] yPoints = {position.y - 10, (int) (position.y - 10 - LENGTH_ARM*Math.sin(Math.toRadians(angle))),  (int) (position.y - 5 - LENGTH_ARM*Math.sin(Math.toRadians(angle + 5))), position.y - 5};
		g.fillPolygon(xPoints, yPoints, 4);
		*/
		//g.fillRect(x, y, width, height);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		justTheTip = new Point((int)(position.x + BARREL_X_ADJ + LENGTH_ARM*Math.cos(Math.toRadians(angle))), (int)(position.y + BARREL_Y_ADJ - LENGTH_ARM*Math.sin(Math.toRadians(angle))));
		g2.draw(new Line2D.Float(position.x + BARREL_X_ADJ, position.y + BARREL_Y_ADJ, justTheTip.x, justTheTip.y));
		showTrajectory(g, 50);
	}
	public int getAngle(){
		return angle;
	}
	public void move(Point p){
		position = p;
	}
	
	public void changeAngle(int a){
		angle = a;
	}
	
	public Point getLocation(){
		return position;
	}
	
	public int getX(){
		return position.x;
	}
	
	public int getY(){
		return position.y;
	}
	
	public void setVelocity(double v){
		
	}
	
}
