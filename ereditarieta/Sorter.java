package inheritance;

public abstract class Sorter {
	public void sort(Object v[]){
		for(int i=1; i<v.length; ++i)
			for(int j=0; j<v.length-i; ++j){
				if(compare(v[j],v[j+1])>0){ 
					Object o=v[j];
					v[j]=v[j+1]; v[j+1]=o;
				} } }
	protected abstract int compare(Object a, Object b);
//	protected int compare(Object a, Object b){
//		System.err.println("Someone forgot about"+
//				"the compare() method!");
//		return 0; // why not 42?
//	}
}