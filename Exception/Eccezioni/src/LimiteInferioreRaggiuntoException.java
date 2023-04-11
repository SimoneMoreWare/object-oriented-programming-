
public class LimiteInferioreRaggiuntoException extends Exception {

	public LimiteInferioreRaggiuntoException(){
		super("e' stato raggiunto il limite di 0 mentre si cerca di decrementare");
	}
}
