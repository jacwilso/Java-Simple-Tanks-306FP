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
		JPanel firePanel = new JPanel();
		JButton fireButton = new JButton("Fire");
		panel.add(fireButton);
		//Score panel
		JPanel scorePanel = new JPanel();
		JLabel scoreLabel = new JLabel("Score:");
		JTextField score = new JTextField(3);
		panel.add(scoreLabel);
		panel.add(score);
		//Power panel
		JPanel powerPanel = new JPanel();
		JButton powerDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Power"+"</center></html>");
		JButton powerUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Power"+"</center></html>");
		JTextField power = new JTextField(3);
		panel.add(powerDownButton);
		panel.add(power);
		panel.add(powerUpButton);
		//Angle panel
		JPanel anglePanel = new JPanel();
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
