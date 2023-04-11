import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Visualizzare il Character set di default usato dall JWM
		Charset c = Charset.defaultCharset();
		System.out.println ("Il charset di default della JVM è "+c.displayName());
		
		// Visualizzare tutti i Charset disponibili
		/*System.out.println ("La lista dei charset disponibili è:");
		SortedMap<String, Charset> availCS = Charset.availableCharsets();
		Iterator<String> it = availCS.keySet().iterator();
		while (it.hasNext()) {
			String csName = (String) it.next();
			System.out.println (csName);
		}*/
		
		//Utilizzare i charset
		
		Charset cs1 = Charset.forName("UTF-8");
		Charset cs2 = Charset.forName("UTF-16");
		
		String st = "Welcome to the charset example";
		//Trasformo caratteri in una sequenza di byte
		ByteBuffer bf =  ByteBuffer.wrap(st.getBytes());
		
		//Interpreta la sequenza di byte in bf come una sequenza di caratteri
		//codificati con il charset cs1 (UTF8);
		CharBuffer charbuffer = cs1.decode(bf);
		System.out.println (charbuffer);
		
		CharBuffer charbuffer1 = cs2.decode(bf);
		System.out.println ("UTF16"+charbuffer1+"fine");
		
		//STRINGHE
		
		String s1 = "ciao"; //Viene chiamato implicitamente intern
		String s2 = "ciao";
		s2 = "pippo";
		
		
		
		
		
		
		
	}

}
