package generics;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class MethodReferences {
	interface IntToCharFun {
		  char apply(int value);
		}

	interface StringToIntFunction {
		int apply(String s);
	}
	
	

	public static void main(String[] args) {
		
		String hexDigits = "0123456789ABCDEF";
		//IntToCharFun hex = hexDigits::charAt;
		IntFunction<Character> hex = hexDigits::charAt;
		System.out.println("Hex for 10 : " 
										+ hex.apply(10) );


		String[] words = ("There must be some kind of way out of here " + 
					 "Said the joker to the thief").split(" ");
		//StringToIntFunction f = String::length;
		ToIntFunction<String> f = String::length;
		
		for(String s : words){
		  System.out.println(f.applyAsInt(s));
		}
		
		//IntegerBuilder builder = Integer::new;
		IntFunction<Integer> builder = Integer::new;
		Integer i = builder.apply(1);



	}

}
