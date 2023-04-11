package test;
import biblioteca.*;
import javax.swing.*;
import java.awt.*; import java.awt.event.*;

public class GUITestPrestiti extends JFrame implements ActionListener

{   
	private static final long serialVersionUID = 1L;
	private JTextArea ta; 
	private JTextField tf1; private JTextField tf2;
	private Biblioteca bib = new Biblioteca();
	
	public static final String LIBRO = "newLibro";
	public static final String UTENTE = "newUtente";
	public static final String PRESTITO = "newPrestito";
	public static final String RESTITUZIONE = "restituzione";
	public static final String INCORSO = "prestitiInCorso";
	public static final String GRAD = "graduatoriaLibri";	 

public static final int LINES = 10;
public static final int CHAR_PER_LINE = 40;

public static void main(String[] args)
{	JFrame.setDefaultLookAndFeelDecorated(true);
	GUITestPrestiti gui = new GUITestPrestiti();
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.pack();
	gui.setVisible(true);}
private void addButton(String label, JPanel panel, ActionListener listener){
	JButton button = new JButton(label); 
	button.addActionListener(listener); 
	panel.add(button);}

	private JTextField addTF(String label, int length, JPanel panel){
	JTextField tf = new JTextField(label,length); 
	tf.setBackground(Color.white); panel.add(tf); return tf;}

	public GUITestPrestiti() {
	 setTitle("Prestiti"); 
	 Container contentPane = getContentPane();
	 JPanel buttonPanel = new JPanel(); buttonPanel.setBackground(Color.white);
	 addButton(LIBRO,buttonPanel,this); 
	 addButton(UTENTE,buttonPanel,this);
	 addButton(PRESTITO,buttonPanel,this);
	 addButton(RESTITUZIONE,buttonPanel,this); 
	 addButton(INCORSO,buttonPanel,this);
	 addButton(GRAD,buttonPanel,this);
	 contentPane.add(buttonPanel, BorderLayout.SOUTH);
	 JPanel textPanel = new JPanel();  textPanel.setBackground(Color.blue);
	 ta = new JTextArea(LINES, CHAR_PER_LINE);
	 ta.setBackground(Color.white); textPanel.add(ta);
	 contentPane.add(textPanel, BorderLayout.CENTER);
	 JPanel textFPanel = new JPanel(); textFPanel.setBackground(Color.white); 
	 tf1 = addTF("", 20, textFPanel); tf2 = addTF("", 10, textFPanel);
	 contentPane.add(textFPanel, BorderLayout.NORTH); }
	public void actionPerformed(ActionEvent e) 	{   
		String actionCommand = e.getActionCommand();
		ta.setText(""); String s1 = tf1.getText(); String s2 = tf2.getText();
		try{ if (actionCommand.equals(LIBRO)){
			bib.newLibro(s1, Integer.parseInt(s2)); ta.setText("done");}
		else if (actionCommand.equals(UTENTE)) {
			bib.newUtente(s1, Integer.parseInt(s2)); ta.setText("done");}
		else if (actionCommand.equals(PRESTITO)) {
			ta.setText(bib.newPrestito(s1, s2) + "");}	
		else if (actionCommand.equals(RESTITUZIONE)) {
			bib.restituzione(s1, Integer.parseInt(s2));
			ta.setText("done");	}	
		else if (actionCommand.equals(GRAD)) {
			ta.setText(bib.graduatoriaLibri());}	
		else if (actionCommand.equals(INCORSO)) {
			ta.setText(bib.prestitiInCorso());}
		}catch(BiblioEccezione ex){ta.setText(ex.getMessage());}
		 catch(NumberFormatException ex){ta.setText(ex.getMessage());}
	}
}
