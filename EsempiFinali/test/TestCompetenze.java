package test;
import competenze.*;
public class TestCompetenze {
public static void main(String[] args) {
Competenze comp = new Competenze();
try{
comp.newCompetenza("java");
comp.newCompetenza("c++");
comp.newCompetenza("uml");
comp.newCompetenza("client-server");
comp.newCompetenza("er");
comp.newAttivit�("codifica1", "java");
comp.newAttivit�("sviluppo1", "uml", "client-server", "java");
comp.newUtente("analista1", "uml", "er");
comp.newUtente("sviluppatore1", "uml", "client-server", "java");
comp.newUtente("sviluppatore2", "uml", "client-server", "java", "c++");
System.out.println(comp.getAttivit�("sviluppo1")); // sviluppo1[client-server, java, uml]
System.out.println(comp.getUtente("analista1")); // analista1[er, uml]
} catch (CompEccezione e){System.out.println(e.getMessage());}
System.out.println(comp.elencoCompetenzeRichieste());
// [java: nA=2 nU=2, client-server: nA=1 nU=2, uml: nA=1 nU=3, c++: nA=0 nU=1, er: nA=0 nU=1]
System.out.println(comp.elencoCompetenzePossedute());
// [uml: nA=1 nU=3, client-server: nA=1 nU=2, java: nA=2 nU=2, c++: nA=0 nU=1, er: nA=0 nU=1]
}}

