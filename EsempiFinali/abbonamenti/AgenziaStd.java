package abbonamenti;
import java.util.*;
public class AgenziaStd implements Agenzia {
@SuppressWarnings("unused")
private String name;
private List<Abbonato> abbonati = new ArrayList<Abbonato>();
public AgenziaStd(String name) {this.name = name;}
public void addAbbonato(Abbonato a) {abbonati.add(a);}
public void pubblica(Notizia nt) {
for (Abbonato a: abbonati) a.riceviNotizia(nt);}
}
