package disegno;

public class Gruppo extends Forma {

	private Forma[] elementi;
	
	public Gruppo(int x, int y){
		super(x,y);
		elementi = new Forma[10];
	}
	
	public void aggiungiForma(Forma f){
		for(int i=0; i<elementi.length; ++i){
			if( elementi[i] == null){
				elementi[i] = f;
				return;
			}
		}
	}
	
	@Override
	public void disegna(Schermo s) {
		for(Forma f : elementi){
			if(f!=null) f.disegna(s);
		}

	}

}
