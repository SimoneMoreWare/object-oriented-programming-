import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Esempio1 {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("input.txt");
		
		int carattere = in.read();
		
		// 1 --> 0x00 00 00 31 = 49
		// EOF --> 0xff ff ff ff = -1
		// ch --> 0x00 00 xx xx 
		// b -->  0x00 00 00 xx
		
		char ch = (char)carattere;
		byte b = (byte)carattere;

		System.out.println("Letto: " + ch);
		
	}

}
