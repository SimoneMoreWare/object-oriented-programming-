package spikes;

public class MemoryOccupation {

	final static int N = 10_000_000;
	public static void main(String[] args) {
	    Runtime rt = Runtime.getRuntime();
	    long prevTotal = 0;
	    long prevFree = rt.freeMemory();
	    int prevI = -1;
	    Integer[] ints = new Integer[N];

	    for (int i = 0; i < N; i++) {
	        long total = rt.totalMemory();
	        long free = rt.freeMemory();
	        if (total != prevTotal || free != prevFree) {
	            long used = total - free;
	            long prevUsed = (prevTotal - prevFree);
	            System.out.println(
	                "#" + i +
	                ", Total: " + total +
	                ", Used: " + used +
	                ", ∆Used: " + (used - prevUsed) +
	                ", per Object: " + (used - prevUsed)/(i-prevI) 
	                );
	            prevTotal = total;
	            prevFree = free;
	            prevI = i;
	        }
	        ints[i] = i;
	    }
	}
}
