package collezioni;
import java.util.Comparator;
public class PointComparator1 implements Comparator<Point>{
	public int compare(Point p1, Point p2){
	   	if (p1.getX() == p2.getX()) 
	   		 return (p2.getY() < p1.getY()? -1 : 1); 
	   	else return (p2.getX() < p1.getX()? -1 : 1);
	}
}
