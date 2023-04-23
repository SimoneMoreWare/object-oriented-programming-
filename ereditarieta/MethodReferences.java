package inheritance;

import java.util.function.ToIntFunction;

public class MethodReferences {
	interface IntToCharFun {
		  char apply(int value);
		}

	interface StringToIntFunction {
		int apply(String s);
	}
	
	interface IntegerBuilder{
		Integer build(int value);  
	}


	public static void main(String[] args) {
		
		String hexDigits = "0123456789ABCDEF";
		IntToCharFun hex = hexDigits::charAt;
		System.out.println("Hex for 10 : " 
										+ hex.apply(10) );


		String[] words = ("There must be some kind of way out of here " + 
					 "Said the joker to the thief").split(" ");
		StringToIntFunction f = String::length;
		for(String s : words){
		  System.out.println(f.apply(s));
		}
		
		IntegerBuilder builder = Integer::new;
		Integer i = builder.build(1);


	}

}
