package disegno;

public class AppEsempio {

	public static void main(String[] args){
		
		Schermo s = new Schermo (50,20);
		
		//Forma f = new Forma();
		//s.setPunto(10, 10);
		Gruppo disegno = new Gruppo(0,0); 
		disegno.aggiungiForma(new Punto(10,10));
		disegno.aggiungiForma(new Rettangolo(2,2,5,10));
		disegno.aggiungiForma(new Rettangolo(40,12,6,6));
		
		//...
		
		disegno.disegna(s);
		
//		for(Forma f : disegno){
//			f.disegna(s);
//		}
		
		s.visualizza();
		
	}
}
