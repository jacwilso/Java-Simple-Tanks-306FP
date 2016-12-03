package game;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


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
	private double vX;
	private double vY;
	private double tFinal;
	private Point initialPosition;
	private ControlPanel control;
	private Integer randAngle;
	ArrayList<Integer> locations;
	
	
	public Challenge(Launcher tank, ControlPanel c){
		control = c;
		Random rand = new Random();
		randAngle = rand.nextInt(90);
		vX = 50*Math.cos(Math.toRadians(randAngle));
		vY = 50* Math.sin(Math.toRadians(randAngle));
		initialPosition = tank.getTip();
		tFinal = vY/GRAVITY + Math.sqrt(Math.pow(vY/GRAVITY,2) + 2*(tank.getY() - initialPosition.y)/GRAVITY);
		this.tank = tank;
		angleOptions = new ArrayList<Integer>();
		for(int i = 0; i <= 90; i++){
			
			if(i == randAngle ){
				continue;
			}
			angleOptions.add((Integer)(i));
		}
		Collections.shuffle(angleOptions);
		tank.changeVelocity(50);
		targetPosition = new Point((int)(vX *0.6*tFinal + initialPosition.x), (int) (initialPosition.y- vY*0.6*tFinal + 0.5*GRAVITY*Math.pow(0.6*tFinal,2)));
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
		options.setBorder(new TitledBorder (new EtchedBorder(), "Angle Options"));
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
		locations = new ArrayList<Integer>();
		locations.add(angleOptions.get(0));
		locations.add(angleOptions.get(35));
		locations.add(randAngle);
		Collections.shuffle(locations);
		angle1= new JRadioButton(locations.get(0).toString());
		angle2 = new JRadioButton(locations.get(1).toString());
		angle3 = new JRadioButton(locations.get(2).toString());
		
	}
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(ok)){
				if(angle1.isSelected()){
					angle = locations.get(0);
				}
				else if(angle2.isSelected()){
					angle = locations.get(1);
				}
				else if(angle3.isSelected()){
					angle = locations.get(2);
				}
				Collections.shuffle(angleOptions);
				tank.changeAngle(angle);
				tank.changeVelocity(50);
				control.update();
				tank.addProjectile();
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
