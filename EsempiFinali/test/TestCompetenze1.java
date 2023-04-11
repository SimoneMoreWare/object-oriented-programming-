package test;
import competenze1.*;
public class TestCompetenze1 {
public static void main(String[] args) {
Competenze comp = new Competenze();
try{
comp.newCompetenza("java");
comp.newCompetenza("c++");
comp.newCompetenza("uml");
comp.newCompetenza("client-server");
comp.newCompetenza("er");
comp.newAttività("codifica1", "java");
comp.newAttività("sviluppo1", "uml", "client-server", "java");
comp.newUtente("analista1", "uml", "er");
comp.newUtente("sviluppatore1", "uml", "client-server", "java");
comp.newUtente("sviluppatore2", "uml", "client-server", "java", "c++");
System.out.println(comp.getAttività("sviluppo1").getInfo()); // sviluppo1[client-server, java, uml]
System.out.println(comp.getUtente("analista1").getInfo()); // analista1[er, uml]
System.out.println(comp.getCompetenza("java").getAttività()); 
// attività che richiedono java [codifica1, sviluppo1]
System.out.println(comp.getCompetenza("java").getUtenti()); 
// utenti che possiedono java [sviluppatore1, sviluppatore2]
} catch (CompEccezione e){System.out.println(e.getMessage());}
System.out.println(comp.elencoCompetenzeRichieste());
// [java: nA=2 nU=2, client-server: nA=1 nU=2, uml: nA=1 nU=3, c++: nA=0 nU=1, er: nA=0 nU=1]
System.out.println(comp.elencoCompetenzePossedute());
// [uml: nA=1 nU=3, client-server: nA=1 nU=2, java: nA=2 nU=2, c++: nA=0 nU=1, er: nA=0 nU=1]
}}

