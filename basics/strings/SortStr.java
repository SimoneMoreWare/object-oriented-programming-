package strings;

public class SortStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void sortStrings(String [] strings) {
		//....
		
	 int i = 0;
	 int j = 1;
	 
	 	if( strings[i].compareTo(strings[j]) > 0 ) {
	 		String tmp = strings[i];
	 		strings[i] = strings[j];
	 		strings[j] = tmp;
	 	}
		
		//....
	}

}
