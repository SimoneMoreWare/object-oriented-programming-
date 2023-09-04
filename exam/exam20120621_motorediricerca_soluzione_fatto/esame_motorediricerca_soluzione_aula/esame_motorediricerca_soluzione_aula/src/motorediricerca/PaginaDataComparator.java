package motorediricerca;

import java.util.Comparator;

public class PaginaDataComparator implements Comparator<Pagina>{

	@Override
	public int compare(Pagina a, Pagina b) {
		return (int) (b.getData()-a.getData());
	}

}
