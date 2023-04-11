package abbonamenti;
public class Notizia {
String contenuto; 
protected String dettagli = "";
public Notizia(String contenuto) {this.contenuto = contenuto;}	
public String toString() {return contenuto + " " + dettagli;}
}
