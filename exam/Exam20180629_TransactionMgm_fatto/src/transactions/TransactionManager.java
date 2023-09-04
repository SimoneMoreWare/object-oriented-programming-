package transactions;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

//import static java.util.stream.Collectors.*;
//import static java.util.Comparator.*;

public class TransactionManager {
	
	private HashMap<String,Region> regions = new HashMap<>();
	private HashMap<String,Carrier> carriers = new HashMap<>();
	private List<String> namePlaces = new LinkedList<>();
	private List<String> nameRegions = new LinkedList<>();
	private HashMap<String,Request> requests = new HashMap<>();
	private HashMap<String,Offer> offers = new HashMap<>();
	private List<Request> transactionRequests = new LinkedList<>();
	private List<Offer> transactionOffers = new LinkedList<>();
	private HashMap<String,Transaction> transactions = new HashMap<>();
	
//R1
	public List<String> addRegion(String regionName, String... placeNames) { 
		
		Region region = new Region(regionName);
		
		for(String placeName: placeNames) {
			if(namePlaces.contains(placeName)==false) {
				region.addNamePlace(placeName);
				namePlaces.add(placeName);
			}
		}
		
		regions.put(regionName, region);
		
		return region.getPlaceNames();
	}
	
	public List<String> addCarrier(String carrierName, String... regionNames) { 
		
		Carrier carrier = new Carrier(carrierName);
		
		for(String regionName: regionNames) {
			if(nameRegions.contains(regionName)==false) {
				if(regions.get(regionName)!=null) {
					carrier.addRegion(regions.get(regionName));
					regions.get(regionName).addCarrier(carrier);
				}
			}
		}
		
		carriers.put(carrierName, carrier);
		
		
		return carrier.getRegions();
	}
	
	public List<String> getCarriersForRegion(String regionName) { 
		return regions.get(regionName).getCarriers();
	}
	
//R2
	public void addRequest(String requestId, String placeName, String productId) 
			throws TMException {
		
		if(requests.get(requestId)!=null) throw new TMException();
		if(namePlaces.contains(placeName)==false) throw new TMException();
		
		Request request = new Request(requestId,placeName,productId);
		
		requests.put(requestId, request);
		
		
	}
	
	public void addOffer(String offerId, String placeName, String productId) 
			throws TMException {
		
		if(offers.get(offerId)!=null) throw new TMException();
		if(namePlaces.contains(placeName)==false) throw new TMException();
		
		Offer offer = new Offer(offerId,placeName,productId);
		
		offers.put(offerId, offer);
	}
	

//R3
	public void addTransaction(String transactionId, String carrierName, String requestId, String offerId) 
			throws TMException {
		 
		if(transactionRequests.contains(requests.get(requestId))==true) throw new TMException();
		if(transactionOffers.contains(offers.get(offerId))==true) throw new TMException();
		if(offers.get(offerId).getProductId().equals(requests.get(requestId).getProductId())==false) throw new TMException();
		if(carriers.get(carrierName).carrierServePlace(offers.get(offerId).getPlaceName())==false || carriers.get(carrierName).carrierServePlace(requests.get(requestId).getPlaceName())==false) throw new TMException();
		
		Transaction transaction = new Transaction(transactionId, carriers.get(carrierName), requests.get(requestId), offers.get(offerId));
		transactions.put(transactionId, transaction);
		transactionRequests.add(requests.get(requestId));
		transactionOffers.add(offers.get(offerId));
	}
	
	public boolean evaluateTransaction(String transactionId, int score) {
		if(score<1 || score>10) return false;
		transactions.get(transactionId).setScore(score);
		return true;
	}
	
//R4
	public SortedMap<Long, List<String>> deliveryRegionsPerNT() {
		
		return null;
		
	}
	
	public SortedMap<String, Integer> scorePerCarrier(int minimumScore) {
		return transactions.values().stream().
				filter( t -> t.getScore()>=minimumScore).
				collect(Collectors.groupingBy(Transaction::getCarrierName,TreeMap::new,Collectors.summingInt(Transaction::getScore)))
				;
	}
	
	public SortedMap<String, Long> nTPerProduct() {
		return transactions.values().stream().
				collect(Collectors.groupingBy(Transaction::getProductId,
												TreeMap::new,
												Collectors.counting()
											 )
						).
				entrySet().
				stream().
				filter(entry->entry.getValue()>0).
				collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1, v2)->v2,TreeMap::new))
				;
	}
	
	
}

