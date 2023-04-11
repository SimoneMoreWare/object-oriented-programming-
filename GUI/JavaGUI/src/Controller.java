import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {
	
	private Contatore model;
	private View view;
	
	public Controller(Contatore m, View v){
		model = m;
		view = v;
		view.setController(this);
	}
	
	public void clickPiu(){
		model.incrementa();
		view.update();
	}
	
	public void clickMeno(){
		model.decrementa();
		view.update();
	}


	public void actionPerformed(ActionEvent evento) {
		
		System.out.println("Pulsante premuto!! " + evento.getActionCommand());
		if(evento.getActionCommand().equals("+")){
			clickPiu();
		}
		if(evento.getActionCommand().equals("-")){
			clickMeno();
		}
		
	}
	

}
