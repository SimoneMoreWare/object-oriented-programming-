package abbonamenti;
public class Persona implements Abbonato{
private String name;
public Persona(String name, Agenzia... agenzie) {
	this.name = name;
	for (Agenzia a: agenzie) a.addAbbonato(this);
}
public void riceviNotizia(Notizia nt) {
	System.out.println(getClass().getSimpleName() + " " + name + " ha ricevuto la notizia " + nt);
}
}
