package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Background extends JComponent{
	private int width, height;
	private int cloudX, cloudY;
	
	public Background(int width, int height){
		this.width = width;
		this.height = height;
		cloudX = 100;
		cloudY = 100;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/*** Sky ***/
		g.setColor(Color.BLUE);
		g.fillRect(0,0,width,height);
		/*** Cloud ***/
		g.setColor(Color.WHITE);
		// top cloud
		g.fillOval(cloudX, cloudY, 		35, 35);
		g.fillOval(cloudX+25, cloudY, 	35, 35);
		g.fillOval(cloudX-25, cloudY, 	35, 35);
		g.fillOval(cloudX, cloudY-15, 	35, 35);
		g.fillOval(cloudX+15, cloudY-25, 35, 35);
		g.fillOval(cloudX-15, cloudY-25, 35, 35);

		g.fillOval(cloudX	+140, cloudY	+90, 35, 35);
		g.fillOval(cloudX+25+140, cloudY	+90, 35, 35);
		g.fillOval(cloudX-25+140, cloudY	+90, 35, 35);
		g.fillOval(cloudX	+140, cloudY-15	+90, 35, 35);
		g.fillOval(cloudX+15+140, cloudY-25	+90, 35, 35);
		g.fillOval(cloudX-15+140, cloudY-25	+90, 35, 35);
		/*** Sun ***/
		g.setColor(Color.YELLOW);
		g.fillOval(-50,-50,100,100);
		/*** Ground ***/
		g.setColor(Color.GREEN);
		g.fillRect(0,height-50,width,50);
	}
	public void update(){
		if(cloudX <= 0) cloudX = width;
		else cloudX-=5;
		System.out.println("MOVE");
		repaint();
	}
}
