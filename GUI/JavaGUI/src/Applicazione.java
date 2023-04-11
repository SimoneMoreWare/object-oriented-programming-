
public class Applicazione {

	public static void main(String[] args) {
		
		Contatore m = new Contatore();
		
		View v = new View(m);
		
		Controller c = new Controller(m,v);

	}

}
