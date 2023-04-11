import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class IO {

	/* Attenzione, se non specificato diversamente il path in cui viene lanciato il oprogramma da eclips è
	 * quello in cui si trova il progetto. Quindi i file se specificati con un path relativo devono esserlo a partire da
	 * quella cartella
	 */
	
	
	public void readwriteeven(String fin, String fout) {
	String s;
	int i = 1;	
        try {
            FileReader fr = new FileReader(fin);
            BufferedReader br = new BufferedReader(fr);
            FileOutputStream f = new FileOutputStream(fout);
            PrintStream os = new PrintStream(f);
            while ((s = br.readLine()) != null) {
                if (i % 2 == 0)
                     os.println(s);
                i++;
            }
            fr.close();
            os.close();
        } catch (IOException e) {
            System.out.println("Errore di input/output: " + e);
        }
    }
	

	public void contacaratteri(String fin, String fout) {
		String s;
		int i = 0;
	        int c = 0;	
	        try {
	            FileReader fr = new FileReader(fin);
	            BufferedReader br = new BufferedReader(fr);
	            FileOutputStream f = new FileOutputStream(fout);
	            PrintStream os = new PrintStream(f);
	            while ((s = br.readLine()) != null) {
	                c = c + s.length();
	                i++;
	            }
	            os.println("Numero righe lette:" + i);
	            os.println("Numero caratteri letti:" + c); 
	            fr.close();
	            os.close();
	        } catch (IOException e) {
	            System.out.println("Errore di input/output: " + e);
	        }
	        System.out.println("Fatto");
	    }
	
	public void concatena() {
		String s;	
	        try {
	            FileReader fr1 = new FileReader("f1.txt");
	            BufferedReader br1 = new BufferedReader(fr1);

	            FileReader fr2 = new FileReader("f2.txt");
	            BufferedReader br2 = new BufferedReader(fr2);

	            FileOutputStream f = new FileOutputStream("unione.txt");
	            PrintStream os = new PrintStream(f);
	            while ((s = br1.readLine()) != null) {
	                os.println(s);
	            }
	            while ((s = br2.readLine()) != null) {
	                os.println(s);
	            }
	            fr1.close();
	            fr2.close();
	            os.close();
	        } catch (IOException e) {
	            System.out.println("Errore di input/output: " + e);
	        }
	    }

	
}
