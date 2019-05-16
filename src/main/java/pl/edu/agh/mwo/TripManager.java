package pl.edu.agh.mwo;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public HashMap<String,Trip> findTrip(String searchedKeyWord) {
		
		HashMap<String,Trip> res = new HashMap<String,Trip>();
		
		Pattern pattern = Pattern.compile(".*" + searchedKeyWord + ".*");
		
		
		
		if (searchedKeyWord.equals("")) {
			return tripList;
		} 
		
		
		if (tripList.get(searchedKeyWord) != null) {
			res.put(searchedKeyWord, tripList.get(searchedKeyWord));
			
		}
		
		for (String name : tripList.keySet()) {
			
			if (tripList.get(name).getDescription().contains(searchedKeyWord)) {
				res.put(name, tripList.get(name));
			}
		}

		for (String name : tripList.keySet()) {
			
			for (Photo photo : tripList.get(name).getPhotoList()) {
				for (String comment : photo.getCommentList()) {
					Matcher matcher = pattern.matcher(comment);
					if (matcher.find()) {
						res.put(name, tripList.get(name));	
					}
				}
//				if (photo.getCommentList().contains(searchedKeyWord)) {
//					res.put(name, tripList.get(name));	
//				}
				
			}
		}

		
		return res;
		
	}
	
}
