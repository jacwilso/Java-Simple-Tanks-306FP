package game;

import java.awt.GridLayout;
import java.awt.Point;
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
	private double initialVelocity;
	
	public Challenge(Point t){
		angleOptions = new ArrayList<Integer>();
		for(int i = 0; i <= 90; i++){
			
			if(i == 45 ){
				continue;
			}
			angleOptions.add((Integer)(i));
		}
		Collections.shuffle(angleOptions);
		tip = new Point(t.x,t.y);
		this.initialVelocity = 50;
		targetPosition = new Point((int)(50*Math.cos(Math.toRadians(45))* 5 + tip.x), (int) (50* Math.sin(Math.toRadians(45))* 5 + tip.y - .5*9.8*25));
		display();
		
	}
	public void display(){
		setSize(300,300);
		setLayout(new GridLayout(3,0));
		setTitle("Challenge Activity");
		add(new JTextField("Pick the angle that will hit the \n target with an initial velocity of 50m/s"));
		updateAngleButtons();
		JPanel options = new JPanel();
		add(angle1);
		add(angle2);
		add(angle3);
		ButtonGroup angles = new ButtonGroup();
		angles.add(angle1);
		angles.add(angle2);
		angles.add(angle3);	
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		add(ok);
		add(cancel);
		
		
	}
	
	public static Point getTargetPosition() {
		return targetPosition;
	}

	public void updateAngleButtons(){
		angle1= new JRadioButton(angleOptions.get(0).toString());
		angle2 = new JRadioButton(angleOptions.get(35).toString());
		Collections.shuffle(angleOptions);
		angle3 = new JRadioButton("45");
		
	}
	
	
	
	
}
