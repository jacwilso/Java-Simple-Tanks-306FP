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

import org.junit.Test;

public class GUITests {
	/*
	@Test
	public void testBackground(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		Background gui = new Background(500,500);
		frame.add(gui);
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		//in.nextLine();
	}
	@Test
	public void TestProjectile(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		Projectile missile = new Projectile(new Point(100,100), 0, 0);
		frame.add(missile);
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		//in.nextLine();
	}

	@Test
	public void TestControlGUI(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,200));
		ControlPanel gui = new ControlPanel();
		frame.add(gui, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		//in.nextLine();
	}
	*/
	@Test
	public void combineGUI(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,700));
		frame.setLayout(new GridLayout(2,0));
		Background background = new Background(800,350, new Launcher(0, 0));
		ControlPanel control = new ControlPanel(new Launcher(0,0));
		frame.add(background);
		frame.add(control);
		
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		in.nextLine();
		background.moveTank(50,0);
		background.changeTankAngle(0);
		background.update();
		in.nextLine();

	}
}
