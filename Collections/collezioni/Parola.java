package collezioni;
public class Parola implements Comparable<Parola> {
private String p;
private int n = 1;
public Parola(String p) {this.p = p;}
public String toString(){return p + ":" + n;}
public int compareTo(Parola parola){
	if (n > parola.n) return -1;
	else if (n < parola.n) return 1;
	else return p.compareTo(parola.p);
}
public void incr() {n++;}
}
