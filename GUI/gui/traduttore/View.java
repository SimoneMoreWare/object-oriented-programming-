package gui.traduttore;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {

	// etichetta (introduce la parola)
	JLabel l1;
	
	// campo di testo (parola)
	JTextField parola;
	
	// pulsante
	JButton pulsante;
	
	// etichetta (traduzione)
	JLabel traduzione;
	
	private Model modello;
	
	public View(Model m) {
		modello = m;
		
		setTitle("Traduttore");
		setSize(500,500);
		
		l1 = new JLabel("Parola da tradurre:");
		parola = new JTextField(10);
		pulsante = new JButton("Traduci");
		traduzione = new JLabel("-");
		
		setLayout(new FlowLayout());
		
		add(l1);
		add(parola);
		add(pulsante);
		add(traduzione);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void aggiorna() {
		
		traduzione.setText(  modello.getTraduzione() );
	}
}
