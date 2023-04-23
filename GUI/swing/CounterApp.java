package swing;

public class CounterApp {

	public static void main(String[] args) {
		Counter model = new Counter();
		Controller ctrl = new Controller(model);
		View view = new View(model,ctrl);

	}

}
