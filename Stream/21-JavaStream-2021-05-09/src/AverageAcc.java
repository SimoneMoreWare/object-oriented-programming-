
public class AverageAcc {
	private long length;
	private long count;
	
	public void addName(String n) {
		this.length += n.length();
		count++;
	}
	
	public double average() {
		return (double) length/count;
	}
	
	public AverageAcc merge(AverageAcc o) {
		this.length += o.length;
		this.count += o.count;
		return this;
	}
}
