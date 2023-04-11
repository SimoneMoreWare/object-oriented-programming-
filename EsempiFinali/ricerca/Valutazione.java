package ricerca;
import java.io.*;
import java.util.*;
public class Valutazione {
	Map<String, Ricercatore> ricercatori = new HashMap<String, Ricercatore>();
	Map<String, Rivista> riviste = new HashMap<String, Rivista>();
	public Ricercatore addRicercatore(String id, String first, String last) {
		Ricercatore r = new Ricercatore(id, first, last);
		ricercatori.put(id, r); return r;}
    
    public Ricercatore getRicercatore(String id){
        return ricercatori.get(id);}

    public Rivista addRivista(String issn, String title, double impactFactor) {
    	Rivista r = new Rivista(issn, title, impactFactor);
    	riviste.put(issn, r); return r;}
    
    public Rivista getRivista(String issn){
        return riviste.get(issn);}

    public Collection<Rivista> getRiviste(){
		List<Rivista> list1 = new ArrayList<Rivista>(riviste.values());
		Collections.sort(list1); return list1;}
  
    public void leggi(String fileName) {
 		try{
 		String line1 = null;
		BufferedReader in = new BufferedReader(new FileReader(fileName));   
	    line1 = in.readLine(); 
	    while (line1 != null) {
	    	try {
	    	  Scanner sc = new Scanner(line1).useDelimiter(";"); 
	    	  String l = sc.next();
	    	  if (l.equals("R")) {
	    		  String id = sc.next(); String first = sc.next(); String last = sc.next();
	    		  addRicercatore(id, first, last);
	    	  } else if (l.equals("J")) {
	    		  String issn = sc.next(); String title = sc.next(); double impactFactor = sc.nextDouble();
	    		  addRivista(issn, title, impactFactor);
	    	  } else if (l.equals("A")) {
	    		  String issn = sc.next(); String title = sc.next(); String id = sc.next(); int n = sc.nextInt();
	    		  Rivista r = getRivista(issn);
	    		  Ricercatore ricercatore = getRicercatore(id);
	    		  r.addArticolo(title, ricercatore, n);
	    	  }
	    	} catch (Exception e) {
	    		//e.printStackTrace();
	    	}
	    	line1 = in.readLine(); 
	    };
	    in.close();  
    	} catch (Exception e) {
    		//e.printStackTrace();
    	}
	}
}

