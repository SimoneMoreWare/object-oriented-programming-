import java.util.Iterator;

public class Letters implements Iterable{
	private char[] chars;
	public Letters (String s) {
		chars = s.toCharArray();
	}
	
	@Override
	public Iterator iterator() {
		return new LI();
	}
	
	class LI implements Iterator {
		private int i = 0;
		public boolean hasNext() {
			return i<chars.length;
		}
		public Object next() {
			return new Character(chars[i++]);
		}
	}
}
