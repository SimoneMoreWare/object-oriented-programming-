package disegno;

public class Punto extends Forma {

	public Punto(int x, int y){
		super(x,y);
		System.out.println("Punto (" + x + ", " + y + ")");
	}
	
	@Override
	public void disegna(Schermo s) {
		
		s.setPunto(posX, posY);

	}

}
