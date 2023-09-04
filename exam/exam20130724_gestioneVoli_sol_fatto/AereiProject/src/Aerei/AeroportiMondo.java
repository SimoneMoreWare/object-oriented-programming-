package Aerei;

import java.util.HashMap;
import java.util.Map;

public class AeroportiMondo {
	 Map<String,Aeroporto> aeroporti = new HashMap<String,Aeroporto>();
	
	public  void addAeroporto(Aeroporto a) throws InvalidCode{
		String cod =a.getCode();
		if(aeroporti.containsKey(cod))
			throw new InvalidCode();
		aeroporti.put(cod, a);
	}
	public  void removeAeroporto(String cod) {
		aeroporti.remove(cod);
	}
	public  Aeroporto getAeroporto(String cod) {
		return aeroporti.get(cod);
	}
}
