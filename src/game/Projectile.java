package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Projectile{
	//private double angle;
	private Point initialPosition;
	private double tFinal, vX, vY, positionX, positionY;
	private int percent;
	private boolean finished;
	private Timer timer;
	public final static double GRAVITY = 9.8;
	
	//Constructor for projectile that takes and sets initial position, initial height, velocity and the angle of the launcher
	public Projectile(Point position, double height, double velocity, int angle){ 
		finished = false;
		this.initialPosition = position;
		positionX = position.x;
		positionY = position.y;
		//equations to set the x and y velocity of the projectile
		vX = velocity*Math.cos(Math.toRadians(angle));
		vY = velocity*Math.sin(Math.toRadians(angle));
		//equation to find the total amount of time the projectile is in the air
		tFinal = vY/GRAVITY + Math.sqrt(Math.pow(vY/GRAVITY,2) + 2*(height - initialPosition.y)/GRAVITY);
		this.percent = 0;
		//Timer for the projectile's motion accross the screen
		timer = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		timer.start();
	}
	
	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public double getvX() {
		return vX;
	}

	public double getvY() {
		return vY;
	}

	public void update(){
		if(percent > 115){ //stops timer if the projectile has reached the end of its path
			finished = true;
			timer.stop();
			return;
		}
		//otherwise, updates x and y position of the projectile
		positionX = initialPosition.x + vX * percent*tFinal/(double)100;
		positionY = initialPosition.y -  vY * percent*tFinal/(double)100 + 0.5*GRAVITY*Math.pow(percent*tFinal/(double)100,2);
		percent++;
	}
	
	public boolean isFinished(){
		return finished;
	}
	
	public void setFinished(boolean b){
		finished = b;
	}
	
	//for drawing the projectile
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval((int)positionX, (int)positionY, 5, 5);	
	}
	//this function tests if the projectile has made contact with a target
	public boolean collisionDetection(Point target, int magConstraint) {
		double mag = Math.sqrt(Math.pow(target.x-positionX,2)+Math.pow(target.y-positionY,2));
		if( mag < magConstraint ){
			finished = true;
			return true;
		}
		return false;
	}
	//This function tests if the projectile hits the tank
	public boolean tankCollisionDetection(Point self) {
		if(!finished){
			if(((positionX<self.x+50)&&(positionX>self.x)&&(positionY<self.y+20)&&(positionY>self.y))||((positionX<self.x+35)&&(positionX>self.x+15)&&(positionY<self.y)&&(positionY>self.y-10))){
				finished = true;
				return true;
			}
		}
		return false;
	}
	
	public void setPercent(int per){
		percent = per;
	}
}
