package pkg1;
import javax.swing.*;import java.awt.*;import java.awt.event.*;
@SuppressWarnings("serial")
public class ButtonDemo1a extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 100;
    int val = 0; JLabel labelV;
public static void main(String[] args) {
ButtonDemo1a gui = new ButtonDemo1a();
gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
gui.setVisible(true);}

public ButtonDemo1a(){setSize(WIDTH, HEIGHT); setTitle("Demo"); 
Container contentPane = getContentPane();
contentPane.setBackground(Color.GRAY);
contentPane.setLayout(new FlowLayout());

ActionListener lp = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		labelV.setText(String.valueOf(++val));
	}
};
ActionListener lm = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		labelV.setText(String.valueOf(--val));
	}
};
JButton buttonP = new JButton("+");buttonP.addActionListener(lp);
contentPane.add(buttonP);
JButton buttonM = new JButton("-");buttonM.addActionListener(lm);
contentPane.add(buttonM);
labelV = new JLabel("0"); contentPane.add(labelV);
}
}
