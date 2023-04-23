package base;

public class FooOverload {
	  public void doIt(int x, long c){
		    System.out.println("a");
		  }
		  public void doIt(long x, int c){
		    System.out.println("b");
		  }
		  public static void main(String args[]){
			FooOverload f = new FooOverload();
		    /*f.doIt(       5 ,      7 ); // ambiguous invocation */
		    f.doIt(       5 ,      7L); // "a"
		    f.doIt( (long)5 ,      7 ); // "b"
		    f.doIt(       5L,      7 ); // "b"
		  }  
}
