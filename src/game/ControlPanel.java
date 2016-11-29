package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlPanel extends JPanel{
	JButton fireButton, velocityDownButton, velocityUpButton, angleDownButton, angleUpButton;
	
	
	public ControlPanel(){
		JPanel panel = new JPanel();
		//Fire button panel
		fireButton = new JButton("Fire");
		
		fireButton.addActionListener(new ButtonListener());
		panel.add(fireButton);
		//Score panel
		JLabel scoreLabel = new JLabel("Score:");
		JTextField score = new JTextField(3);
		panel.add(scoreLabel);
		panel.add(score);
		//Velocity panel
		velocityDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Velocity"+"</center></html>");
		velocityUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Velocity"+"</center></html>");
		velocityDownButton.addActionListener(new ButtonListener());
		velocityUpButton.addActionListener(new ButtonListener());
		JTextField velocity = new JTextField(3);
		panel.add(velocityDownButton);
		panel.add(velocity);
		panel.add(velocityUpButton);
		//Angle panel
		angleDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Angle"+"</center></html>");
		angleUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Angle"+"</center></html>");
		angleDownButton.addActionListener(new ButtonListener());
		angleUpButton.addActionListener(new ButtonListener());
		JTextField angle = new JTextField(3);
		panel.add(angleDownButton);
		panel.add(angle);
		panel.add(angleUpButton);
		add(panel);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(fireButton)){
				
			}
			if(e.getSource().equals(velocityDownButton)){
				
			}
			if(e.getSource().equals(velocityUpButton)){
				
			}
			if(e.getSource().equals(angleDownButton)){
				
			}
			if(e.getSource().equals(angleUpButton)){
				
			}

		}
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
