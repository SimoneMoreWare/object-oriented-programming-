package base;

/**
 * Example: example of class definition
 * Slide set: 02-JavaBase
 * Slide numbers: 21, 50
 * @author mtk
 *
 */
public class Car {
	  String color;
	  String brand;
	  boolean turnedOn;
	  void turnOn() {
	    turnedOn = true;
	  }
	  void paint (String newCol) {
	    color = newCol;
	  }
	  void printState () {
	    System.out.println("Car " + brand + " " + color);
	    System.out.println("the engine is"
				+(turnedOn?"on":"off"));
	  }

	  // Overload (slides 50)
	  void paint(){
		    color = "white";
		  }
	  void paint(int i){ /* ... */ }

}
