import motorediricerca.*;

import java.util.*;

public class Esempio {

	public static void main(String[] args) {
		try
		{
		
			MotoreDiRicerca motore = new MotoreDiRicerca();
			
			Pagina p1 = motore.aggiungiPagina("http://www.polito.it/index.html","<HTML>Politecnico</HTML>");
			
			System.out.println("Aggiunta pagina");
			System.out.println("Indirizzo: "+p1.getIndirizzo());
			System.out.println("Html: "+p1.getHtml());
			System.out.println("Data (ms): "+p1.getData());
			
			p1.aggiungiParolaChiave("didattica");
			p1.aggiungiParolaChiave("universit�");
			p1.aggiungiParolaChiave("rettore");
			p1.aggiungiParolaChiave("merito");
			p1.aggiungiParolaChiave("Torino");

			System.out.println("Aggiunte parole chiave alla pagina");
			for(int i=0;i<p1.elencoParoleChiave().length;i++)
				System.out.print("["+(p1.elencoParoleChiave())[i]+"] ");
			
			Thread.sleep(100);
			System.out.println("\n");
			Pagina p2 = motore.aggiungiPagina("http://www.amazon.com/books/buy.html","<HTML><B>Buy this book</B></HTML>");
			System.out.println("Aggiunta pagina");
			System.out.println("Indirizzo: "+p2.getIndirizzo());
			System.out.println("Html: "+p2.getHtml());
			System.out.println("Data (ms): "+p2.getData());
			
			p2.aggiungiParolaChiave("didattica");
			System.out.println("Aggiunte parole chiave alla pagina");
			for(int i=0;i<p2.elencoParoleChiave().length;i++)
				System.out.print("["+(p2.elencoParoleChiave())[i]+"] ");

			Thread.sleep(100);
			System.out.println("\n");
			Pagina p3 = motore.aggiungiPagina("http://www.repubblica.it/esteri.html","<HTML><I>International news</I></HTML>");
			System.out.println("Aggiunta pagina");
			System.out.println("Indirizzo: "+p3.getIndirizzo());
			System.out.println("Html: "+p3.getHtml());
			System.out.println("Data (ms): "+p3.getData());

			p3.aggiungiParolaChiave("didattica");
			System.out.println("Aggiunte parole chiave alla pagina");
			for(int i=0;i<p3.elencoParoleChiave().length;i++)
				System.out.print("["+(p3.elencoParoleChiave())[i]+"] ");

			Thread.sleep(100);
			System.out.println("\n");
			Pagina p4 = motore.aggiungiPagina("http://www.polito.it/index.html","<HTML>Politecnico di Torino</HTML>");
			System.out.println("Modificata pagina");
			System.out.println("Indirizzo: "+p4.getIndirizzo());
			System.out.println("Html: "+p4.getHtml());
			System.out.println("Data (ms): "+p4.getData());
			
			System.out.println("\nElenco pagine\n");
			List<Pagina> pagine;
			
			pagine = (List<Pagina>) motore.elencoPagine();
			for(int i=0;i<pagine.size();i++){
				Pagina p = pagine.get(i);
				System.out.println(""+p.getIndirizzo()+" "+p.getData());
			}
			
			p1.aggiungiImmagine("contenuto1.gif", (float)65.22);
			p1.aggiungiVideo("contenuto2.gif", (float)65.23, 25);
			p2.aggiungiVideo("contenuto3.gif", (float)34.11, 30);
			
			System.out.println("\nAggiunti contenuti multimediali");			
			
			motore.aggiungiCollegamentoUscente("http://www.repubblica.it/esteri.html", "http://www.polito.it/index.html");
			motore.aggiungiCollegamentoUscente("http://www.repubblica.it/esteri.html", "http://www.amazon.com/books/buy.html");
			
			System.out.println("\nAggiunti contenuti collegamenti uscenti");

			String stringa = "MERITO Universit� e didattica";
			
			System.out.println("\nStringa di ricerca\n\""+stringa+"\"");
			
			System.out.println("\nRisultati");
			
			pagine = (List<Pagina>) motore.cerca(stringa);
			
			for(int i=0;i<pagine.size();i++){
				Pagina p = pagine.get(i);
				
				System.out.println("\n"+(i+1)+") "+p.getIndirizzo()+" (Punteggio: "+p.getPunteggio()+")");
				for(int j=0;j<p.elencoParoleChiave().length;j++)
					System.out.print("   ["+(p.elencoParoleChiave())[j]+"] ");
				System.out.print("\n   ");
				List<ElementoMultimediale> em = (List<ElementoMultimediale>)p.elencoElementiMultimediali();
				for(int j=0;j<em.size();j++)
					System.out.print(""+em.get(j).getNome()+ " "+ em.get(j).getDimensione() + " (Tipo: " + em.get(j).tipo()+") " );
				System.out.println("");
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
