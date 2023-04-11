package disegno;

public class Schermo {

	private char[][] punti;
	
	public Schermo(int w, int h){
		punti = new char[w][h];
	}
	
	public void setPunto(int x, int y){
		punti[x][y] = '*';
	}
	
	public void visualizza(){
		
		System.out.print("+");
		System.out.print(new String(new char[punti.length]).replace("\0", "-"));
		System.out.println("+");

		for(int y=0; y<punti[0].length; ++y){
			System.out.print("|");
			for(int x=0; x<punti.length; ++x){
				if(punti[x][y]=='\0')
					System.out.print(' ');
				else
					System.out.print(punti[x][y]);
			}
			System.out.println("|");
		}
		System.out.print("+");
		System.out.print(new String(new char[punti.length]).replace("\0", "-"));
		System.out.println("+");

	}
}
