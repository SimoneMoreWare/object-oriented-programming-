package gui;

import javax.swing.JFrame;

public class EsempioFinestra {

	public static void main(String[] args) {
		JFrame finestra = new JFrame();
		
		finestra.setTitle("Titolo della finestra");
		finestra.setSize(500, 400);
		
		finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		finestra.setVisible(true);
		
		
	}

}
