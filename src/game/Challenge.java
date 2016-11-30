package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Challenge extends JDialog{
	private JRadioButton angle1;
	private JRadioButton angle2;
	private JRadioButton angle3;
	private Point targetPosition;
	public static ArrayList<Integer> angleOptions;
	
	public Challenge(){
		for(int i = 0; i <= 90; i++){
			angleOptions.add(i);
		}
		Collections.shuffle(angleOptions);
	}
	
	public void updateAngleButtons(){
		angle1= new JRadioButton(angleOptions.get(0).toString());
	}
	
	
	
}
