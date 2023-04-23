package swing;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Authors extends JFrame{
	JRadioButton[] list = new JRadioButton[]{
	new JRadioButton("Jehoshua", true), 
	new JRadioButton("McEwan"), new JRadioButton("Stephenson"),
	new JRadioButton("Steel") };
	public Authors() {
		super("Select an author");
		setSize(140, 190);
		setLayout(new GridLayout(4,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ButtonGroup group = new ButtonGroup();
		for(JRadioButton rb : list) {
			group.add(rb); this.add(rb);
		}
		setVisible(true);
	}	public static void main (String args[]) {
		Authors newList = new Authors();	}
}
