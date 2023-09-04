package gui.traduttore;

public class Controller {

	Controller(Model m, View v){
		
		// quando si clicca sul pulsante
		// pulsante.onClick = evento => { ... }
		v.pulsante.addActionListener(
				evento -> {
					// chiama il metodo setParola sul modello
					String parola = v.parola.getText();
					m.setParola(parola);
					// aggiorna la view
					v.aggiorna();
				});
		
	}
}
