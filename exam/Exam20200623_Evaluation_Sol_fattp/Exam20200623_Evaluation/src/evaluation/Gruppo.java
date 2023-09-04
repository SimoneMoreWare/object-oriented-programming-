package evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gruppo {
	
	private String name;
	private List<String> discipline;
	private List<Autore> members = new ArrayList<>();
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getDiscipline() {
		return discipline;
	}
	public void setDiscipline(List<String> discipline) {
		this.discipline = discipline;
	}
	public Gruppo(String name, List<String> discipline) {
		super();
		this.name = name;
		this.discipline = discipline;
	}
	public void addMembers(List<Autore> listaAutori) {
		this.members.addAll(listaAutori);
		
		
	}
	public List<String> getMembers() {
		return members.stream().map(t->t.getName()).peek(System.out::println).collect(Collectors.toList());
	}
	public boolean containsDisciplina(String discipline2) {
		return discipline.contains(discipline2);
	}
	
	public int getTotPoint() {
			int tot = 0;
		for(Autore a : members)
			tot+=a.getPunteggioTotaleArticoli();
		return tot;
	}
	
	

}
