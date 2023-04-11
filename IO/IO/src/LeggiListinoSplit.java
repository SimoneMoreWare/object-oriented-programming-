import java.io.*;
import java.util.StringTokenizer;

public class LeggiListinoSplit {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader( new FileReader("listino.txt"));

		String linea;
		
		while ( (linea=in.readLine()) != null){
			
			
			String[] token = linea.split(",");
			
			String codice = token[0];
			String nome = token[1];
			String p = token[2];
			double prezzo = Double.parseDouble(p);
			
			System.out.println(codice + " : " + nome + " : " + prezzo);
			
		}
		
	}

}
