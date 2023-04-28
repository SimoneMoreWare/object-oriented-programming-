package regExp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetturaCSV {

	public static class Studente{
		private String nome;
		private String cognome;
		private int matricola;
		
		public Studente(String nome,String cognome,int matricola) {
			this.nome = nome;
			this.cognome = cognome;
			this.matricola = matricola;
		}
		
		@Override
		public String toString() {
			return "(" + matricola + ") " + cognome + " " + nome;
		}
	}
		
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader r = new BufferedReader(new FileReader("esempio.csv"));
		
		List<Studente> studenti = new LinkedList<>();
		
		String linea;
		boolean first=true;
		while( (linea=r.readLine()) != null) {
			if(first) {
				first=false;
				continue;
			}
//			String[] elementi = linea.split(" *, *"); //dentro lo spilt metto espressione regolare, qui posso avere degli spazi prima o dopo
//			int matricola = Integer.parseInt(elementi[0]);
//			Studente s = new Studente(elementi[2],elementi[1],matricola);
//			studenti.add(s);
			
//			StringTokenizer st = new StringTokenizer(linea,",");
//			String matricolaStr = st.nextToken();
//			int matricola = Integer.parseInt(matricolaStr);
//			String cognome = st.nextToken();
//			String nome = st.nextToken();
//			
//			Studente s = new Studente (nome,cognome,matricola);
//			studenti.add(s);
			
			Pattern riga = Pattern.compile("(?<matricola>[0-9]{6}),"
					+"(?<cognome>[a-zA-Z ]+),"
					+"(?<nome>[a-zA-Z ]+)");
			
			Matcher m = riga.matcher(linea);
			if(m.matches()) {
				int matricola = Integer.parseInt(m.group("matricola"));
				String cognome = m.group("cognome");
				String nome = m.group("nome");
				Studente s = new Studente(nome,cognome,matricola);
				studenti.add(s);
			}
		}
		
		System.out.println(studenti);
	}

}
