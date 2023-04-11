import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Esempio2 {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("input.txt");
		
		DataInputStream dis = new DataInputStream( in );
		
		int intero = dis.readInt();
		
		System.out.println("Intero: " + intero);
	}

}
