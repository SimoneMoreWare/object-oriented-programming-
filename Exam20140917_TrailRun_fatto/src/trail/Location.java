package trail;

import java.util.LinkedList;
import java.util.List;

public class Location {
	
	private String name;
	private int orderNum;
	private List<Delegate> delegates = new LinkedList<>();
	private List<Passage> passages = new LinkedList<>();

    public Location(String name, int orderNum) {
		super();
		this.name = name;
		this.orderNum = orderNum;
	}

	public String getName(){
        return name;
    }

    public int getOrderNum(){
        return orderNum;
    }

	public List<Delegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
    public void newDelegate(Delegate delegate) {
    	delegates.add(delegate);
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
}
