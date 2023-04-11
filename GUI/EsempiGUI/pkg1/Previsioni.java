package pkg1;
import javax.swing.*;
import java.awt.*; import java.awt.event.*;
import java.util.*;
@SuppressWarnings("serial")
public class Previsioni extends JFrame implements ActionListener
{   
public static final int LINES = 10;
public static final int CHAR_PER_LINE = 40;
private JTextArea theText; private JTextField townTF;
private JTextField tTF; private Map<String, Integer> tMap = new TreeMap<String, Integer>();
public static void main(String[] args)
{	JFrame.setDefaultLookAndFeelDecorated(true);
	Previsioni gui = new Previsioni();
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

	public Previsioni() {
	 setTitle("Previsioni"); 
	 Container contentPane = getContentPane();
	 JPanel buttonPanel = new JPanel(); buttonPanel.setBackground(Color.white);
	 addButton("Add",buttonPanel,this); 
	 addButton("Clear",buttonPanel,this);
	 addButton("All",buttonPanel,this);
	 contentPane.add(buttonPanel, BorderLayout.SOUTH);
	 JPanel textPanel = new JPanel();  textPanel.setBackground(Color.blue);
	 theText = new JTextArea(LINES, CHAR_PER_LINE);
	 theText.setBackground(Color.white); textPanel.add(theText);
	 contentPane.add(textPanel, BorderLayout.CENTER);
	 JPanel textFPanel = new JPanel(); textFPanel.setBackground(Color.white); 
	 townTF = addTF("", 20, textFPanel); tTF = addTF("", 10, textFPanel);
	 contentPane.add(textFPanel, BorderLayout.NORTH); }
	public void actionPerformed(ActionEvent e) {   
		String actionCommand = e.getActionCommand();
		theText.setText("");
		if (actionCommand.equals("Add")){
			String town = townTF.getText();
		if (town != null && !town.equals("")){
			try{tMap.put(town, Integer.valueOf(tTF.getText()));
				theText.setText("added");}
			catch(NumberFormatException ex){}
		}}
		else if (actionCommand.equals("Clear"))
			tMap.clear();
		else if (actionCommand.equals("All")){
			theText.setText(tMap.toString());}} }

