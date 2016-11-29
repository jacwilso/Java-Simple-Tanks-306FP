package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlPanel extends JPanel{
	
	public ControlPanel(){
		JPanel panel = new JPanel();
		//Fire button panel
		JButton fireButton = new JButton("Fire");
		panel.add(fireButton);
		//Score panel
		JLabel scoreLabel = new JLabel("Score:");
		JTextField score = new JTextField(3);
		panel.add(scoreLabel);
		panel.add(score);
		//Velocity panel
		JButton velocityDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Velocity"+"</center></html>");
		JButton velocityUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Velocity"+"</center></html>");
		JTextField velocity = new JTextField(3);
		panel.add(velocityDownButton);
		panel.add(velocity);
		panel.add(velocityUpButton);
		//Angle panel
		JButton angleDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Angle"+"</center></html>");
		JButton angleUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Angle"+"</center></html>");
		JTextField angle = new JTextField(3);
		panel.add(angleDownButton);
		panel.add(angle);
		panel.add(angleUpButton);
		add(panel);
	}
		
	public void updateDisplayAngle(){

	}
	public void updateDisplayPower(){

	}
	public void updateScore(){
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,200));
		ControlPanel gui = new ControlPanel();
		frame.add(gui, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
