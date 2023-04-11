package disegno;

public class Rettangolo extends Forma {

	private int larg;
	private int alt;
	
	public Rettangolo(int x, int y, int l, int a){
		super(x,y);
		this.larg = l;
		this.alt = a;
	}
	
	@Override
	public void disegna(Schermo s) {
		for(int xi=0; xi<larg;++xi){
			for(int yi=0; yi<alt;++yi){
				s.setPunto(posX+xi, posY + yi);
			}
		}

	}

}
