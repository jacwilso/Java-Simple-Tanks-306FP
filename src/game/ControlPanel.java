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
	private JButton fireButton, velocityDownButton, velocityUpButton, angleDownButton, angleUpButton;
	private JTextField score, velocity, angle;
	private Launcher tank;
	
	public ControlPanel(Launcher t){
		this.tank = t;
		JPanel panel = new JPanel();
		//Fire button panel
		fireButton = new JButton("Fire");
		fireButton.setFocusable(false);
		fireButton.addActionListener(new ButtonListener());
		panel.add(fireButton);
		//Score panel
		JLabel scoreLabel = new JLabel("Score:");
		score = new JTextField(3);
		score.setEditable(false);
		panel.add(scoreLabel);
		panel.add(score);
		//Velocity panel
		velocityDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Velocity"+"</center></html>");
		velocityDownButton.setFocusable(false);
		velocityUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Velocity"+"</center></html>");
		velocityUpButton.setFocusable(false);
		velocityDownButton.addActionListener(new ButtonListener());
		velocityUpButton.addActionListener(new ButtonListener());
		velocity = new JTextField(3);
		velocity.setText(tank.getInitialVelocity() +"");
		velocity.addActionListener(new TextListner());
		panel.add(velocityDownButton);
		panel.add(velocity);
		panel.add(velocityUpButton);
		//Angle panel
		angleDownButton = new JButton("<html><center>"+"Decrease"+"<br>"+"Angle"+"</center></html>");
		angleUpButton = new JButton("<html><center>"+"Increase"+"<br>"+"Angle"+"</center></html>");
		angleDownButton.setFocusable(false);
		angleUpButton.setFocusable(false);
		angleDownButton.addActionListener(new ButtonListener());
		angleUpButton.addActionListener(new ButtonListener());
		angle = new JTextField(3);
		angle.setText(tank.getAngle() +"");
		angle.addActionListener(new TextListner());
		panel.add(angleDownButton);
		panel.add(angle);
		panel.add(angleUpButton);
		add(panel);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(fireButton)){
				tank.addProjectile();
			}
			if(e.getSource().equals(velocityDownButton)){
				tank.changeVelocity(tank.getInitialVelocity() - 1);
				velocity.setText(tank.getInitialVelocity() +"");
			}
			if(e.getSource().equals(velocityUpButton)){
				tank.changeVelocity(tank.getInitialVelocity() + 1);
				velocity.setText(tank.getInitialVelocity() +"");
			}
			if(e.getSource().equals(angleDownButton)){
				tank.changeAngle(tank.getAngle() - 5);
				angle.setText(tank.getAngle() +"");
			}
			if(e.getSource().equals(angleUpButton)){
				tank.changeAngle(tank.getAngle() + 5);
				angle.setText(tank.getAngle() +"");
			}

		}
	}
	
	private class TextListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(velocity)){
				try{
				double velocityValue = Double.parseDouble(velocity.getText());
				tank.changeVelocity(velocityValue);
				velocity.setText(tank.getInitialVelocity() +"");
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Velocity must be a decimal number.");
					velocity.setText(tank.getInitialVelocity()+"");
				}
				
			}
			if(e.getSource().equals(angle)){
				try{
				int angleValue = Integer.valueOf(angle.getText());
				tank.changeAngle(angleValue);
				angle.setText(tank.getAngle() +"");
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Angle must be an integer.");
					angle.setText(tank.getAngle() +"");
				}
			}		
		}
		
	}
		
	public void updateDisplayAngle(){

	}
	public void updateDisplayPower(){

	}
	public void updateScore(){
		
	}
}
