package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Game extends JFrame{
	private Launcher tank;
	private Background background;
	private Obstacle obstacle;
	private ControlPanel control;
	private boolean challenge;
	private Challenge challengeGui; 
	
	public Game(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800,700));
		setLayout(new GridLayout(2,0));
		tank = new Launcher(0,0);
		background = new Background(800,350, tank);
		control = new ControlPanel(tank);
		add(background);
		add(control);
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 40 || e.getKeyCode() == 83)
					tank.moveAngle(-5);
				if(e.getKeyCode() == 39 || e.getKeyCode() == 68)
					tank.moveTank(5,0);
				if(e.getKeyCode() == 38 || e.getKeyCode() == 87)
					tank.moveAngle(5);
				if(e.getKeyCode() ==37 || e.getKeyCode() == 65)
					tank.moveTank(-5,0);
			}
			public void keyReleased(KeyEvent e) {}
		});
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		setFocusable(true);
	}
	
	public static void main(String[] args){		
		Game game = new Game();
		game.setVisible(true);
	}
}
