
public abstract class Animal {
	protected int numberOfLimbs;
	protected String color;
	protected int vitality; //<=0: the animal is dead >0<100 the animal is alive
	final static int maxVitality=100;
	
	public abstract void eat();
	public abstract void sleep();
	public abstract void move();
	public abstract void makeNoise();
	
	public Animal(String color, int numberOfLimbs) {
		this.color=color;
		this.numberOfLimbs=numberOfLimbs;
		this.vitality=maxVitality;
	}
	
	public boolean isAlive() {
		return (vitality)>0 ? true : false;
	}
	
	public int getVitality() {
		return vitality;
	}
}
