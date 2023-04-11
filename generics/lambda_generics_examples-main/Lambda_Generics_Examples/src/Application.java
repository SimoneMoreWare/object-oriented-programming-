import java.util.Arrays;
import java.util.Comparator;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Example reverse sort of integers
		Integer[] intArray= {9, 34, 8, 45, 19};
		Arrays.sort(intArray, (a,b)->b-a);
		for(int n: intArray) {
			System.out.print(n+" ");
		}
		System.out.println();
        
		
		//Encoder example
		Encoder e= (s,k)->{
			StringBuffer sb=new StringBuffer(s);
			for(int i=0; i<sb.length(); i++) {
				if(i%2==0) {
					sb.setCharAt(i, (char)(sb.charAt(i)+k));
				}
				
			}
			return new String(sb);
		};

		
		//Decoder example
		Decoder d= (s,k)->{
			StringBuffer sb=new StringBuffer(s);
			for(int i=0; i<sb.length(); i++) {
				if(i%2==0) {
					sb.setCharAt(i, (char)(sb.charAt(i)-k));
				}
				
			}
			return new String(sb);
		};

		String secret="Dogs are better than cats";
		String encodedSecret=e.encode(secret, 80);
		System.out.println(encodedSecret);
		
		String decodedSecret=d.decode(encodedSecret, 80);
		System.out.println(decodedSecret);
		
		//Example PAIR single type
		Pair<String> sp= new Pair<> ("one", "two");
		Pair<Integer> ip= new Pair<>(1, 2);
		
		
		String a =sp.second();
		int b=ip.first();
		//String bString=ip.second();  ERROR!
		
		//Example mixed PAIR 
		MixedPair<Integer, String> mxp= new MixedPair<>(1, "String");
		
		//Generic Box Example
		
		 Box<Integer> intBox = new Box<Integer>();
         System.out.println("Is the box empty? "+intBox.isEmpty());
	      // add some integers to the box
	      intBox.put(1);
	      System.out.println("Is the box empty? "+intBox.isEmpty());
	      int i=intBox.get();
	      System.out.println(i);
	      System.out.println("Is the box empty? "+intBox.isEmpty());
	      System.out.println();
	      Box<String> strBox = new Box<>();
         System.out.println("Is the box empty? "+strBox.isEmpty());
	      // add some integers to the box
	      strBox.put("ciao");
	      System.out.println("Is the box empty? "+strBox.isEmpty());
	      String s=strBox.get();
	      System.out.println(s);
	      System.out.println("Is the box empty? "+strBox.isEmpty());
	      System.out.println();
	        Box<Pair<String>> pairBox = new Box<>();
	         System.out.println("Is the box empty? "+pairBox.isEmpty());
		      // add some integers to the box
		      pairBox.put(new Pair<String>("Hello", "World"));
		      System.out.println("Is the box empty? "+pairBox.isEmpty());
		      Pair<String> p=pairBox.get();
		      System.out.println(p.first()+" "+p.second());
		      System.out.println("Is the box empty? "+pairBox.isEmpty());
	      

	     

	      // create a Box for storing strings
	     /* Box<String> strBox = new Box<String>();

	      // add some strings to the box
	      strBox.add("apple");
	      strBox.add("banana");
	      strBox.add("cherry");

	      // print the strings from the box
	      System.out.println("Strings in the box:");
	      while (!strBox.isEmpty()) {
	         System.out.println(strBox.get()); 
	      } */
		
		
		
		
	}

}
