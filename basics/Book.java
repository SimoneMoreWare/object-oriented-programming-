package base;

/**
 * Example: this and intra-class context
 * Slide set: 02-JavaBase
 * Slide numbers: 39-40
 * 
 * @author mtk
 *
 */
public class Book {
    int pages;
    void readPage(int n) { /* ... */ }
    void readAll() {
         for(int i=0; i<pages; i++) {
        	 readPage(i);
        	 // EQUIVALENT TO
        	 this.readPage(i);
         }
    }
}