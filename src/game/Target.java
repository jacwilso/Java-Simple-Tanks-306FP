package game;

import java.awt.Point;

public class Target {
	private double width;
	private double height;
	private Point position;
	
	public Target(){
		position = new Point(20,20);
		width = 10;
		height = 10;
	}

	public void update(){
		
	}
	public void draw(){
		
	}
	public Point getLocation(){
		return position;
	}
}
