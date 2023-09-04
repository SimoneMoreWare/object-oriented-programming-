package trail;

import java.util.LinkedList;
import java.util.List;

public class Runner {
	
	private String name;
	private String surname;
	private int id;
	private List<Passage> passages = new LinkedList<>();

    public Runner(String name, String surname, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
	}

	public int getBibNumber(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
    public List<Passage> getPassages() {
		return passages;
	}

	public void setPassages(List<Passage> passages) {
		this.passages = passages;
	}
	
	public void newPassage(Passage passage) {
		passages.add(passage);
	}

	public long getPassTime(String position) {
		
		for(Passage passage: passages) {
			System.out.println(position+":"+passage.getLocation().getName());
			if(passage.getLocation().getName().equals(position)) {
				return passage.getTime();
			}
		}
		
		return -1;
	}
	
	public Passage getLastPassage() {
		
		int max = 0;
		Passage res = null;
		
		for(Passage passage: passages) {
			if(passage.getLocation().getOrderNum() > max) {
				res = passage;
				max = passage.getLocation().getOrderNum();
			}
		}
		return res;
	}
	
	public int getLastPassageOrderNum() {
		
		int max = 0;
		
		for(Passage passage: passages) {
			if(passage.getLocation().getOrderNum() > max) {
				max = passage.getLocation().getOrderNum();
			}
		}
		return max;
	}
	public long getLastPassageTime() {
		
		int max = 0;
		long res =0; 
		for(Passage passage: passages) {
			if(passage.getLocation().getOrderNum() > max) {
				res = passage.getTime();
				max = passage.getLocation().getOrderNum();
			}
		}
		return res;
	}
	
}
