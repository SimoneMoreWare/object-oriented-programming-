import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson {
	
	/* Controllare se una stringa contiene una sequenza di 10 caratteri numerici*/

	public static boolean hasTenDigits(String s) {
		int noDigits = 0;
		for (int i=0; i<s.length();i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				noDigits++;
				if (noDigits == 10) return true;
			} else {
				noDigits = 0;
			}
		}
		return false;
	}
	
	/* Controllare se una stringa contiene una sequenza di 10
	 * caratteri consecutivi usando le espressioni regolari
	 */
	
	public static boolean hasTenDigitsRegEx(String s) {
			//return s.matches("(.*)([0-9]{10})(.*)");
			return s.matches("(.*)(\\d{10})(.*)");
	}
	
	
	public static boolean regexGroups (String regex, String s) {
		//Genero un oggetto pattern in cui compilo la regexp
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		if (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.println("Group"+i+": "+m.group(i));
			}
			return true;
		} else {
			return false;
		}
		
	}

	public static void regexAllGroups (String regex, String s) {
		//Genero un oggetto pattern in cui compilo la regexp
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find()) {
				System.out.println("Match:");
				for (int i = 0; i <= m.groupCount(); i++) {
					System.out.println("Group"+i+": "+m.group(i));
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*if (hasTenDigits("afsd9876543210jjjj")) {
			System.out.println("La stringa contiene dieci numeri consecutivi");
		} else {
			System.out.println("La stringa non contiene dieci numeri consecutivi");
		}
		
		if (hasTenDigitsRegEx("afsd9876543210jjjj")) {
			System.out.println("La stringa contiene dieci numeri consecutivi");
		} else {
			System.out.println("La stringa non contiene dieci numeri consecutivi");
		}*/
	      
		/*if (regexGroups("(.*)([0-9]{10})(.*)","afsd01234567890jjjj")) {
			System.out.println ("La stringa contiene 10 cifre");
		} else {
			System.out.println ("La stringa non contiene 10 cifre");
		}*/
		
		
		//regexAllGroups("(?<ELEMENT><[^>]+>)|(?<ENTITY>&\\w+;)|(?<Text>[^<&]+)","<body>prova di &nbsp; <b>testo</b> &nbsp; html</body>");
		
		//regexAllGroups("(?<=aa)([0-9]+)","aa09945");
		
		/* Input da linea di comando in Java */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserisci un valore da tastiera:");
		String s = scanner.nextLine();
		System.out.println ("Il valore inserito è:"+s);
		String s1 = scanner.nextLine();
		System.out.println ("Il secondo valore inserito è:"+s1);	
		scanner.close();
	}

}
