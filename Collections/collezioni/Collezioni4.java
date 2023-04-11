package collezioni;
import java.util.*;
public class Collezioni4 {
public static void main(String[] args) {
String testo = "The poem was inspired by the sight of a field full of golden daffodils waving in the wind";
String[] parole = testo.split(" ");
System.out.println(Arrays.toString(parole));
Map<String, Parola> m = new TreeMap <String, Parola>();
for (String s: parole) {
	Parola p = m.get(s);
	if (p == null) m.put(s, new Parola(s));
	else p.incr();
}
System.out.println(m);
//{The=The:1, a=a:1, by=by:1, daffodils=daffodils:1, field=field:1, full=full:1, golden=golden:1, in=in:1, 
//inspired=inspired:1, of=of:2, poem=poem:1, sight=sight:1, the=the:2, was=was:1, waving=waving:1, wind=wind:1}
// stampa per occorrenze decr
List<Parola> list = new ArrayList<Parola>(m.values());
Collections.sort(list);
System.out.println(list);
//[of:2, the:2, The:1, a:1, by:1, daffodils:1, field:1, full:1, golden:1, in:1, inspired:1, poem:1, sight:1, was:1, waving:1, wind:1]
// senza distinzione tra maiuscole e minuscole
Comparator<String> comp = new Comparator<String>(){
	public int compare(String s1, String s2) {return s1.compareToIgnoreCase(s2);}
};
Map<String, Parola> m1 = new TreeMap <String, Parola>(comp);
for (String s: parole) {
	Parola p = m1.get(s);
	if (p == null) m1.put(s, new Parola(s));
	else p.incr();
}
list = new ArrayList<Parola>(m1.values());
Collections.sort(list);
System.out.println(list);
//[The:3, of:2, a:1, by:1, daffodils:1, field:1, full:1, golden:1, in:1, inspired:1, poem:1, sight:1, was:1, waving:1, wind:1]
}
}
