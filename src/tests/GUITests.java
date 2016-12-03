package tests;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Scanner;

import javax.swing.JFrame;

import game.Background;
import game.ControlPanel;
import game.Game;
import game.Launcher;
import game.Projectile;

import org.junit.BeforeClass;
import org.junit.Test;

public class GUITests {
	private static Launcher tank;
	private static ControlPanel control;
	private static Background background;
	private static Game game;
	
	@BeforeClass
	public static void setup(){
		game = new Game();
		tank = new Launcher(0,0);
		control = new ControlPanel(tank);
		background = new Background(800,350,tank,control);
	}
	
	//Shows the control GUI
	@Test
	public void TestControlGUI(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,200));
		frame.add(control, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
	
	//shows the background
	@Test
	public void testBackground(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		frame.add(background);
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
	
	//shows the background and the control GUI
	@Test
	public void combineGUI(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,450));
		frame.add(background,BorderLayout.CENTER);
		frame.add(control,BorderLayout.SOUTH);	
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}

}
