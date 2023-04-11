import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ViewAndController extends JFrame {

	private JLabel valore;
	private JButton piu;
	private JButton meno;
	
	private Contatore model;
	
	public ViewAndController (Contatore m){
		
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
		
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		piu.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				clickPiu();
			}
		});

		meno.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				clickMeno();
			}
		});
		
		
		this.addWindowListener(new WindowListener(){
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowClosing(WindowEvent arg0) {
				JOptionPane.showMessageDialog(null, "Conferma chiusura?");
			}
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

		
		update();
	}
	
	public void clickPiu(){
		model.incrementa();
		update();
	}
	
	public void clickMeno(){
		model.decrementa();
		update();
	}
	
	public void update(){
		
		valore.setText( String.valueOf(model.getValore()) );
		
	}

	
}
