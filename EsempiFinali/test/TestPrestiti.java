package test;

import biblioteca.*;
public class TestPrestiti {
@SuppressWarnings("unused")
public static void main(String[] args) {
Biblioteca bib = new Biblioteca();
try{	Libro l1 = bib.newLibro("titolo1", 1);
	bib.newLibro("titolo2", 2);
	bib.newLibro("titolo3", 3);
	Utente u1 = bib.newUtente("utente1", 1);
	bib.newUtente("utente2", 3);
	int c1 = bib.newPrestito("utente1", "titolo1");
	bib.restituzione("utente1", c1);
	int c2 = bib.newPrestito("utente1", "titolo3");
	int c3 = bib.newPrestito("utente2", "titolo1");
}catch(BiblioEccezione e){System.out.println(e.getMessage());}
System.out.println(bib.graduatoriaLibri()); 
//[titolo1:2, titolo3:1, titolo2:0]
System.out.println(bib.prestitiInCorso());}}
//[titolo1:100(utente2), titolo3:103(utente1)]

