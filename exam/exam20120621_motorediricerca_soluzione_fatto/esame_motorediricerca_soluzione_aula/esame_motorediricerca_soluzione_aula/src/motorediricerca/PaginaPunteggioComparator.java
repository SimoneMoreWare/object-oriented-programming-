package motorediricerca;

import java.util.Comparator;

public class PaginaPunteggioComparator implements Comparator<Pagina>{

	@Override
	public int compare(Pagina a, Pagina b) {
		return b.getPunteggio()-a.getPunteggio();
	}
}
