package tests;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Scanner;

import javax.swing.JFrame;

import game.Background;
import game.Launcher;
import game.Projectile;

import org.junit.Test;

public class GUITests {
	
	//@Test
	public void testBackground(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		Background gui = new Background(500,500);
		frame.add(gui);
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		in.nextLine();
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
		in.nextLine();
	}
	@Test
	public void TestLauncher(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		Launcher tank = new Launcher(30, 450);
		frame.add(tank);
		frame.setVisible(true);
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
}
