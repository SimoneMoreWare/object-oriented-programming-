package disegno;

public abstract class Forma {

	protected int posX;
	protected int posY;
	
	public Forma(int x, int y){
		posX = x;
		posY = y;
	}
	

	public abstract void disegna(Schermo s);
	
}
