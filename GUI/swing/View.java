package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame {
	  JButton plus;
	  JLabel value;
	  JButton minus;
	  private Counter model;
	  public View(Counter c,
					 Controller controller){
		  setTitle("A Counter");
		  setSize(150,150);
		  setLayout(new BorderLayout());
		  plus = new JButton("+");
		  this.add(plus,BorderLayout.NORTH);
		  minus = new JButton("-");
		  this.add(minus,BorderLayout.SOUTH);
		  value = new JLabel("?");
		  value.setHorizontalAlignment(JLabel.CENTER);
		  this.add(value,BorderLayout.CENTER);
		  setVisible(true);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  model = c; // MODEL
		  plus.addActionListener(controller);
		  minus.addActionListener(controller);
		  controller.setView(this); // CONTROLLER --> VIEW
		  update();

	   }
	  public void update(){
		  String v = Integer.toString(model.getValue());
		  value.setText(v);
	  }
}