package tests;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Scanner;

import javax.swing.JFrame;

import game.Background;
import game.ControlPanel;
import game.Launcher;
import game.Projectile;

import org.junit.BeforeClass;
import org.junit.Test;

public class GUITests {
	private static Launcher tank;
	private static ControlPanel control;
	private static Background background;
	
	@BeforeClass
	public static void setup(){
		tank = new Launcher(0,0);
		control = new ControlPanel(tank);
		background = new Background(800,350,tank,control);
	}
	
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
