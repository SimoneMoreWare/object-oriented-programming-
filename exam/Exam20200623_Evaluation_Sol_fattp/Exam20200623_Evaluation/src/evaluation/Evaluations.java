package evaluation;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Facade class for the research evaluation system
 *
 */
public class Evaluations {

	private Map<Integer, Livello> livelli = new HashMap<>();
	private List<Rivista> riviste = new ArrayList<>();
	private Map<String,Gruppo> gruppi = new HashMap<>();
	private List<Paper> articoli = new ArrayList<>();
	private Map<String, Autore> autori = new HashMap<>();
    //R1
    /**
     * Define number of levels and relative points.
     * 
     * Levels are numbered from 1 on, and points must be strictly decreasing
     *  
     * @param points points for the levels
     * @throws EvaluationsException thrown if points are not decreasing
     */
    public void addPointsForLevels (int... points) throws EvaluationsException {
    	int index = 1;
    	
    	//controllo monotonia
    	for(int i = 0; i< points.length;i++) {
    		for(int j=0;j<i;j++) {
    			if(points[j]<=points[i])
    				throw new EvaluationsException();
    		}
    	}
    	
    	
    	for(int point : points) {
//    		if(point<2)
//    			throw new EvaluationsException();
//    		non esplicitamente richiesta
//    		if(livelli.values().stream().anyMatch(t->t.getPoint()<point))
//    			throw new EvaluationsException();
    		livelli.put(index,new Livello(index,point));
    		index++;
    	}
    	
    	
    	
    	
    	
    }

    /**
     * Retrieves the points for the given level.
     * 
     * @param level level for which points are required
     * @return points for the level
     */
    public int getPointsOfLevel (int level) {
        return livelli.get(level).getPoint();
    }

    /**
     * Add a new journal for a given disciplines and provides the corresponding level.
     * 
     * The level determines the points for the article published in the journal.
     * 
     * @param name name of the new journal
     * @param discipline reference discipline for the journal
     * @param level level for the journal.
     * @throws EvaluationsException thrown if the specified level does not exist
     */
    public void addJournal (String name, String discipline, int level) throws EvaluationsException {
    	
    	if(!livelli.containsKey(level))
    		throw new EvaluationsException();
    	
    	riviste.add(new Rivista(name,discipline,livelli.get(level)));
    }

    /**
     * Retrieves number of journals.
     * 
     * @return journals count
     */
    public int countJournals() {
        return riviste.size();
    }

    /**
     * Retrieves all the journals for a given discipline.
     * 
     * @param discipline the required discipline
     * @return list of journals (sorted alphabetically)
     */
    public List<String> getJournalNamesOfAGivenDiscipline(String discipline) {
        return riviste.stream().filter(t->t.getDiscipline().compareTo(discipline)==0)
        		.map(t->t.getName()).sorted().collect(Collectors.toList());
    }

    //R2
    /**
     * Add a research group and the relative disciplines.
     * 
     * @param name name of the research group
     * @param disciplines list of disciplines
     * @throws EvaluationsException thrown in case of duplicate name
     */
    public void addGroup (String name, String... disciplines) throws EvaluationsException {
    	if(gruppi.containsKey(name))
    		throw new EvaluationsException();
    	
    	gruppi.put(name, new Gruppo(name, Arrays.asList(disciplines)));
    }

    /**
     * Define the members for a previously defined research group.
     * 
     * @param groupName name of the group
     * @param memberNames list of group members
     * @throws EvaluationsException thrown if name not previously defined.
     */
    public void setMembers (String groupName, String... memberNames) throws EvaluationsException {
    	if(!gruppi.containsKey(groupName))
    		throw new EvaluationsException();
    	
    	List<Autore> listaAutori = new ArrayList<>();
    	Gruppo g = gruppi.get(groupName);
    	for(String mem : memberNames) {
    		Autore a = new Autore(mem);
    		a.setGruppo(g);
    		autori.put(mem, a);
    		
    		listaAutori.add(a);
    	}
    	
    	gruppi.get(groupName).addMembers(listaAutori);
    	
    }

    /**
     * Return list of members of a group.
     * The list is sorted alphabetically.
     * 
     * @param groupName name of the group
     * @return list of members
     */
    public List<String >getMembers(String groupName){
       if(!gruppi.containsKey(groupName))
    	   return new ArrayList<>();
       return gruppi.get(groupName).getMembers().stream().sorted().collect(Collectors.toList());
    }

    /**
     * Retrieves the group names working on a given discipline
     * 
     * @param discipline the discipline of interest
     * @return list of group names sorted alphabetically
     */
    public List<String> getGroupNamesOfAGivenDiscipline(String discipline) {
        return gruppi.values().stream().filter(t->t.containsDisciplina(discipline)).map(t->t.getName()).sorted().collect(Collectors.toList());
    }

    //R3
    /**
     * Add a new journal articles, with a given title and the list of authors.
     * 
     * The journal must have been previously defined.
     * 
     * The authors (at least one) are members of research groups.
     * 
     * @param title title of the article
     * @param journalName name of the journal
     * @param authorNames list of authors
     * @throws EvaluationsException thrown if journal not defined or no author provided
     */
    public void addPaper (String title, String journalName, String... authorNames) throws EvaluationsException {
    
    	if(authorNames.length==0)
    		throw new EvaluationsException();

    	for(Rivista r : riviste) {
    		if(r.getName().compareTo(journalName)==0) {
    			Paper p = new Paper(title, r);
    			
    			p.addAutori(Arrays.asList(authorNames));
    			System.out.println(Arrays.toString(authorNames));
    			for(String s : authorNames) {
    				autori.get(s).addArticolo(p);
    				
    				autori.get(s).addPunti((int) Math.round(r.getLivello().getPoint()/((double) authorNames.length)));
    				
    			}
    			articoli .add(p);
    			p.setPunteggio(r.getLivello().getPoint());
    			return;
    		}
    	}
    	throw new EvaluationsException();
    
    }

    


    /**
     * Retrieves the titles of the articles authored by a member of a research group
     * 
     * @param memberName name of the group member
     * @return list of titles sorted alphabetically
     */
    public List<String> getTitlesOfAGivenAuthor (String memberName) {
        /*return articoli.stream().filter(t->t.containsAutore(memberName))
        		.map(t->t.getTitle()).sorted().collect(Collectors.toList());*/
    	if(!autori.containsKey(memberName))
    		return new ArrayList<>();
    	return autori.get(memberName).getArticoli().stream().map(t->t.getTitle()).sorted().collect(Collectors.toList());
    }


    //R4
    /**
     * Returns the points for a given group member.
     * 
     * Points are collected for each article the member authored.
     * The points are those corresponding to the level of the
     * journal where the article is published, divided by
     * the total number of authors.
     * 
     * The total points are eventually rounded to the closest integer.
     * 
     * @param memberName name of the group member
     * @return total points
     */
    public int getPointsOfAGivenAuthor (String memberName) {
        return autori.get(memberName).getPunteggioTotaleArticoli();
    }

    /**
     * Computes the total points collected by all members of all groups
     *  
     * @return the total points
     */
    public int evaluate() {
        return articoli.stream().mapToInt(t->t.getPunteggio()).sum();
    }


    //R5 Statistiche
    /**
     * For each group return the total points collected
     * by all the members of each research group.
     * 
     * Group names are sorted alphabetically.
     * 
     * @return the map associating group name to points
     */
    public SortedMap<String, Integer> pointsForGroup() {
    	
    	
        return autori.values().stream().collect(Collectors.groupingBy(
        		(Autore a)->a.getGruppo().getName(),
        		TreeMap::new,
        		Collectors.summingInt(Autore::getPunteggioTotaleArticoli)	
        		));
      		
    }

    /**
     * For each amount of points returns a list of
     * the authors (group members) that achieved such score.
     * 
     * Points are sorted in decreasing order.
     * 
     * @return the map linking the number of point to the list of authors
     */
    public SortedMap<Integer, List<String>> getAuthorNamesPerPoints () {
        return (SortedMap<Integer, List<String>>) autori.values().stream().filter(t->t.getPunteggioTotaleArticoli()>0).collect(Collectors.toMap(
        		Autore::getName,
        		Autore::getPunteggioTotaleArticoli	
        		)).entrySet().stream()
        		.collect(Collectors.groupingBy(
        				t->t.getValue(),
        				()->new TreeMap<Integer,List<String>>(Comparator.reverseOrder()),
        				Collectors.collectingAndThen(Collectors.mapping(t->t.getKey(),Collectors.toList()),t->t.stream().sorted().collect(Collectors.toList()))
        						)
        				
        				);

    }


}