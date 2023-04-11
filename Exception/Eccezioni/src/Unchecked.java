import javax.swing.JOptionPane;


public class Unchecked {

	public static void main(String[] args) {
		
		String s = "x123";
		
		//s = JOptionPane.showInputDialog("Inserisci numero");
		int i=0;
		try{
			i = Integer.parseInt(s);
			Contatore c = new Contatore();
			c.decrementa();
		} catch(NumberFormatException e){
			System.out.println("Errore: " + e.getMessage());
		} catch (LimiteInferioreRaggiuntoException e) {
			System.out.println("Problema con il contatore: " + e.getMessage());
		} catch(Exception e){
			System.out.println("Qualunque eccezione!");
		}
		
		System.out.println("i= " + i);

	}

}
