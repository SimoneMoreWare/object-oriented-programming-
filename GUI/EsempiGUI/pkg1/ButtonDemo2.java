package pkg1;
import javax.swing.*;

import java.awt.*; 
import java.awt.event.*;
@SuppressWarnings("serial")
public class ButtonDemo2 extends JFrame implements ActionListener {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 100;
    int val;
    JLabel labelV;
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ButtonDemo2 gui = new ButtonDemo2();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
	public ButtonDemo2()
    {   setSize(WIDTH, HEIGHT);
        setTitle("Demo"); 
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.GRAY);
        contentPane.setLayout(new FlowLayout());
        JButton buttonP = new JButton("+");
        buttonP.addActionListener(this);
        contentPane.add(buttonP);
        JButton buttonM = new JButton("-");
        buttonM.addActionListener(this);
        contentPane.add(buttonM);
        String initialValue = JOptionPane.showInputDialog("Enter initial value");
        val = Integer.parseInt(initialValue);
        labelV = new JLabel(initialValue);
        contentPane.add(labelV);
        
    }
	public void actionPerformed(ActionEvent e) 
    {
       if (e.getActionCommand().equals("+")) 
    	   labelV.setText(String.valueOf(++val));
       else if (e.getActionCommand().equals("-"))
    	   labelV.setText(String.valueOf(--val));
    }
}
