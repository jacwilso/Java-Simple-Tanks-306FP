package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Target {
	private Point position;
	public static final int SIZE = 24;
	
	public Target(){
		position = new Point(100,260);
	}
	public Target(Point position){
		this.position = position;
	}
	
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
	
	public void hit(int width, int height) {
		Random rand = new Random();
		position.x = rand.nextInt(width);
		position.y = rand.nextInt(height);
	}
}
