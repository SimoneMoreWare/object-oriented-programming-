package inheritance;

import java.util.Arrays;

public class SortedVector extends Vector {

	public void add(int x) {
		int i = Arrays.binarySearch(elements, 0, last, x);
		if(i<0) i = -i-1;
		if(last==elements.length) resize();
		for(int j=last; j>i; --j) {
			elements[j] = elements[j-1];
		}
		elements[i] = x;
		last++;
	}
}
