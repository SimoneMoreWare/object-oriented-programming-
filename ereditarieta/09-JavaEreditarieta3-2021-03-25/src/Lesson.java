
public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shape p = new Shape(); Illegale xchè shape è astratta
		
		Circle c = new Circle();
		Square q = new Square();
		
		Shape p = c;
		p.draw();
		
		String[] s = new String[5];
		
		s[0]="Pluto";
		s[1]="Pippo";
		s[2]="Paperino";
		s[3]="Toplino";
		s[4]="Satana";
		
		StringSorter ss = new StringSorter();
		ss.sort(s);
		
		for (String a: s) {
			System.out.println(a);
		}
		
		Integer[] vi = {1,5,7,8,9};
		IntegerSorter is = new IntegerSorter();
		is.sort(vi);
		for (Integer i: vi) {
			System.out.println(i);
		}
		
		
		
		
		
		
	}

}
