package frequentFlyers;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class FrequentFlyers {
	
	private Map<String, Alliance> alliances = new HashMap<>();
	private Map<String, Airline> airlines = new HashMap<>();
	private Map<String, Flight> flights = new HashMap<>();
	private Map<String, FrequentFlyer> frequentFlyers = new HashMap<>();
	private int idJourney = 1;
	private Map<Integer, Journey> journeys = new HashMap<>();
	/**
	 * Creates a new alliance with members airlines
	 * 
	 * @param allianceName
	 * @param airlineNames
	 * @throws FFException in case of duplicate alliance or multiple membership of one airline
	 */
	public void addAlliance(String allianceName, String... airlineNames)
			throws FFException {
		
		if(alliances.containsKey(allianceName)) throw new FFException();
		for(String airlineName: airlineNames) if(airlines.get(airlineName)!=null) if(airlines.get(airlineName).getAlliance()!=null) throw new FFException();
		
		Alliance alliance = new Alliance(allianceName);
		
		for(String airlineName: airlineNames) {
			Airline airline = new Airline(airlineName);
			alliance.newAirline(airline);
			airline.setAlliance(alliance);
			airlines.put(airlineName, airline);
		}
		
		alliances.put(allianceName, alliance);
		
	}
	
	public String getAllianceName(String airlineName) {
		return airlines.get(airlineName).getAlliance().getName();
	}
	
	public void setMultiplier(int multiplier, String... allianceNames) {
		
		for(String allianceName: allianceNames) {
			alliances.get(allianceName).setMultiplier(multiplier);
		}
		
	}
	
	public int getMultiplier(String allianceName) {
		return alliances.get(allianceName).getMultiplier();
	}
	
	
	//R2
	public void addFlight(String flightId, String airlineName, int price, int nOfMiles) 
			throws FFException { 
		
		if(airlines.containsKey(airlineName)==false) throw new FFException();
		
		Flight flight = new Flight(flightId, airlines.get(airlineName), price, nOfMiles);
		airlines.get(airlineName).newFlight(flight);
		
		flights.put(flightId, flight);
		
	}
	
	
	public int getNofFlights(String allianceName) {
		return alliances.get(allianceName).getAirlines().stream().mapToInt(Airline::getNFlights).sum();
	}
	
	public int getAverageNofMilesPerFlight(String allianceName) {
		Double avgNofMilesPerFlight = alliances.get(allianceName).getAirlines().stream().flatMap(a->a.getFlights().stream()).mapToInt(f->f.getnOfMiles()).average().orElse(0.0);
		return (int) Math.ceil(avgNofMilesPerFlight - 0.5);
	}
	
	//R3
	public void addFrequentFlyer(String ffId, String... allianceNames)
			throws FFException { 
		
		for(String allianceName: allianceNames) if(alliances.containsKey(allianceName)==false) throw new FFException();
		
		FrequentFlyer frequentFlyer = new FrequentFlyer(ffId);
		
		for(String allianceName: allianceNames) {
			frequentFlyer.newAlliance(alliances.get(allianceName));
			alliances.get(allianceName).newFrequentFlyer(frequentFlyer);
		}
		
		frequentFlyers.put(ffId, frequentFlyer);
		
	}
	
	public int getNOfFF(String allianceName) {
		return alliances.get(allianceName).getFrequentFlyers().size();

	}
	
	//R4
	public int addJourney(String ffId, String... flightIds) throws FFException {
		
		for(String flightId: flightIds) {
			Flight flight = flights.get(flightId);
			Alliance alliance = flight.getAirline().getAlliance();
			
			if(frequentFlyers.get(ffId).isCompatibleAlliance(alliance)==false) {
				throw new FFException();
			}
		}
		
		Journey journey = new Journey(frequentFlyers.get(ffId), idJourney);
		
		for(String flightId: flightIds) {
			journey.newFlight(flights.get(flightId));
			flights.get(flightId).newJourney(journey);
		}
		
		journeys.put(idJourney, journey);
		frequentFlyers.get(ffId).newJourney(journey);
		
		return idJourney++;
	}
	
	public int getJourneyPrice (int journeyCode) {
		return journeys.get(journeyCode).getPrice();

	}
	
	public int getJourneyPoints (int journeyCode) {
		return journeys.get(journeyCode).getPoint();

	}
	
	public int getPoints(String ffId) {
		return frequentFlyers.get(ffId).getPoint();

	}
	
	public int addJourneyWithPoints(String ffId, int points, String... flightIds) throws FFException { 
		
		for(String flightId: flightIds) {
			Flight flight = flights.get(flightId);
			Alliance alliance = flight.getAirline().getAlliance();
			
			if(frequentFlyers.get(ffId).isCompatibleAlliance(alliance)==false) {
				throw new FFException();
			}
		}
		
		if(points>frequentFlyers.get(ffId).getPoint()) throw new FFException();
		
		int flag = 0;	
		for(String flightId: flightIds) {	
			Flight flight = flights.get(flightId);			
			if( points == flight.getnOfMiles() * flight.getAirline().getAlliance().getMultiplier()) {
				flag = 1;
			}
		}
		//aggiungere eccezione non c'è corrispondenza con alcun volo.
		if(flag==0) throw new FFException();
		
		Journey journey = new Journey(frequentFlyers.get(ffId), idJourney);
		
		for(String flightId: flightIds) {
			
			Flight flight = flights.get(flightId);
			
			if( points == flight.getnOfMiles() * flight.getAirline().getAlliance().getMultiplier()) {
				journey.newFlight(flights.get(flightId), 0 ,0);
				flights.get(flightId).newJourney(journey);
				frequentFlyers.get(ffId).setPoint( frequentFlyers.get(ffId).getPoint() - points );
			}else {
				journey.newFlight(flights.get(flightId));
				flights.get(flightId).newJourney(journey);
			}
			
		}
		journeys.put(idJourney, journey);
		frequentFlyers.get(ffId).newJourney(journey);
		
		return idJourney++;

	}
	
	public int pointsForFreeFlight(String flightId) {
		return flights.get(flightId).getnOfMiles()*flights.get(flightId).getAirline().getAlliance().getMultiplier();

	}
	
	//R5
	public SortedMap<Integer, List<String>> listOfFlightIdsPerPrice() {
		return flights.values().stream()
				.collect(Collectors.toMap(
											Flight::getId,
											Flight::getPrice,
											(f1,f2)->f1,
											HashMap::new
									     )
						)
				.entrySet().stream()
				.collect(Collectors.groupingBy(
												Map.Entry::getValue,
												()->new TreeMap<Integer, List<String>>(Collections.reverseOrder()),
												Collectors.mapping(
																	Map.Entry::getKey, 
																	Collectors.collectingAndThen(
																									Collectors.toList(),
																									list->list.stream().sorted().collect(Collectors.toList())
																								)
																  )
						                      )
						) 
				;
	}
	
	public SortedMap<Integer, Long> nOfJourneysPerNofFlights() { 
		return journeys.values().stream()
				.collect(Collectors.groupingBy(
											  	Journey::getNFlights,
											  	TreeMap::new,
											  	Collectors.counting()
											  )
						)
				;
	}
}
