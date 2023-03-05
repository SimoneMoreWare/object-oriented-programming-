package liste;//definiscono un nuovo scope, le classi dello stesso package possono vedersi

	    class Nodo {
//^^^^^
//visibilità di package, classe visibile all'interno dello stesso package (listaINteri si, esempioLista no)	    	
	private Nodo prossimo;
	private int valore;
	//set e get, source, generate get and setters
	
	//definisco costruttore per inizializzare prossimo e valore, nascondere i dettagli (non solo incapsulo)
	public Nodo(int valore,Nodo prossimo) {
		this.valore=valore;
		this.prossimo = prossimo;
	}
	
	public Nodo getProssimo() {
		return prossimo;
	}
	public void setProssimo(Nodo prossimo) {////public o senza niente stessa cosa, le classi listainteri e nodo si trovano nello stesso package
		this.prossimo = prossimo;
	}
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}
	
	String comeStringa() {
		if(prossimo!=null) {
			return valore + ", " + prossimo.comeStringa(); //chiamo comestringa sul prossimo valore, se prossimo nullo resituisco il mio valore corrente
		}else {
			return ""+valore; //condizione di terminazione
			//oppure return Integer.tostring(valore); ricordiamoci che valore è intero e io devo ritornare una stringa
		}
	}
	
}
