package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Target {
	private Point position;
	public static final int SIZE = 24;
	
	public Target(){
		//sets initial location for the first target
		//x and y coordinates are the center of the target
		position = new Point(100,260);
	}
	public Target(Point position){
		this.position = position;
	}
	//code for drawing the target
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval((int)position.x-SIZE/2, (int)position.y-SIZE/2, SIZE, SIZE);
		g.setColor(Color.WHITE);
		g.fillOval((int)position.x+SIZE/6-SIZE/2, (int)position.y+SIZE/6-SIZE/2, 2*SIZE/3, 2*SIZE/3);
		g.setColor(Color.RED);
		g.fillOval((int)position.x+SIZE/3-SIZE/2, (int)position.y+SIZE/3-SIZE/2, SIZE/3, SIZE/3);
	}

	public Point getPosition() {
		return position;
	}
	//if a projectile hits the target, randomly change the x and y coordinates according to the size of the screen
	public void hit(int width, int height) {
		Random rand = new Random();
		position.x = rand.nextInt(width-2*SIZE) + SIZE;
		position.y = rand.nextInt(height-2*SIZE) + SIZE;
	}
	
	public void setPosition(Point p){
		position = p;
	}
}
