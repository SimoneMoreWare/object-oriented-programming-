package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller 
implements ActionListener {
	private Counter model;
	private View view;
	public Controller(Counter m){ model = m; }
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("+"))
			model.increment();
		else
			model.decrement();
		view.update();
	}
	public void setView(View finestra) {
		view = finestra;
	}
}
