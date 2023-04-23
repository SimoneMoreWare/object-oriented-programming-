package base;

/**
 * Example: operation chaining idiom
 * Slide set: 02-JavaBase
 * Slide numbers: 46
 * 
 * @author mtk
 *
 */
public class Counter {
	private int value;
	public Counter reset(){
		value=0; return this; }
	public Counter increment(int by){
		this.value+=by; return this;  }
	public Counter decrement(int by){
		this.value-=by; return this;  }
	public Counter print(){
		System.out.println(value);
		return this; }
}
