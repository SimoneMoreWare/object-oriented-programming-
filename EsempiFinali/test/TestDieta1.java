package test;
import dieta.*; import java.io.*;
public class TestDieta1 {
    public static void main(String[] args) throws IOException {
        Alimenti alimenti = new Alimenti();
        String fileName = "MateriePrime.txt";
        alimenti.leggiMateriePrime(fileName);
        for(ElementoNutritivo e : alimenti.materiePrime()){
            System.out.println(e.getNome() + " cal: " + e.getCalorie());
        }
        //Latte_scremato cal: 34.0
        //Mais cal: 70.0
        //Nutella cal: 530.0
        //Olio_Extravergine cal: 900.0
        //Pasta cal: 350.0
        //Zucchero cal: 400.0
    }

}
