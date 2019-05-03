package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TripTest {

	@Test
	public void testConstructor() {
		Trip trip = new Trip("nazwa", "opis");
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}
	
	
	@Test
	public void testSetters() {
		Trip trip = new Trip("nazwa", "opis");
		trip.setDescription("zmienionyOpis");
		trip.setName("Aruba");
		
		assertEquals("Aruba", trip.getName());
		assertEquals("zmienionyOpis", trip.getDescription());
		
	}
	    
	
	@Test
	public void testGetPhotos() {
		Trip trip = new Trip("nazwa", "opis");
		Photo photo = new Photo();
		Photo photo2 = new Photo();
		
		assertEquals(0, trip.getPhotoList().size());
		trip.addPhoto(photo);
		trip.addPhoto(photo2);

		assertEquals(2, trip.getPhotoList().size());
		
	}
	
	@Test
	public void testAddPhoto() {
		Photo photo = new Photo();
        Trip trip = new Trip("nazwa", "opis");
		trip.addPhoto(photo);
        
		assertTrue(trip.getPhotoList().contains(photo));
		
	}
	
	
	@Test
	public void testNoPhoto() {
		Photo photo = new Photo();
		Photo anotherPhoto = new Photo();
	
        Trip trip = new Trip("nazwa", "opis");
		trip.addPhoto(photo);
        
		assertFalse(trip.getPhotoList().contains(anotherPhoto));
				
	}

}
