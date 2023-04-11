package test;

import voli.*;
public class TestVoli {
@SuppressWarnings("unused")
public static void main(String[] args) {
try{	Voli vi = new Voli();
	Aereo a1 = vi.addAereo("a1", "aereo a1", 100);
	Aereo a2 = vi.addAereo("a2", "aereo a2", 150);
	vi.addVolo("v1", "a1", "L1", 8, "L2", 10);
	vi.addVolo("v10", "a1", "L23", 6, "L34", 7);
	vi.addVolo("v2", "a2", "L3", 12, "L4", 14);
//vi.addVolo("v20", "a1", "L5", 9, "L6", 11); //volo sovrapposto
	vi.addPrenotazione("v1", "pass5", 1);
	vi.addPrenotazione("v1", "pass2", 1);
	//vi.addPrenotazione("v1", "pass2", 1); //prenotazione duplicata
	VoloGiornaliero vg = vi.getVoloGiornaliero("v1", 1);
	System.out.println(vg); // 1 v1 da L1:8 a L2:10[pass2, pass5] 
	System.out.println(a1); 
		// a1 aereo a1 100 [v10 da L23:6 a L34:7, v1 da L1:8 a L2:10]
}catch(VoliEx e){System.out.println(e);}}}

