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

	
	public Background(int width, int height, Launcher tank){
		this.width = width;
		this.height = height;
		cloudX = 100;
		cloudY = 100;
		tank.move(new Point(10,height-60));
		this.tank = tank;
		target = new Target();
		Timer timer = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				update();
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
		g.fillRect(0,height-50,width,50);
		//draw tank
		tank.draw(g);
		target.draw(g);
	}
	
	public void update(){
		if(cloudX <= -10) cloudX = width;
		else cloudX-=1;
		if(tank.collisionDetection(target.getPosition())){
			target.hit(width, height);
		}
		repaint();
	}
	
	public void changeTankAngle(int a){
		tank.changeAngle(a);
	}
}
