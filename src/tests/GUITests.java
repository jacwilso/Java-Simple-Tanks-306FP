package tests;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;

import game.Background;

import org.junit.Test;

public class GUITests {
	
	@Test
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
	
}
