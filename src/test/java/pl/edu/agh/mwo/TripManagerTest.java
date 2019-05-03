package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	Trip trip2;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		trip2 = new Trip("Zawoja", "kolonie");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	
	@Test (expected = AssertionError.class)
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
		fail("chcemy zespuc");
		}
	
	@Test
	public void testRemoveTripSucceed() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());

		}
	
	@Test
	public void testGetTrips() throws Exception {
		tripManager.add(trip);
		tripManager.add(trip2);
		assertEquals(2, tripManager.getTrips().size());
		
	}
	
	@Test
	public void testfindTrip() throws Exception {
		
		tripManager.add(trip2);
		Trip a = tripManager.findTrip("Zawoja");

		assertEquals("Zawoja", a.getName());
	}
	
	@Test(expected = NullPointerException.class)
	public void testfindTripNull() throws Exception {
		
		tripManager.add(trip2);
		Trip a = tripManager.findTrip("Katowice");

		assertEquals("Dawoja", a.getName());
	}
}
