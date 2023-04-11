import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class View extends JFrame {

	private JLabel valore;
	private JButton piu;
	private JButton meno;
	
	private Contatore model;
	private Controller controller;
	
	public View (Contatore m){
		
		model = m;
		
		setSize(400,300);
		setLocation(2000,300);
		setTitle("Esempio");
		
		//setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		valore = new JLabel("> ? <");
		
		piu = new JButton("+");
		meno = new JButton("-");
		
		add(valore,BorderLayout.CENTER);
		add(piu,BorderLayout.NORTH);
		add(meno,BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		update();
	}
	
	public void setController(Controller c){
		controller = c;
		//piu.addActionListener(c);
		//meno.addActionListener(c);
		
		piu.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				controller.clickPiu();
			}
		});

		meno.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				controller.clickMeno();
			}
		});

	}
	
	public void update(){
		
		valore.setText( String.valueOf(model.getValore()) );
		
	}
	
//	private class X implements ActionListener {
//		public void actionPerformed(ActionEvent evento){
//			
//		}
//	}
	
}
