
public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack (5);
		
		try {
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			s.push(5);
			//La prossima push scatena un'eccezione
			s.push(6);
			//La prossima push non verrà mai eseguita
			s.push(7);
		} catch (FullStack e) {
			System.out.println ("Si è verificato il seguente errore "+e.getMessage());
		}
		
		try {
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			//La prossima pop scatena un'eccezione
			System.out.println(s.pop());
			System.out.println(s.pop());
			
		} catch (EmptyStack e) {
			System.out.println ("Si è verificato il seguente errore "+e.getMessage());
		}
		
		try {
			s.push(20);
			System.out.println(s.pop());
		} catch (EmptyStack e) {
			System.out.println ("Si è verificato il seguente errore "+e.getMessage());
		} catch (FullStack e) {
			System.out.println ("Si è verificato il seguente errore "+e.getMessage());
		}
		
		
	}

}
