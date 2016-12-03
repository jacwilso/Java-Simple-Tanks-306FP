package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Bird {
	private boolean flying = true;
	private int x, y;
	private Color color;
	//code to draw the bird
	public void draw(Graphics g){
		//bird's body
		x = x - 3;
		g.setColor(color);
		g.fillOval(x,y, 20, 20);
		//eye
		g.setColor(Color.white);
		g.fillOval(x+3,y+6, 8, 8);
		g.setColor(Color.black);
		g.fillOval(x+5,y+9, 4, 4);		
		g.setColor(Color.white);
		g.fillOval(x+7,y+10, 1, 1);
		//beak
		g.setColor(Color.orange);
		int xcoord[] = {x, x-3, x};
		int ycoord[] = {y+5, y+10, y+15};
		g.fillPolygon(xcoord, ycoord, 3);
		if(x<=10)
			flying = false;
	}

	public boolean isFlying() {
		return flying;
	}
	
	public void reset(){
		//code to randomly generate the next color of the bird
		double rand = Math.random();
		if(rand > .66)
			color = Color.red;
		else
			if(rand > .33)
				color = Color.yellow;
			else
				color = Color.cyan;
		
		color = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
		flying = true;
		//set initial x position of bird
		x = 780;
		//randomly set y position of bird
		y = 50 + (int)(Math.random() * 110);
	}
	//get rid of bird if the bird is hit by a target
	public void kill(){
		flying = false;
	}

	public Point getLocation() {
		return new Point(x,y);
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
}
