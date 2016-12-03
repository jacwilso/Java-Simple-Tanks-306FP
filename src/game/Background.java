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
	private int gondola1X, gondola1Y,gondola2X, gondola2Y,gondola3X, gondola3Y,gondola4X, gondola4Y,gondola5X, gondola5Y,gondola6X,gondola6Y,startX,startY, endX, endY;
	private Launcher tank;
	private Target target;
	private Bird bird;
	private boolean gondMove =true;
	private boolean ground[][];
	//Constructor sets the width and height of the background according to the size of the game screen, takes a launcher and the control panel.
	public Background(int width, int height, Launcher tank, ControlPanel control){
		this.width = width;
		this.height = height;
		cloudX = 100;
		cloudY = 100;
		gondola1X = 3*width/8-141;
		gondola1Y = height-120;
		gondola2X = gondola1X+25;
		gondola2Y = gondola1Y-25;
		gondola3X = gondola2X+25;
		gondola3Y = gondola2Y-25;
		gondola4X = gondola3X+25;
		gondola4Y = gondola3Y-25;
		gondola5X = gondola4X+25;
		gondola5Y = gondola4Y-25;
		gondola6X = gondola5X+25;
		gondola6Y = gondola5Y-25;
		startX = 3*width/8-166;
		startY = height-95;
		endX = 3*width/8-11;
		endY = height-250;
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
		int xCoord2[] = {width/4-100,3*width/8,width/2+100};
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
		int xCoord7[] = {3*width/8-175,3*width/8,3*width/8+100};
		int yCoord7[] = {height-75, height-250, height-150};
		g.fillPolygon(xCoord7, yCoord7, 3);
		g.setColor(new Color(255,255,250));
		int xCoord8[] = {7*width/8-27,7*width/8,7*width/8+26};
		int yCoord8[] = {height-160, height-200, height-160};
		g.fillPolygon(xCoord8, yCoord8, 3);
		/*** Gondolas ***/
		Graphics2D g3 = (Graphics2D) g;
		g3.setColor(Color.BLACK);
		g3.draw(new Line2D.Float(gondola1X, gondola1Y, gondola1X, gondola1Y+7));
		g3.draw(new Line2D.Float(gondola2X, gondola2Y, gondola2X, gondola2Y+7));
		g3.draw(new Line2D.Float(gondola3X, gondola3Y, gondola3X, gondola3Y+7));
		g3.draw(new Line2D.Float(gondola4X, gondola4Y, gondola4X, gondola4Y+7));
		g3.draw(new Line2D.Float(gondola5X, gondola5Y, gondola5X, gondola5Y+7));
		g3.draw(new Line2D.Float(gondola6X, gondola6Y, gondola6X, gondola6Y+7));
		g.setColor(Color.ORANGE);
		g.fillRect(gondola1X-3, gondola1Y+7, 8, 6);
		g.fillRect(gondola2X-3, gondola2Y+7, 8, 6);
		g.fillRect(gondola3X-3, gondola3Y+7, 8, 6);
		g.fillRect(gondola4X-3, gondola4Y+7, 8, 6);
		g.fillRect(gondola5X-3, gondola5Y+7, 8, 6);
		g.fillRect(gondola6X-3, gondola6Y+7, 8, 6);
		/*** Ski Lift ***/
		g3.setColor(Color.BLACK);
		g3.setStroke(new BasicStroke(10));
		g3.draw(new Line2D.Float(3*width/8-175, height-80, 3*width/8-167, height-90));
		g3.draw(new Line2D.Float(3*width/8-11, height-244, 3*width/8-5, height-251));
		g3.setStroke(new BasicStroke(1));
		g3.draw(new Line2D.Float(startX, startY, endX, endY));
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
		//Gondolas
		if(cloudX <= -10) cloudX = width;
		else cloudX-=1;
		if(gondola1Y < endY){
			gondola1X = startX;
			gondola1Y = startY;
		}
		if(gondola2Y < endY){
			gondola2X = startX;
			gondola2Y = startY;
		}
		if(gondola3Y < endY){
			gondola3X = startX;
			gondola3Y = startY;
		}
		if(gondola4Y < endY){
			gondola4X = startX;
			gondola4Y = startY;
		}
		if(gondola5Y < endY){
			gondola5X = startX;
			gondola5Y = startY;
		}
		if(gondola6Y < endY){
			gondola6X = startX;
			gondola6Y = startY;
		}
		if(gondMove){
			gondola1X+=1;
			gondola1Y-=1;
			gondola2X+=1;
			gondola2Y-=1;
			gondola3X+=1;
			gondola3Y-=1;
			gondola4X+=1;
			gondola4Y-=1;
			gondola5X+=1;
			gondola5Y-=1;
			gondola6X+=1;
			gondola6Y-=1;
			gondMove = false;
		}
		else{
			gondMove = true;
		}
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
