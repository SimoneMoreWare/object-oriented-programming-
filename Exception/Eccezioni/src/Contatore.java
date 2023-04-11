
public class Contatore {

	private int valore;
	
	public int getValore(){
		return valore;
	}
	
	public void incrementa(){
		valore++;
	}
	
//	public boolean decrementa(){
//		if(valore == 0) return false;
//		valore--;
//		return true;
//	}

	public void decrementa() throws LimiteInferioreRaggiuntoException {
		if(valore == 1){
			throw  new LimiteInferioreRaggiuntoException();
		}
		valore--;
	}
}
