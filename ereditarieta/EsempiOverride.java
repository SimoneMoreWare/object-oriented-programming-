package ereditarieta;

public class EsempiOverride {

	static class Impiegato {
		String nome = "Pako";
		Impiegato(String nome){
			this.nome = nome;
		}
		void print() {
			System.out.println(nome);
		}
	}
	
	static class Direttore extends Impiegato {
		String dipartimento = "IT";
		Direttore(String nome){ //per mega direttore mi serve
			super(nome); //passa al ctor di impiegato il parametro richiesto
		}
		Direttore(){
			super("Mario Rossi");//valore di default
		}
		Direttore(String dipartimento,String nome){
			super(nome); //sempre prima super
			this.dipartimento=dipartimento;
		}
		void print() {
			System.out.println(nome+ " " + dipartimento);
			super.print();
		}
	}
	
	static class MegaDirettore extends Direttore{
		String azienda="ACME";
		void print() {
			System.out.println("Azienda: "+azienda);
			super.print();
		}
	}
	
	public static void main(String[] args) {
		MegaDirettore md = new MegaDirettore();
		md.print();
		
		Direttore d = md;
		d.print();
		
		Impiegato i = md;//up cast implicito
		i.print(); //stampa stesse cose di prima
		//c'è il meccanismo della dynamic binding
		//la JVM va a vedere l'oggetto puntato da i di che tipo è , vede se ci sono metodi per quella classe derivata, altrimenti va a cercarli dal padre
	
	
	}
}
