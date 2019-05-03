package pl.edu.agh.mwo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PhotoTest {
    Photo photo;
	
	@Before
	public void setUp() {
		Photo photo = new Photo();
		
	}
	
	
	@Test
	public void testAddComment() {
		
		//photo.addComment("hahahaha");
		assertNotNull(photo.addComment("hahahaha"));
		
		
	}
	
}
