package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Background extends JComponent{
	private int width, height;
	private int cloudX, cloudY;
	private Launcher tank;
	private Target target;
	private Bird bird;
	private boolean ground[][];
	//Constructor sets the width and height of the background according to the size of the game screen, takes a launcher and the control panel.
	public Background(int width, int height, Launcher tank, ControlPanel control){
		this.width = width;
		this.height = height;
		cloudX = 100;
		cloudY = 100;
		//ground is an array that contains the pixels that make up the ground.
		ground = new boolean[width][50];
		for(int i=0; i<width; i++)
			for(int j=0; j<50; j++)
				ground[i][j]=true;
		//Sets the initial location for the tank
		tank.move(new Point(10,height-60));
		this.tank = tank;
		this.bird = new Bird();
		bird.reset();
		target = new Target();
		//Timer that starts for the moving clouds and birds
		Timer timer = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				update();
				//control.update();
				repaint();
			}
		});
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/*** Sky ***/
		g.setColor(Color.BLUE);
		g.fillRect(0,0,width,height);
		/*** Mountains ***/
		g.setColor(new Color(211,211,211));
		int xCoord1[] = {0,width/8,width/4+60};
		int yCoord1[] = {height-50, height-150, height-50};
		g.fillPolygon(xCoord1, yCoord1, 3);
		g.setColor(new Color(105,105,105));
		int xCoord3[] = {width/2-100,5*width/8,3*width/4+50};
		int yCoord3[] = {height-50, height-280, height-50};
		g.fillPolygon(xCoord3, yCoord3, 3);
		g.setColor(new Color(119,136,153));
		int xCoord2[] = {width/4-50,3*width/8,width/2+50};
		int yCoord2[] = {height-50, height-250, height-50};
		g.fillPolygon(xCoord2, yCoord2, 3);
		g.setColor(new Color(200,190,200));
		int xCoord4[] = {3*width/4,7*width/8,width};
		int yCoord4[] = {height-50, height-200, height-50};
		g.fillPolygon(xCoord4, yCoord4, 3);
		/*** Snow ***/
		g.setColor(new Color(255,250,255));
		int xCoord5[] = {width/8-25,width/8,width/8+40};
		int yCoord5[] = {height-125, height-150, height-125};
		g.fillPolygon(xCoord5, yCoord5, 3);
		g.setColor(new Color(250,250,255));
		int xCoord6[] = {5*width/8-100,5*width/8,5*width/8+108};
		int yCoord6[] = {height-165, height-280, height-115};
		g.fillPolygon(xCoord6, yCoord6, 3);
		g.setColor(new Color(255,250,250));
		int xCoord7[] = {3*width/8-132,3*width/8,3*width/8+75};
		int yCoord7[] = {height-75, height-250, height-150};
		g.fillPolygon(xCoord7, yCoord7, 3);
		g.setColor(new Color(255,255,250));
		int xCoord8[] = {7*width/8-27,7*width/8,7*width/8+26};
		int yCoord8[] = {height-160, height-200, height-160};
		g.fillPolygon(xCoord8, yCoord8, 3);
		/*** Ski Lift ***/
		g.setColor(Color.BLACK);
		Graphics2D g3 = (Graphics2D) g;
		g3.setStroke(new BasicStroke(10));
		g3.draw(new Line2D.Float(3*width/8-132, height-75, 3*width/8-125, height-85));
		/*** Cloud ***/
		g.setColor(Color.WHITE);
		// top cloud
		for(int i=0; i<14; i++){
		g.fillOval(cloudX	+140*(i-6), cloudY		+45*(int)Math.cos(Math.PI*i), 35, 35);
		g.fillOval(cloudX+25+140*(i-6), cloudY		+45*(int)Math.cos(Math.PI*i), 35, 35);
		g.fillOval(cloudX-25+140*(i-6), cloudY		+45*(int)Math.cos(Math.PI*i), 35, 35);
		g.fillOval(cloudX	+140*(i-6), cloudY-15	+45*(int)Math.cos(Math.PI*i), 35, 35);
		g.fillOval(cloudX+15+140*(i-6), cloudY-25	+45*(int)Math.cos(Math.PI*i), 35, 35);
		g.fillOval(cloudX-15+140*(i-6), cloudY-25	+45*(int)Math.cos(Math.PI*i), 35, 35);
		}
		/*** BUSH ***/
		g.setColor(new Color(0,100,0));
		g.fillOval(width-110,height-65, 20, 20);
		g.fillOval(width-125,height-65, 20, 20);
		g.fillOval(width-117,height-75, 20, 20);
		
		g.fillOval(width-510,height-65, 20, 20);
		g.fillOval(width-525,height-65, 20, 20);
		g.fillOval(width-517,height-75, 20, 20);
		/*** Sun ***/
		g.setColor(Color.YELLOW);
		g.fillOval(-50,-50,100,100);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		g2.draw(new Line2D.Float(0, 0, 1, 80));
		g2.draw(new Line2D.Float(0, 0, 80, 1));
		g2.draw(new Line2D.Float(0, 0, 20, 75));
		g2.draw(new Line2D.Float(0, 0, 45, 60));
		g2.draw(new Line2D.Float(0, 0, 75, 20));
		g2.draw(new Line2D.Float(0, 0, 60, 45));
		/*** Ground ***/
		g.setColor(Color.GREEN);
		/*** Tank ***/
		for(int i=0; i<width; i++)
			for(int j=0; j<50; j++)
				if(ground[i][j])
					g.fillRect(i, height-50+j, 1, 1);
		//draw tank
		tank.draw(g);
		target.draw(g);
		/*** Bird ***/
		if(bird.isFlying())
			bird.draw(g);
		else{
			if(Math.random()>0.98)
				bird.reset();
		}
	}
	
	public void update(){
		if(cloudX <= -10) cloudX = width;
		else cloudX-=1;
		//Target Collision Detection
		if(tank.collisionDetection(target.getPosition(),11)){
			target.hit(width, height);
			tank.addScore(100);
		}
		//Self Collision Detection
		tank.tankCollisionDetection();
		//Bird Collision Detection
		if(bird.isFlying()){
			if(tank.collisionDetection(bird.getLocation(),20)){
				bird.kill();
				tank.addScore(-50);
			}
		}
		//Ground Detection
		for(int i=0; i<width; i++)
			for(int j=0; j<50; j++)
				if(ground[i][j] && tank.collisionDetection(new Point(i,height-50+j),11)){
					ground[i][j]=false;
					//System.out.println(i+" "+j+" "+ground[i][j]);
					break;
				}
		repaint();
	}
	
	public void changeTankAngle(int a){
		tank.changeAngle(a);
	}
	
	public void changeTargetPosition(Point tarPosition){
		target.setPosition(tarPosition);
		repaint();
	}
	
	
		
}
