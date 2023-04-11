
public class EsempioContatore {

	public static void main(String[] args)  {
		

		Contatore c = new Contatore();
		
		c.incrementa();
		
//		if( ! c.decrementa()){
//			System.err.println("Errore: reggiunto limite contatore");
//		}else{
//			// procedi con il programma...
//		}

		try{
			c.decrementa();

			c.decrementa();
			
			System.out.println("dopo");
		}catch(LimiteInferioreRaggiuntoException e){
			System.out.println("Errore: " + e.getMessage());
		}

		System.out.println("Fine!");
	}

}
