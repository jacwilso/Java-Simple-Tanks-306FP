package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Launcher{
	private Point position, justTheTip;
	private int angle, score;
	private double initialVelocity;
	private ArrayList<Projectile> missiles;
	private static final int LENGTH_ARM = 15, BARREL_X_ADJ = 30, BARREL_Y_ADJ = -8;
	public static final double GRAVITY = 9.8;
	
	public Launcher(int x, int y){
		angle = 45;
		position = new Point(x, y);
		initialVelocity = 50;
		missiles = new ArrayList<Projectile>();
		score = 0;
	}

	//Calculates the trajectory of the projectile based on the angle provided by the player
	public void showTrajectory(Graphics g, int percent){
		g.setColor(Color.RED);
		//Equations that calculate the velocity of the projectile at each point 
		double vX = initialVelocity*Math.cos(Math.toRadians(angle));
		double vY = initialVelocity*Math.sin(Math.toRadians(angle));
		//Equation that determines how long it will take for the projectile to reach the ground
		double tFinal = vY/GRAVITY + Math.sqrt(Math.pow(vY/GRAVITY,2) + 2*(position.y-justTheTip.y)/GRAVITY);
		//Equations that determine the final position of the projectile
		double x = justTheTip.x + vX * tFinal;
		double y = justTheTip.y -  vY * tFinal + 0.5*GRAVITY*Math.pow(tFinal,2);
		g.fillOval((int)(x+2),(int)(y+6), 7, 7);
		//Calculates the position of the projectile at each point in time and draws it on the screen
		for(int i=1; i<=10; i++){
			int j = i*percent/10;
			x = justTheTip.x + vX * j*tFinal/(double)100;
			y = justTheTip.y -  vY * j*tFinal/(double)100 + 0.5*GRAVITY*Math.pow(j*tFinal/(double)100,2);
			g.fillOval((int)x,(int)y, 2, 2);
		}
		int radius = 20;
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		g2.draw(new Line2D.Float(justTheTip.x, justTheTip.y, justTheTip.x+radius, justTheTip.y));
		g2.drawArc(justTheTip.x-radius/2,justTheTip.y-radius/2, radius,radius,0,angle);
	}

	//Draws the launcher (aka tank)
	public void draw(Graphics g){
		//Base of tank
		g.setColor(Color.gray);
		g.fillRect(position.x, position.y, 50, 20);
		//Smaller rectangle on top
		g.setColor(Color.darkGray);
		g.fillRect(position.x + 15, position.y - 10, 20, 10);
		//Arm of launcher
		g.setColor(Color.GRAY);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		justTheTip = new Point((int)(position.x + BARREL_X_ADJ + LENGTH_ARM*Math.cos(Math.toRadians(angle))), (int)(position.y + BARREL_Y_ADJ - LENGTH_ARM*Math.sin(Math.toRadians(angle))));
		g2.draw(new Line2D.Float(position.x + BARREL_X_ADJ, position.y + BARREL_Y_ADJ, justTheTip.x, justTheTip.y));
		//Wheels
		g.setColor(Color.darkGray);
		g.fillOval(position.x+1, position.y+8, 12, 12);
		g.fillOval(position.x+13, position.y+8, 12, 12);
		g.fillOval(position.x+25, position.y+8, 12, 12);
		g.fillOval(position.x+37, position.y+8, 12, 12);
		//Draws the red trajectory line
		showTrajectory(g, 40);
		for (int i = 0; i <missiles.size(); i++){
			//draws the projectile
			missiles.get(i).draw(g);
			//Gets rid of the projectiles in the arraylist so that a lot of space isn't taken up
			if(missiles.get(i).isFinished()){
				missiles.remove(i);
				i--;
			}
		}
	}
	
	//Creates a new projectile manually and adds it to the arraylist
	public void addProjectile(){
		missiles.add(new Projectile(justTheTip, position.y, initialVelocity, angle));
	}
	
	//adds a projectile to the arraylist
	public void addProjectile(Projectile missile){
		missiles.add(missile);
	}
	
	public int getAngle(){
		return angle;
	}
	public void move(Point p){
		position = p;
	}
	
	public void changeAngle(int a){
		angle = a%360;
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
	
	public void changeVelocity(double v){
		initialVelocity = v;
	}
	
	public double getInitialVelocity(){
		return initialVelocity;
	}
	
	public Point getTip(){
		return justTheTip;
	}
	
	//Moves the tank from one point to another
	public void moveTank(int x, int y){
		move(new Point(position.x + x, position.y + y));
	}
	
	//Changes the angle of the arm of the launcher by adding or subtracting from its current angle
	public void moveAngle(int a){
		changeAngle(angle%360 + a%360);
	}

	//Determines if the projectile hits the target
	public boolean collisionDetection(Point target, int magConstraint) {
		//If the location of the projectile is within a certain radius of the target, it is a hit
		for (int i = 0; i <missiles.size(); i++)
			if(missiles.get(i).collisionDetection(target, magConstraint)){
				return true;
			}
		return false;
	}
	
	//Determines if the projectile hits the tank and subtracts points
	public void tankCollisionDetection() {
		for(Projectile proj : missiles)
			if(proj.tankCollisionDetection(position)){
				score -= 100;
			}
	}

	public String getScore() {
		return new Integer(score).toString();
	}
	
	public int getScoreValue(){
		return score;
	}

	public void addScore(int i) {
		score += i;
		
	}
	
	public ArrayList<Projectile> getMissiles(){
		return missiles;
	}

		
}
