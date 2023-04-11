package dieta;
import java.util.*;
class Menu extends Alimento{
	private List<Quantita> componenti = new ArrayList<Quantita>();
	public Menu(String nome) {super(nome);}
	private class Quantita {
		Alimento a; double quantita;
		Quantita (Alimento e, double quantita) {
			this.a = e; this.quantita = quantita;
		}
		public String toString() {return a.getNome() + ": " + quantita;}
	}
	void aggiungiMateriaPrima(Alimento a, double quantita) {
		componenti.add(new Quantita(a, quantita));
		aggiungi(a, quantita);}
	void aggiungiProdotto(Alimento a, double quantita) {
		componenti.add(new Quantita(a, quantita));
		aggiungi(a, quantita * 100);}	
	private void aggiungi(Alimento a, double quantita){
		calorie += a.getCalorie() / 100.0 * quantita;
		proteine += a.getProteine() / 100.0 * quantita;
		carboidrati += a.getCarboidrati() / 100.0 * quantita;
		grassi += a.getGrassi() / 100.0 * quantita;}
	public String toString() {return nome + componenti;}
}
