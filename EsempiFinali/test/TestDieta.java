package test;
import dieta.*;
public class TestDieta {
    public static void main(String[] args) throws Exception {
        Alimenti alimenti = new Alimenti();
        alimenti.definisciMateriaPrima("Zucchero", 400, 0, 100, 0);
        alimenti.definisciMateriaPrima("Mais", 70, 2.7, 12, 1.3);
        alimenti.definisciMateriaPrima("Pasta", 350, 12, 72.2, 1.5);
        alimenti.definisciMateriaPrima("Olio", 900, 0, 0, 100);
        alimenti.definisciMateriaPrima("Nutella", 530, 6.8, 56, 31);
        
        for(ElementoNutritivo e : alimenti.materiePrime()){
            System.out.println(e.getNome() + " cal: " + e.getCalorie()); //per nome materia prima
        }
        //Mais cal: 70.0
        //Nutella cal: 530.0
        //Olio cal: 900.0
        //Pasta cal: 350.0
        //Zucchero cal: 400.0
        for(ElementoNutritivo e : alimenti.materiePrimePerCalorie()){ //per calorie crescenti
            System.out.println(e.getNome() + " cal: " + e.getCalorie());
        }      
        //Mais cal: 70.0
        //Pasta cal: 350.0
        //Zucchero cal: 400.0
        //Nutella cal: 530.0
        //Olio cal: 900.0
        alimenti.definisciProdotto("Cracker", 111, 2.6, 17.2, 3.5);
        alimenti.definisciProdotto("Cono gelato", 400, 2.6, 17.2, 3.5);
        
        System.out.println("media cal. prodotti " + alimenti.mediaCalorieProdotti());
        //media cal. prodotti 255.5
        alimenti.definisciMenu("Menu 1");
        alimenti.aggiungiProdotto("Menu 1", "Cracker", 2);
        alimenti.aggiungiMateriaPrima("Menu 1", "Pasta", 100);
        alimenti.aggiungiMateriaPrima("Menu 1", "Nutella", 50);

        ElementoNutritivo menu = alimenti.getMenu("Menu 1");

        System.out.printf("Per il menu %s " +
        		"%n Calorie     : %.2f " +
        		"%n Carboidrati : %.2f " +
        		"%n Grassi      : %.2f " +
        		"%n Proteine    : %.2f%n",
        		menu.getNome(), menu.getCalorie(), menu.getCarboidrati(), 
        		menu.getGrassi(), menu.getProteine());
        //Per il menu Menu 1 
        //Calorie     : 837,00 
        //Carboidrati : 134,60 
        //Grassi      : 24,00 
        //Proteine    : 20,60

        System.out.println(menu);
        //Menu 1[Cracker: 2.0, Pasta: 100.0, Nutella: 50.0]
  
    }

}
