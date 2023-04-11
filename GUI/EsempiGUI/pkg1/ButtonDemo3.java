package pkg1;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
@SuppressWarnings("serial")
public class ButtonDemo3 extends JFrame implements ActionListener {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 100;
    int val = 0;
    JLabel labelV;
	public static void main(String[] args) {
		ButtonDemo3 gui = new ButtonDemo3();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
	public ButtonDemo3()
    {   setSize(WIDTH, HEIGHT);
        setTitle("Demo"); 
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.GRAY);
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.X_AXIS));
        JButton buttonP = new JButton("+");
        buttonP.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonP.addActionListener(this);
        contentPane.add(buttonP);
        JButton buttonM = new JButton("-");
        buttonM.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonM.addActionListener(this);
        contentPane.add(buttonM);
        labelV = new JLabel("0");
        labelV.setAlignmentY(Component.CENTER_ALIGNMENT);
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
