package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Target {
	private Point position;
	private static final int SIZE = 10;
	
	public Target(){
		position = new Point(100,260);
	}
	public Target(Point position){
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
	
	public void hit(int width, int height) {
		Random rand = new Random();
		position.x = rand.nextInt(width);
		position.y = rand.nextInt(height);
	}
}
