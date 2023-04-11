import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class LeggiListino {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader( new FileReader("listino.txt"));

		String linea;
		
		while ( (linea=in.readLine()) != null){
		  try{
			StringTokenizer st = new StringTokenizer(linea,",");
			
			String codice = st.nextToken().trim();
			String nome = st.nextToken().trim();
			String p = st.nextToken().trim();
			double prezzo = Double.parseDouble(p);
			
			System.out.println(codice + " : " + nome + " : " + prezzo);
			
			
			
		  }catch(NoSuchElementException e){
			  System.err.println("Manca un elemento sulla linea: " + linea);
		  }catch(NumberFormatException e){
			  System.err.println("Errore formato prezzo: " + e.getMessage());
		  }
			
		}
		
	}

}
