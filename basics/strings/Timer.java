package strings;

public class Timer {
	
	long begin,end;
	long memIni,memFinal;
	
	public void  start() { 
		memIni = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		begin=System.nanoTime(); 
	}
	public void  stop() { 
		end=System.nanoTime();
		memFinal = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		System.gc();
	}
	public String elapsed() {
		long elapsed = end-begin;
		long ns =  elapsed%1000;
		elapsed /=1000;
		long us =  elapsed%1000;
		elapsed /=1000;
		long ms =  elapsed%1000;
		elapsed /=1000;
		long s =  elapsed%60;
		elapsed /=60;
		long m =  elapsed;
		return String.format("%2d:%2d.%3d.%3d",m,s,ms,us);
	}
	
	public long usedMemory() {
		return memFinal - memIni;
	}

}
