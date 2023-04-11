import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Esempio3 {

	public final static int EOF=-1;
	
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("input.txt");
		
		OutputStream out = new FileOutputStream("output.txt");
		
		byte[] buffer = new byte[3];
		int n;
		
		while( (n=in.read(buffer)) != EOF){
			
			out.write(buffer,0,n);
			
		}
				
		out.close();
		
	}

}
