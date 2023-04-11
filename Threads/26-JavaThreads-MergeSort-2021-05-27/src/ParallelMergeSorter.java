
public class ParallelMergeSorter implements Runnable{
	
		private int l;
		private int r;
		private int[] v;
		private int level;
		
		public ParallelMergeSorter(int l, int r, int[] v, int level) {
			this.l =l;
			this.r =r;
			this.v = v;
			this.level = level;
		}
		
		void merge(int l1, int r1, int l2, int r2)
		{
		    
		    for (int i = l1; i <= r1; i++)
		    {
		        
		        if (v[i] > v[l2])
		        {
		        	int tmp = v[l2];
		        	v[l2] = v[i];
		        	v[i] =tmp;
		            int first = v[l2];
		 
		            int k;
		            for (k = l2+1; k <= r2 && v[k] < first; k++) {
		                v[k - 1] = v[k];
		            }
		            v[k - 1] = first;
		        }
		    }
		}
		
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println ("Begin level "+level+" Sort: "+l+" "+r);
			if (level ==4) return;
			if (r-l <= 1) {
				if (v[l] > v[r]) {
					int tmp = v[l];
					v[l] = v[r];
					v[r] = tmp;
				}
			} else {
				Thread t1 = new Thread(new ParallelMergeSorter(l,l+(r-l)/2,v,level+1));
				Thread t2 = new Thread(new ParallelMergeSorter(l+(r-l)/2+1,r,v,level+1));
				t1.run();
				t2.run();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Begin merge");

				for (int i=l; i<=r;i++) {
					System.out.print(v[i]+" ");
				}
				System.out.println();
				merge (l,l+(r-l)/2,l+(r-l)/2+1,r);
				
				for (int i=l; i<=r;i++) {
					System.out.print(v[i]+" ");
				}
				System.out.println("\nEnd merge");

			}
		}
		
	}
    

	
