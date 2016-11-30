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
	
	public Projectile(Point position, double height, double velocity, int angle){
		finished = false;
		this.initialPosition = position;
		positionX = position.x;
		positionY = position.y;
		vX = velocity*Math.cos(Math.toRadians(angle));
		vY = velocity*Math.sin(Math.toRadians(angle));
		tFinal = vY/GRAVITY + Math.sqrt(Math.pow(vY/GRAVITY,2) + 2*(height - initialPosition.y)/GRAVITY);
		this.percent = 0;
		timer = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		timer.start();
	}
	
	public void update(){
		if(percent > 103){ 
			finished = true;
			timer.stop();
			return;
		}
		positionX = initialPosition.x + vX * percent*tFinal/(double)100;
		positionY = initialPosition.y -  vY * percent*tFinal/(double)100 + 0.5*GRAVITY*Math.pow(percent*tFinal/(double)100,2);
		percent++;
	}
	
	public boolean isFinished(){
		return finished;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval((int)positionX, (int)positionY, 5, 5);	
	}

	public boolean collisionDetection(Point target) {
		double mag = Math.sqrt(Math.pow(target.x-positionX,2)+Math.pow(target.y-positionY,2));
		if( mag < 4 ){
			finished = true;
			return true;
		}
		return false;
	}
}
