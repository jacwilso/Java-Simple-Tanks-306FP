package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Target {
	private Point position;
	private boolean hit;
	private static final int SIZE = 10;
	
	public Target(){
		hit = false;
		position = new Point(100,260);
	}
	public Target(Point position){
		hit = false;
		this.position = position;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval((int)position.x, (int)position.y, SIZE, SIZE);
		g.setColor(Color.WHITE);
		g.fillOval((int)position.x+SIZE/4, (int)position.y+SIZE/4, SIZE/2, SIZE/2);
	}

	public Point getPosition() {
		return position;
	}
	
	public void hit() {
		hit = true;
	}
	
	public boolean isHit() {
		return hit;
	}
}
