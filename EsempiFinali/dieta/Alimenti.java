package dieta;
import java.io.*; import java.util.*;
public class Alimenti {
	TreeMap<String, Alimento> materiePrime = new TreeMap<String, Alimento>();
	TreeMap<String, Alimento> prodotti = new TreeMap<String, Alimento>();
	TreeMap<String, Menu> menus = new TreeMap<String, Menu>();
	
	public void definisciMateriaPrima(String nome, double kcal,
		double proteine, double carboidrati, double grassi){
		materiePrime.put(nome, new Alimento(nome, kcal, proteine, carboidrati, grassi));	
	}
	
	public Collection<? extends ElementoNutritivo> materiePrime(){
		return materiePrime.values();
	}

	public ElementoNutritivo getMateriaPrima(String nome)throws Exception{
		ElementoNutritivo a = materiePrime.get(nome);
		if (a == null) throw new Exception(Eccezioni.MATERIAPRIMAINESISTENTE.toString());
		return a;
	}

	public void definisciProdotto(String nome, double kcal,
		double proteine, double carboidrati, double grassi){
		prodotti.put(nome, new Alimento(nome, kcal, proteine, carboidrati, grassi));
	}
	
	public Collection<? extends ElementoNutritivo> prodotti(){
		return prodotti.values();
	}
	
	public ElementoNutritivo getProdotto(String nome)throws Exception{
		ElementoNutritivo a = prodotti.get(nome);
		if (a == null) throw new Exception(Eccezioni.PRODOTTOINESISTENTE.toString());
		return a;
	}
	
	public Collection<? extends ElementoNutritivo> materiePrimePerCalorie(){
		List<Alimento> list1 = new ArrayList<Alimento>(materiePrime.values());
		Collections.sort(list1); return list1;
	}

	public double mediaCalorieProdotti(){
	double media = 0;
	   for(ElementoNutritivo e : prodotti.values()){
		   media += e.getCalorie();
	   }
	   return media / prodotti.values().size();
	}
	
	public void definisciMenu(String nome){menus.put(nome, new Menu(nome));
	}

	public void aggiungiMateriaPrima(String menu, String materiaPrima, double quantita)
    throws Exception{
		Menu m = menus.get(menu);
		if (m == null) throw new Exception(Eccezioni.MENUINESISTENTE.toString());
		Alimento a = materiePrime.get(materiaPrima);
		if (a == null) throw new Exception(Eccezioni.MATERIAPRIMAINESISTENTE.toString());
		m.aggiungiMateriaPrima(a, quantita);
	}

	public void aggiungiProdotto(String menu, String prodotto, double quantita)
    throws Exception {
		Menu m = menus.get(menu);
		if (m == null) throw new Exception(Eccezioni.MENUINESISTENTE.toString());
		Alimento a = prodotti.get(prodotto);
		if (a == null) throw new Exception(Eccezioni.PRODOTTOINESISTENTE.toString());
		m.aggiungiProdotto(a, quantita);
	}

	public ElementoNutritivo getMenu(String nome)throws Exception{
		Menu m = menus.get(nome);
		if (m == null) throw new Exception(Eccezioni.MENUINESISTENTE.toString());
	    return m;
	}

	public void leggiMateriePrime(String fileName) throws IOException {
		String line1 = null;
		BufferedReader in = new BufferedReader(new FileReader(fileName));   
	    line1 = in.readLine(); 
	    while (line1 != null) {
	    	try {
	    	  Scanner sc = new Scanner(line1);
	    	  sc.useLocale(Locale.US); 
	    	  //sc.useDelimiter("\\s*;\\s*"); // se il sep. fosse ; tra spazi
	    	  String nome = sc.next();
			  //double calorie = Double.parseDouble(sc.next()); 
			  double calorie = sc.nextDouble();
			  double proteine = sc.nextDouble(); 
			  double carboidrati = sc.nextDouble(); 
			  double grassi = sc.nextDouble(); 
			  materiePrime.put(nome, new Alimento(nome, calorie, proteine, carboidrati, grassi)); 
	    	} catch (Exception e) {System.out.println(e.getMessage());
	    	}
	    	line1 = in.readLine(); 
	    };
	    in.close();        
	}
}
