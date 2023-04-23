package inheritance;

import java.util.Arrays;

public class Vector {
	int[] elements;
	int last;
	public Vector() {
		elements=new int[10];
	}
	void add(int x) {
		if(last==elements.length) {
			resize();
		}
		elements[last++] = x;
	}
	public int size() {
		return last;
	}
	
	void resize() {
//			int[] expansion = new int[2*elements.length];
//			for(int i=0; i<elements.length; ++i) expansion[i]=elements[i];
//			elements=expansion;
		// OR
		elements = Arrays.copyOf(elements, 2*elements.length);
	}
	
	public String toString() {
		StringBuffer res = new StringBuffer("[");
		for(int i=0; i<last; ++i) {
			if(i>0) res.append(", ");
			res.append(elements[i]);
		}
		return res.append(']').toString();
	}
}
