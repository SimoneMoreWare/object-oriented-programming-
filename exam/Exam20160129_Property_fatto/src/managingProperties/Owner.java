package managingProperties;

import java.util.LinkedList;
import java.util.List;

public class Owner {

		private String id;
		private List<Appartement> appartements = new LinkedList<>();
		
		public Owner(String id) {
			this.id = id;
		}
		
		public String getId() {
			return this.id;
		}
		
		public void addAppartement(Appartement appartement) {
			appartements.add(appartement);
		}
		
		public boolean ownerHaveAppartement(String appartement) {

			for(Appartement a: appartements) {
				if((a.toString()).equals(appartement) == true ) return true;
			}

			return false;
			
		}
}
