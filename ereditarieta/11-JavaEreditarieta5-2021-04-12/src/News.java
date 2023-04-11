import java.util.Observable;

public class News extends Observable{
	
	public void GenerateNews() {
	
		String[] news = {"news1", "news2", "news3"};
		
		for (String s: news) {
			
			//Emetteere una nuova news
			
			//Notifica che c'è stato un cambiamento di 
			//stato
			this.setChanged();
			notifyObservers(s);
			
			
			//Aspettare un secondo prima di emettere
			//la news successiva
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Error occurred");
			}
			
		}
		System.out.println("News terminate");
	}
	
}
