package regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EspressioniRegolari {

	public static void main(String[] args) {
		
		
		//passo espressione regolare passata come stringa
		Pattern re = Pattern.compile("[a-zA-Z0-9]+"); //passo le lettere comprese tra a-z, A-Z e 0-9, il + dice uno o più volte
		
		String input = "1unIdentificatore";
		
		Matcher m = re.matcher(input); //risultato del riconoscimento
		
		boolean riconosciuto = m.matches(); //risultato riconoscimento, riconoscere stringa come espressione regolare
		
		System.out.println("Riconosciuto : " + riconosciuto);
		
		re = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*"); //voglio che il prima carattere sia una lettera e che sia seguito da qualsiasi tipo di carattere
		
		input = "2";
		
		m = re.matcher(input); //risultato del riconoscimento
		
		riconosciuto = m.matches(); //risultato riconoscimento
		
		System.out.println("Riconosciuto : " + riconosciuto);	
		
		re = Pattern.compile("\\w*"); //w è un qualunche carattere word
		
		input = "UNA_COSTANTE";
		
		m = re.matcher(input); //risultato del riconoscimento
		
		riconosciuto = m.matches(); //risultato riconoscimento
		
		System.out.println("Riconosciuto : " + riconosciuto);		
		
		/*
		 * Questa espressione regolare rappresenta un pattern per riconoscere gli indirizzi email validi. Nel dettaglio, il pattern contiene i seguenti elementi:

			"[A-Za-z0-9_.]+" rappresenta una sequenza di almeno un carattere alfanumerico (lettera maiuscola o minuscola o numero) o il carattere underscore o il punto. Questa sequenza corrisponde alla parte locale dell'indirizzo email, ovvero la parte prima della @.
			"@([a-zA-Z.]+)" rappresenta la @ e la parte successiva dell'indirizzo email, che corrisponde al dominio dell'indirizzo email. Il dominio può essere costituito da lettere maiuscole o minuscole o il punto. Questo gruppo di parentesi tonde è usato per catturare il nome del dominio per usarlo in una successiva analisi.
			"(\.[a-zA-Z]+)+" rappresenta il TLD (Top Level Domain) dell'indirizzo email. È costituito da un punto seguito da una o più lettere maiuscole o minuscole. L'uso dei doppi backslash è necessario per "escapare" il punto, in quanto il punto è un carattere speciale in un'espressione regolare. Il "+" dopo il gruppo di parentesi tonde significa che il TLD può apparire una o più volte. Questo gruppo di parentesi tonde è usato per catturare il TLD per usarlo in una successiva analisi.

		 */
		//                                                {Gruppo 2                   }
		//                              {Gruppo 1    }    {Gruppo 3  }{Gruppo 4       }
		Pattern email = Pattern.compile("([A-Za-z0-9_.])+@((?:[a-zA-Z.]+)(?:\\.[a-zA-Z]+)+)"); //dominio che due componenti, ?: le parentesi sono usate come precedenza 
		
		m = email.matcher("mario.rossi@example.com.it");
		
		riconosciuto = m.matches();
		System.out.println(riconosciuto);
		
		//riconoscere porzioni di espressioni regolari
		if(riconosciuto) {
			System.out.println("\tutente :" + m.group(1));
			System.out.println("\tdominio :" + m.group(2));
			//System.out.println("\t3 :" + m.group(3));
			//System.out.println("\t4 :" + m.group(4));
		}
		
		Pattern url = Pattern.compile("(?<protocol>[a-zA-Z]+)://"+
									  "(?<host>[a-zA-Z]+(?:\\.[a-zA-Z]+)+)"+
									  "(?<path>(?:/[^/#]+)*/?)"+
									  "(?<fragment>#.+)?"
				);
		
		m = url.matcher("https://oop.polito.it/api/#lectures");
		
		riconosciuto = m.matches();
		System.out.println(riconosciuto);
		
		//riconoscere porzioni di espressioni regolari
		if(riconosciuto) {
			System.out.println("\tprotocol :" + m.group("protocol"));
			System.out.println("\thost :" + m.group("host"));
			System.out.println("\thost :" + m.group("path"));
			System.out.println("\thost :" + m.group("fragment"));
		}	}

}
