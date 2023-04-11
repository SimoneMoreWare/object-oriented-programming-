import it.polito.oop3.university.Corso;
import it.polito.oop3.university.Docente;
import it.polito.oop3.university.ExceptionLessonNotFound;
import it.polito.oop3.university.Universita;

/*======================================

Il Politecnico di Torino vuole dotarsi di un sistema per la monitorare le lezioni a distanza e in presenza dei corsi.

Requisiti
---------

1. Voglio poter memorizzare nel sistema le informazioni dei corsi. Ogni corso deve permettere di 
reperire le seguenti informazioni: 
- codice del corso
- nome del corso
- numero di ore da erogare in presenza
- numero di ore da erogare a distanza 
- l'elenco dei docenti che devono tenere il corso con il relativo numero di ore che dovrebbero essere erogate
- l'elenco degli studenti iscritti al corso

2. Voglio poter memorizzare l'elenco degli studenti. Ogni studente ha le seguenti informazioni:
- matricola
- nome e cognome
- la residenza attuale dello studente (solo gli studenti residenti a Torino possono accedere alle lezioni in presenza)

3. Ogni volta che un docente tiene una lezione di un corso il sistema deve memorizzare la data 
della lezione, il nome del docente che l'ha tenuta, il numero di ore erogate, la tipologia della 
lezione (P,D) e l'elenco degli studenti che hanno partecipato. 

4. Dato un corso visualizzare l'elenco delle lezioni erogate in ordine di data decrescente, 
calcolare il numero totale di ore in presenza e il totale delle ore a distanza, 
il numero medio di persone che partecipano in presenza e a distanza

*/


public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Universita u = new Universita();
		u.addCorso("OOP1", "Programmazione a oggetti 1", 50, 10);
		u.addCorso("OOP2", "Programmazione a oggetti 2", 30, 10);
		u.addCorso("OOP3", "Programmazione a oggetti 3", 30, 10);
		u.addCorso("OOP4", "Programmazione a oggetti 4", 30, 10);

		u.addDocente("d003272", "Stefano", "Di Carlo");
		u.addDocente("d00xxxx", "Marco", "Torchiano");

		u.addStudente("s01245", "Mario", "Rossi", "Torino");
		u.addStudente("s01232", "Giorgio", "Bianchi", "Roma");
		u.addStudente("s01233", "Marcello", "Neri", "Torino");
		
		
		u.assignCorsotoDocente("OOP1", "d00xxxx", 10);
		u.assignCorsotoDocente("OOP3", "d003272", 10);
		
		u.assignStudentetoCorso("OOP3", "s01245");
		u.assignStudentetoCorso("OOP3", "s01232");
		u.assignStudentetoCorso("OOP3", "s01233");
		
		
		u.addLezione("OOP3", "d003272", "2021-04-10", 10, 'D');
		u.addLezione("OOP3", "d003272", "2021-04-11", 3, 'P');
		u.addLezione("OOP3", "d003272", "2021-04-12", 5, 'D');
		u.addLezione("OOP3", "d003272", "2021-04-13", 4, 'D');
		u.addLezione("OOP3", "d003272", "2021-04-14", 10, 'P');
		u.addLezione("OOP3", "d003272", "2021-04-15", 3, 'P');
		
		try {
			u.addStudenteToLezione("OOP3", "s01245", "2021-04-10");
			u.addStudenteToLezione("OOP3", "s01232", "2021-04-10");
			u.addStudenteToLezione("OOP3", "s01233", "2021-04-10");
			u.addStudenteToLezione("OOP3", "s01245", "2021-04-11");
			u.addStudenteToLezione("OOP3", "s01232", "2021-04-11");
			u.addStudenteToLezione("OOP3", "s01233", "2021-04-11");
			u.addStudenteToLezione("OOP3", "s01233", "2021-04-31");
		} catch (ExceptionLessonNotFound e) {
			System.out.println("Eccezione "+e.getMessage());
			e.printStackTrace();
		}
		u.printLezioni("OOP3");
		System.out.println ("Numero totale di ore in presenza"+ u.getOre("OOP3",'P'));
		System.out.println ("Numero totale di ore a distanza"+ u.getOre("OOP3",'D'));

		
	}

}
