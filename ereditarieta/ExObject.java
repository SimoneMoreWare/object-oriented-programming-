package inheritance;

public class ExObject {

	public static void main(String[] args) {
		Object [] objects = new Object[3];
		objects[0]= "First!";
		objects[2]= new Employee();
		objects[1]= 2;
		for(Object obj : objects){
		  System.out.println(obj);
		}


	}

}
