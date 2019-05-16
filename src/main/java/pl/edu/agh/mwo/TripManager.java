package pl.edu.agh.mwo;
import java.util.ArrayList;
import java.util.HashMap;

public class TripManager {
	private HashMap<String,Trip> tripList;

	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}
	
	public HashMap<String,Trip> findTrip(String tripName) {
		
		HashMap<String,Trip> res = new HashMap<String,Trip>();
		
		if (tripName.equals("")) {
			return res;
		} 
		
		
		if (tripList.get(tripName) != null) {
			res.put(tripName, tripList.get(tripName));
			
			return res;
		}
		
		for (String name : tripList.keySet()) {
			
			if (tripList.get(name).getDescription().contains(tripName)) {
				res.put(tripName, tripList.get(tripName));
			}
		}

		
		return res;
		
	}
	
}
