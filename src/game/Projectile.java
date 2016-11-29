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

public class Projectile extends JComponent{
	//private double angle;
	private Point initialPosition;
	private double tFinal, vX, vY, positionX, positionY;
	private int percent;
	public final static double GRAVITY = 9.8;
	
	public Projectile(Point position, double velocity, int angle){
		this.initialPosition = position;
		vX = velocity*Math.cos(Math.toRadians(angle));
		vY = velocity*Math.sin(Math.toRadians(angle));
		tFinal = vY/GRAVITY + Math.sqrt(Math.pow(vY/GRAVITY,2) + 2*(position.y-position.y)/GRAVITY);
		this.percent = 0;
		Timer timer = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.start();
	}
	
	public void update(){
		if(percent > 100) return;
		positionX = initialPosition.x + vX * percent*tFinal/(double)100;
		positionY = initialPosition.y -  vY * percent*tFinal/(double)100 + 0.5*GRAVITY*Math.pow(percent*tFinal/(double)100,2);
		percent++;
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval((int)positionX, (int)positionY, 5, 5);	
	}
}
