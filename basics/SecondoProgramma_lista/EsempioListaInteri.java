import liste.ListaInteri; //import perchè si trova in un altro package

//ho creato un altra classe con il metodo main
//posso avere tante classi con il metodo main quante voglio
//quando lancio la JVM indico qual è la classe con il metodo main che voglio eseguire 
public class EsempioListaInteri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//R1 una lista corrisponde ad un oggetto di tipo listaInteri
		
		ListaInteri l = new ListaInteri();
		
		//R2 posso aggiungere nuovi elementi tramite il metodo add
		l.add(5);//non ci interessa come è fatto il nodo a noi utenti nel main
		l.add(3);
		
		//R3 GLi elementi vengono aggiunti in testa e posso vedere cosa c'è in testa con il metodo testa
		int t = l.testa();
		System.out.println("Testa " + t);
		
		//R4 posso sapere quanti elementi sono presenti nella lista con il metodo quanti();
		int n = l.quanti();
		System.out.println("Quanti: " + n);
		
		//R5 posso ottenere una rappresentazione stringa della lista con tutti i suoi elementi con il metodo comeStringa();
		String s = l.comeStringa();
		System.out.println(s);
	}

}
