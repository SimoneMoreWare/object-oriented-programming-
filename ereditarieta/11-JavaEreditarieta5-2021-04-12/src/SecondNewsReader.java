import java.util.Observable;
import java.util.Observer;

public class SecondNewsReader implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println ("Second news Reader got the News " + (String) arg);
	}

}
