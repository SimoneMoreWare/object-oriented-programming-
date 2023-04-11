import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class CopiaWeb {

	public final static int EOF=-1;
	
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://softeng.polito.it/courses/02CBI/");
		
		InputStream in = url.openStream();
		
		OutputStream out = new FileOutputStream("out.html");
		
		byte[] buffer = new byte[1024];
		int n;
		
		while( (n=in.read(buffer)) != EOF){
			
			out.write(buffer,0,n);
			
		}
				
		out.close();
		
	}

}
