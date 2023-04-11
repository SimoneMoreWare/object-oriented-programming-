package wrapper;

public class EsempiWrapper {

	public static void main(String[] args) {
		
		int i = 5;
		
		String s = String.valueOf(i);
		
		s = ""+i;
		
		char[] characters = {};
		s = (new String(characters)).concat(String.valueOf(i));

		
		Integer j = Integer.valueOf(4);
		j = new Integer(4);
		j = 4;  // autoboxing
		
		i = j;
		
		j = j+i;
	}

}
