//lo uso come main
public class Esempio { //classe vuota
	public static void main(String[] args) { //metodo main
		// TODO Auto-generated method stub
		System.out.println("Ciao mondo\n");
		
		//definisco le variabili, devono avere un tipo, le variabili tendenzialmente le definisci subito prima di utilizzarle in qualcunche punto del codice
		//nelle condizioni si hanno i boolean, non 0 o 1, cosi posso interacciare gli errori al volo
		int i=0;
		
		if(i==1){
			System.out.println("i e' uguale a 1\n");
		}else{
			System.out.println("i non e' uguale a 1\n");
		}
		
		if(i>1 && i<10){
			System.out.println("i e' compreso tra 1 e 10\n");
		}else{
			System.out.println("i non e' compreso tra 1 e 10\n");
		}

		//le variabili locali non sono inizializzati
		
		//la classe è un "nuovo tipo" con una serie di campi e attributi 
		
		//come dichiaro una variabile di "tipo" Persona (che è un altra classe definita in un altro "file"?
		//riferimento, creo un riferimento p a un oggetto di tipo Persona, ho creato solo il riferimento
		Persona p;//inizializzato a null, c'è il riferimento ma non l'oggetto
		//Creo oggetto, allocazione oggetto
		p = new Persona();//assegno al riferimento l'indirizzo dell'oggetto Persona
						  //viene chiamato in automatico il costruttore
		//In sintesi Persona p=new Persona();
		//l'oggetto sta nella memoria dinamica, i riferimenti e variabili nello stack
		
		//voglio inizializzare personalmente la classe Persona
		//come faccio a utilizzare 	public Persona(int matr, String n,String c) qui?
		p = new Persona(293369,"Simone Pio","Candido"); //costruttore con i parametri
		//ho creato un nuovo oggetto, il riferimento al primo oggetto creato l ho perso
		
		
		
		//operazioni su quell'oggetto, definite dai metodi
		p.stampa(); //riferimento.metodo il punto mi permette di deferenziare il puntatore, la -> del c

		//se volessi leggere un attributo di una classe senza violare il prinicpio di incapsulamento posso creare un metodo che mi permette di leggere l attributo
		int m=p.leggiMatricola();
		System.out.println("matricola: "+m);
		
		p.modificaMatricola(303369);
		System.out.println("matricola nuova: "+m);
		
		System.gc();/* pulisce quello che non è più raggiungibile
		In Java, System.gc() è una chiamata a un metodo che suggerisce alla JVM (Java Virtual Machine) di eseguire una raccolta dei rifiuti.

La raccolta dei rifiuti è un processo automatico in Java in cui la JVM identifica e libera la memoria che non viene più utilizzata dagli oggetti nel programma. Quando un oggetto non ha più riferimenti ad esso, diventa un candidato per essere eliminato dalla memoria. Tuttavia, il momento esatto in cui l'oggetto viene effettivamente eliminato dalla memoria dipende dalla politica di gestione dei rifiuti utilizzata dalla JVM.

La chiamata System.gc() non garantisce che la raccolta dei rifiuti verrà eseguita immediatamente e in modo efficace. Può essere considerata solo come una richiesta di eseguire la raccolta dei rifiuti, ma la JVM può scegliere di ignorare questa richiesta o eseguirla in un momento successivo.
		*/
		
		p=null; //non punto l'oggetto, non so quando butta via l'oggetto, la JVM potrebbe, posso riutilizzare il riferimento p
		
		//ricorda che anche se funzionante, per intagire con gli oggetti utilizzo sempre i metodi, anche per inizializzare gli attributi, posso accedere direttamente agli attributi con riferimento.attributo ma violo il principio di incapsulamento
		
		//input String s = javax.swing.JoptionPane.showInputDialog("Nome: ");
	}
}
