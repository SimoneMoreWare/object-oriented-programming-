
import java.io.*;


public class Esempio4 {

	public final static int EOF=-1;
	
	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("input.txt");
		
		Writer out = new FileWriter("output.txt");
		
		char[] buffer = new char[3];
		int n;
		
		while( (n=in.read(buffer)) != EOF){
			
			out.write(buffer,0,n);
			
		}
				
		out.close();
		
	}

}
