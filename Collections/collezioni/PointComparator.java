package collezioni;
import java.util.Comparator;
public class PointComparator implements Comparator<Point>{
	public int compare(Point p1, Point p2){
	   	if (p1.getX() == p2.getX()) 
	   		if (p1.getY() == p2.getY()) return 0;
	   		else return (p2.getY() < p1.getY()? -1 : 1); 
	   	else return (p2.getX() < p1.getX()? -1 : 1);
	}
}
