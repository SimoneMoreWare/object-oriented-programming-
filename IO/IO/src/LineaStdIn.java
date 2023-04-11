import java.io.*;

public class LineaStdIn {


	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader( 
						new InputStreamReader(System.in) );
		
		String linea = in.readLine();
		
		System.out.println("Letto: " + linea);

	}

}
