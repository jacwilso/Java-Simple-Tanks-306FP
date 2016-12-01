package game;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Challenge extends JDialog{
	private JRadioButton angle1;
	private JRadioButton angle2;
	private JRadioButton angle3;
	private static Point targetPosition;
	public static ArrayList<Integer> angleOptions;
	private Point tip;
	private JButton ok;
	private JButton cancel;
	private JPanel buttons;
	private JPanel options;
	private int angle;
	private Launcher tank;
	public static final double GRAVITY = 9.8;
	
	
	public Challenge(Launcher tank){
		this.tank = tank;
		angleOptions = new ArrayList<Integer>();
		for(int i = 0; i <= 90; i++){
			
			if(i == 35 ){
				continue;
			}
			angleOptions.add((Integer)(i));
		}
		Collections.shuffle(angleOptions);
		tip = tank.getTip();
		tank.changeVelocity(50);
		targetPosition = new Point((int)(50*Math.cos(Math.toRadians(35))* 5 + tip.x), (int) (50* Math.sin(Math.toRadians(35))* 5 + tip.y - .5*GRAVITY*25));
		display();
		
	}
	public void display(){
		setSize(400,200);
		setLayout(new GridLayout(0,1));
		setTitle("Challenge Activity");
		add(new JTextField("Pick the angle that will hit the target with an initial velocity of 50m/s"));
		updateAngleButtons();
		options = new JPanel();
		options.setLayout(new GridLayout(0,3));
		options.add(angle1);
		options.add(angle2);
		options.add(angle3);
		add(options);
		ButtonGroup angles = new ButtonGroup();
		angles.add(angle1);
		angles.add(angle2);
		angles.add(angle3);	
		buttons = new JPanel();
		ok = new JButton("Ok");
		cancel = new JButton("Cancel");
		buttons.add(ok);
		buttons.add(cancel);
		add(buttons);
		ok.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		
		
	}
	
	public static Point getTargetPosition() {
		return targetPosition;
	}

	public void updateAngleButtons(){
		angle1= new JRadioButton(angleOptions.get(0).toString());
		angle2 = new JRadioButton(angleOptions.get(35).toString());
		angle3 = new JRadioButton("35");
		
	}
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(ok)){
				if(angle1.isSelected()){
					angle = angleOptions.get(0);
				}
				else if(angle2.isSelected()){
					angle = angleOptions.get(35);
				}
				else if(angle3.isSelected()){
					angle = 35;
				}
				Collections.shuffle(angleOptions);
				tank.changeAngle(angle);
				setVisible(false);
			}
			if(e.getSource().equals(cancel)){
				setVisible(false);
			}
			
		}
		
	}
	
	public int getAngle(){
		return angle;
	}
	
	
	
}
