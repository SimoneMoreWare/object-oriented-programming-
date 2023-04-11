
public class Horse extends Animal implements Pet, Vehicle {
	
	public Horse(String color) {
		super(color, 4);
	}
	
	@Override
	public void cuddling() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("Too late...I'm dead.");
		}
		else if (vitality+15>maxVitality) {
			vitality=maxVitality;
			System.out.println("I love cuddles!");
		}
		else {
			vitality=vitality+15;
			System.out.println("I love cuddles!");
		}
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		if(!isAlive()) {
			System.out.println("Too late...I'm dead.");
		}
		else if (vitality+20>maxVitality) {
			vitality=maxVitality;
			System.out.println("Food is good!");
		}
		else {
			vitality=vitality+20;
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
			System.out.println("Trotting around");
			vitality=vitality-12*numberOfLimbs;
		}
		
	}

	@Override
	public void makeNoise() {
	
		if(!isAlive()) {
			System.out.println("Dead");
		}
		else {
			System.out.println("HIIIIIIII");
			vitality=vitality-10;
		}
		
	}

	@Override
	public void ride() {
		// TODO Auto-generated method stub
		System.out.println("You are riding this horse");
		move();
	}

	@Override
	public void getOff() {
		// TODO Auto-generated method stub
		System.out.println("You are getting off the horse");
		cuddling();
		
	}

}
