import java.util.Scanner;

public class WrapperExample1 {
	public static void main(String[] args) {
		
		long begin = System.nanoTime();
		int i;
		Integer wi;
		
		i=2;
		wi = new Integer(3);//deprecato da java 9
		wi = Integer.valueOf(3); //crea un oggetto Integer a partire dall'intero
								 //vantaggio: velocità di esecuzione e valori di ritorno, meno memoria
								 //oggetti immutabili le classi wrapper, non posso cambiare il valore in quell'oggetto
								//fino a 127 sono tutti in cache, creo oggetto
		wi=3; 
		
		i = Integer.parseInt("42");
		
		String s = Integer.toString(i);
		s=String.valueOf(i);
		
		Integer w1 = 42; //converito in Integer.valueOf(42)
		Integer w2 = w1; //assegnaazione tra riferimenti, w1 e w2 puntano allo stesso oggetto
		System.out.println("w1 == w2 " + (w1==w2));//riferimenti puntano allo stesso oggetto
		
		w2 = new Integer(42);
		System.out.println("rif w1 == w2 " + (w1==w2));//riferimenti non puntano allo stesso oggetto
		System.out.println("val w1 == w2 " + (w1.equals(w2)));//confronto valori dentro oggetti, nelle wrapper e stringhe è gia definito, nelle altre classi no, ovviamente dipende da quello che ho e devo fare

		w2 = Integer.valueOf(42);
		System.out.println("w1 == w2 " + (w1==w2));//valueOf vede se esiste un oggetto con valore 42 e resituisce l'oggetto
		
		long end =System.nanoTime();
		System.out.println((double) (end-begin)/1000000000);
		
		begin = System.nanoTime();
		for(Integer j=0;j<1000000;++j) {} //++j j=Integer.valueOf(i.intValue()+1);
		end = System.nanoTime();
		System.out.println((double) (end-begin)/1000000000); //almeno 10 volte più lento, creo un oggetto ogni volta

		begin = System.nanoTime();
		for(i=0;i<1000000;i++) {}
		end = System.nanoTime();
		System.out.println((double) (end-begin)/1000000000); //non creo un oggetto 
		
		String ss = "234 56.76 21";
		Scanner sc = new Scanner(ss);
		
		int i1 = sc.nextInt();
		double d1 = Double.parseDouble(sc.next());
		int i2 = sc.nextInt();
		System.out.println(i1);
		System.out.println(d1);
		System.out.println(i2);
		
	}
}
