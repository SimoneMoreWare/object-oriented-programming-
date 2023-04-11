// Scrivere una classe IO che implementi i seguenti metodi:

//Un metodo che legge un file di testo riga per riga e scrive in un nuovo file di testo solo le righe pari. 
//Il nome del file di input e output sono passati come parametro.


//Un metodo che legge riga per riga un file di testo e generi un file con le due righe seguenti:
//Numero righe lette: xx
//Numero caratteri letti: yy
//dove xx e yy sono rispettivamente il numero di righe e il numero di caratteri presenti nel file di input.
//Il nome del file di input e output sono passati come parametro.

//Un metodo che generi un file concatenando nell’ordine tutte le righe di due file di testo dati in input.
//I nomi dei file di input sono f1.txt e f2.txt mentre il nome del file generato è unione.txt




public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		IO io = new IO();
		
		io.readwriteeven("Lyrics.txt", "Even.txt");
		io.contacaratteri("Lyrics.txt", "Conta.txt");
		io.concatena();
	}

}