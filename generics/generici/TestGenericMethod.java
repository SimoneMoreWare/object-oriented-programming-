package generici;
import java.util.*;
public class TestGenericMethod {
public static <T> int getSize(Collection <? super T> c) {
	return c.size(); 
}
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		System.out.println(getSize(l));

	}

}
