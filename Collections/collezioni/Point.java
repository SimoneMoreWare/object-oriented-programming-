package collezioni;

public class Point implements Comparable<Point>{

	private int x,y;
    public int getX() {return x;}
    public int getY() {return y;}	
    public Point(int x, int y) {this.x = x; this.y = y;}
    public void move(int x, int y) {this.x = x; this.y = y;}
    public String toString(){
	return "x = " + x + " y = " + y;}
    
    public boolean equals(Object o) {
    	if (!(o instanceof Point)) return false;
    	Point p = (Point)o; return this.x == p.x && this.y == p.y;}
    public int hashCode() {
    	return this.x + 31 * this.y;
    }
    public int compareTo(Point p) { // increasing x incr y
    	if (this.x == p.x) {
       		if (this.y == p.y) return 0;
    		else if (this.y < p.y) return -1;	
    		else return 1;
    	} else {
    		if (this.x < p.x) return -1;
    		else return 1;
    	}
    }
}
