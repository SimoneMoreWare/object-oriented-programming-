package ereditarieta;

public class EsempiBase {

	public static void main(String[] args) {
		Number n = Integer.valueOf(42);
		Number m = Integer.valueOf(37);
		
		//int somma = m + n; mi piacerebbe far una cosa del genere ma non posso "sommare" due oggetti tra loro
	
		int somma = m.intValue() + n.intValue();
		
		System.out.println("somma: "+somma);
		
//		Number n = Integer.valueOf(42);
//		Number m = Double.valueOf(37.2);
//		
//		//int somma = m + n; mi piacerebbe far una cosa del genere ma non posso "sommare" due oggetti tra loro
//	
//		int somma = m.intValue() + n.intValue();
//		
//		System.out.println("somma: "+somma); //79, indipendentemente da integeer e double, number è una classe di base
		
		Number[] valori = {
				Integer.valueOf(42),
				Double.valueOf(3.141),
				Long.valueOf(1_735_423_913)
		};
		
		double totale = somma(valori);
		
		System.out.println("Totale: "+totale);
		
		Integer[] interi = {1,1,2,3,4,8,13,21};
		
		System.out.println("Somma interi: "+somma(interi));
		
		/*
		 * Se A extends B ==> A[] extend B[]
		 * 
		 * COVARIANZA
		 * 
		 * Eredetitarietà tra array
		 */
		
//		Number[] interiComeNumeri = interi; //cast da interi a numeri
//		interiComeNumeri[0] = Double.valueOf(3.14); //non funziona, interi è sempre un array di int, quindi non posso assegni a interiComeNUmeri un double, il riferimento è a un oggeto di tipo numeri
//		int p = interi[0];
		
		Number nn;
		Integer quarantadue = Integer.valueOf(42);
		nn=quarantadue; //è una conversione del tipo di riferimento, l'oggetto non viene modificato, up cast (posso farlo senza cast esplicito)
		//integer è un number, tutti gli interi sono numeri
//		Integer ii = nn; //nn potrebbe puntare a un altro oggetto
		Integer ii = (Integer)nn;//conversione del tipo di riferimento, ma l'oggetto è lo stesso. down cast (cast esplicito) non tutti i numeri sono interi
		
		/*
		 * l'oggeto puntato è sempre lo stesso, il cast non mi fa cambiare l'oggetto che è sempre quello, ma solo il riferimento all'oggetto, a che mi serve?
		 * up cast mi serve per trattare oggetti di tipo diverso nello stesso modo
		 * down cast mi serve perchè è possibile che alcuni metodi siano presenti nella classe derivata ma non in quella base
		 */
		
		System.out.println(quarantadue==ii);
		System.out.println(nn==ii);
		System.out.println(ii instanceof Number);
		System.out.println(quarantadue instanceof Integer);
	}
	
	static double somma(Number[] valori) {
		double result = 0.0;
		for(Number n: valori) {
			result += n.doubleValue();
		}
		return result;
	}
	
	//int sempre lui
	//long sempre lui
	//double arrontare 
	static long sommaArrontondataInAlto(Number[] valori) {
		long result = 0;
		for(Number n: valori) {
			if(n instanceof Double) {//il riferimento a che oggetto punta?? se double, la JVM sa a che oggetto punta
				result += Math.ceil(n.doubleValue());
			}else{//qui ho classi di tipo integer e long
				result += n.longValue();
			}
		}
		return result;
	}
	
}
