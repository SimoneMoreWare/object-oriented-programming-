package abbonamenti;
public class TestAbbonamenti {
public static void main(String[] args) {
AgenziaStd quotidiano = new AgenziaStd("La gazzetta");
AgenziaStd qSportivo = new AgenziaStd("La gazzetta sportiva");
new Persona("mike", quotidiano, qSportivo);
new Azienda("ditta", quotidiano);
quotidiano.pubblica(new Notizia("Le borse ondeggiano"));
qSportivo.pubblica(new NotiziaSportiva("Nuovo record", "corsa 100 m"));
//Persona mike ha ricevuto la notizia Le borse ondeggiano 
//Azienda ditta ha ricevuto la notizia Le borse ondeggiano 
//Persona mike ha ricevuto la notizia Nuovo record corsa 100 m
}}
