package pl.edu.agh.mwo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

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
	public void testfindZawojaTrip() throws Exception {
		
		tripManager.add(trip2);
		HashMap<String,Trip> res = tripManager.findTrip("Zawoja");

		assertThat(res, hasEntry("Zawoja", trip2));

	}
	
	@Test
	public void testfindAllTrips() throws Exception {
		
		tripManager.add(trip2);
		HashMap<String,Trip> res = tripManager.findTrip("");

		assertThat(res, hasEntry("Zawoja", trip2));

	}
	
	@Test
	public void testfindTripByDescription() throws Exception {
		
		tripManager.add(trip2);
		HashMap<String,Trip> res = tripManager.findTrip("kolonie");

		assertThat(res, hasEntry("Zawoja", trip2));

	}
	
	
	@Test
	public void testfindTripByComment() throws Exception {
		
		tripManager.add(trip2);
		Photo photo = new Photo();
		photo.addComment("very nice sheep amigo");
		trip2.addPhoto(photo);
		HashMap<String,Trip> res = tripManager.findTrip("sheep");

		assertThat(res, hasEntry("Zawoja", trip2));

	}
	
	
	@Test
	public void testfindTripNoResult() throws Exception {
		
		tripManager.add(trip2);
		HashMap<String,Trip> res = tripManager.findTrip("beach");

		assertTrue(res.isEmpty());
	}
}
