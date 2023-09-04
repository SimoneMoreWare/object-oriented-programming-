package gui.traduttore;

public class App {

	public static void main(String[] args) {
		
		Model modello = new Model();
		
//		View view = new View( modello );
//		
//		Controller c = new Controller( modello, view);
		
		ViewCtrl v = new ViewCtrl(modello);

	}

}
