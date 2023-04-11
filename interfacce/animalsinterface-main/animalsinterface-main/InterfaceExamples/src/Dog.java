
public class Dog extends Animal implements Pet {
	
	//For class dog, eating, sleeping and cuddling add +10 to vitality
	//Moving decreases the vitality by 10*numOfLimbs, MakingNoise reduces by 10
	
	private String name;
	
	public String getName() {
		return name;
	}

	public Dog(String name, String color) {
		super(color, 4);
		this.name=name;
	}

	@Override
	public void cuddling() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("Too late...I'm dead.");
		}
		else if (vitality+10>maxVitality) {
			vitality=maxVitality;
			System.out.println("I love cuddles!");
			makeNoise();
		}
		else {
			vitality=vitality+10;
			System.out.println("I love cuddles!");
			makeNoise();
		}
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("Too late...I'm dead.");
		}
		else if (vitality+10>maxVitality) {
			vitality=maxVitality;
			System.out.println("Food is good!");
		}
		else {
			vitality=vitality+10;
			System.out.println("Food is good!");
		}
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("I'm already sleeping. Forever.");
		}
		else if (vitality+10>maxVitality) {
			vitality=maxVitality;
			System.out.println("ZZZZZZ");
		}
		else {
			vitality=vitality+10;
			System.out.println("ZZZZZZZZZ");
		}
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("Dead");
		}
		else {
			System.out.println("I'm running in circles!");
			vitality=vitality-10*numberOfLimbs;
		}
		
	}

	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("Dead");
		}
		else {
			System.out.println("woof woof");
			vitality=vitality-10;
		}
		
	}

}
