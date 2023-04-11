
public class EsReflection {

	public static void main(String[] args) {
		
		Object c = new Contatore();
		
		Class classe = c.getClass();
		
		System.out.println("Classe: " + classe.getCanonicalName());
		System.out.println("Classe: " + classe.getName());
		
		System.out.println("Primo metodo: " +classe.getMethods()[0].getName() );

	}

}
