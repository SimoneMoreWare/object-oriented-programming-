package class_object;

public class FluentInt {
	
	private int v;

	public FluentInt inzializzaA(int i) {
		v = i;
		return this;
	}

	public FluentInt ePoiSomma(int i) {
		v += i;
		return this;
	}

	public FluentInt aQuestoPuntoSottrai(int i) {
		v -= i;
		return this;
	}

	public int eInfineAggiungi(int i) {
		v += i;
		return v;
	}

}
