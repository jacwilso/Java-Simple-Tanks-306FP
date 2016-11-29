package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Background extends JComponent{
	private int width, height;
	private int cloudX, cloudY;
	private Launcher tank;
	private Projectile p;
	
	public Background(int width, int height, Launcher tank){
		this.width = width;
		this.height = height;
		cloudX = 100;
		cloudY = 100;
		tank.move(new Point(10,height-60));
		this.tank = tank;
		Timer timer = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//moveTank(1,0);
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
		/*** Ground ***/
		g.setColor(Color.GREEN);
		g.fillRect(0,height-50,width,50);
		//draw tank
		tank.draw(g);
		//projectile paint
	}
	public void update(){
		if(cloudX <= -10) cloudX = width;
		else cloudX-=1;
		repaint();
	}
	
	public void moveTank(int x, int y){
		tank.move(new Point(tank.getX() + x, tank.getY() + y));
	}
	
	public void changeTankAngle(int a){
		tank.changeAngle(a);
	}
}
