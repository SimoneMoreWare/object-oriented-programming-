
import java.io.*;


public class Esempio5 {

	public final static int EOF=-1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader( new FileReader("input.txt") );
		
		String linea;
		
		while( (linea = in.readLine()) != null){
			
			System.out.println(linea);
			
		}
				
		
	}

}
