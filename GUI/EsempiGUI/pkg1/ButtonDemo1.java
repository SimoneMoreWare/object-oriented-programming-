package pkg1;
import javax.swing.*;import java.awt.*;import java.awt.event.*;
@SuppressWarnings("serial")
public class ButtonDemo1 extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 100;
    int val = 0; JLabel labelV;
public static void main(String[] args) {
ButtonDemo1 gui = new ButtonDemo1();
gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
gui.setVisible(true);}
public ButtonDemo1(){setSize(WIDTH, HEIGHT); setTitle("Demo"); 
Container contentPane = getContentPane();
contentPane.setBackground(Color.GRAY);
contentPane.setLayout(new FlowLayout());
Listener l = new Listener();
JButton buttonP = new JButton("+");buttonP.addActionListener(l);
contentPane.add(buttonP);
JButton buttonM = new JButton("-");buttonM.addActionListener(l);
contentPane.add(buttonM);
labelV = new JLabel("0"); contentPane.add(labelV);
}
private class Listener implements ActionListener {
	public void actionPerformed(ActionEvent e) 
    {
       if (e.getActionCommand().equals("+")) 
    	   labelV.setText(String.valueOf(++val));
       else if (e.getActionCommand().equals("-"))
    	   labelV.setText(String.valueOf(--val));
    }
}
}
