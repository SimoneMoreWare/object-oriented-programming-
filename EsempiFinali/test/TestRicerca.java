package test;
import ricerca.*;
@SuppressWarnings("unused")
public class TestRicerca {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Valutazione v = new Valutazione();
          
        Ricercatore ae = v.addRicercatore("123","Albert","Einstein");
        Ricercatore ric = v.addRicercatore("432","Enrico","Fermi");
        Ricercatore nb = v.addRicercatore("123","Niels","Bohr");
        Ricercatore[] autori1 = {ric, nb};
        Rivista pr = v.addRivista("0031-9007","Physical Review Letters",7.072);
        Rivista ap = v.addRivista("0001-8732","Advances in Physics",9.571);
        for (Rivista r: v.getRiviste()) System.out.println(r.getTitolo() + " " + r.getIF());
        Articolo a1 = pr.addArticolo("Teoria della relativita ristretta",ae);
        Articolo a2 = ap.addArticolo("Teoria della relativita generale",ae);
        Articolo a3 = ap.addArticolo("Teoria e pratica della fissione",ric);
        Articolo a4 = pr.addArticolo("Un modello dell'atomo",nb);
        
		Articolo a5 = pr.addArticolo("Titolo5", autori1);
 
        System.out.println(ric.getLast() + " ha pubblicato " + ric.numArticoli());
        System.out.println(ae.getLast() + " ha pubblicato " + ae.numArticoli());
         
        System.out.println(ae.getLast() + " ha totalizzato " + ae.sommaIF());
        

        a4.cita(a1);
        a3.cita(a1);    
        a2.cita(a1);
        a4.cita(a2);
        a3.cita(a2);
        a3.cita(a4);
        
        System.out.println(ae.getLast() + " ha h-index " + ae.hIndex());
        
        for (Articolo a: ae.elencoArticoli())
        	System.out.println(a.getTitolo() + " " + a.numCitazioni());
    
    	v = new Valutazione();
    	
    	v.leggi("datiRicerca");
    	for (Rivista r: v.getRiviste()) System.out.println(r.getTitolo() + " " + r.getIF());
    	ae = v.getRicercatore("123");
    	System.out.println(ae.getLast() + " ha pubblicato " + ae.numArticoli());
    	System.out.println(ae.getLast() + " ha h-index " + ae.hIndex());
    	
}
}
