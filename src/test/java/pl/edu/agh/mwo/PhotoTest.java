package pl.edu.agh.mwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PhotoTest {
    Photo photo;
	
	@Before
	public void setUp() {
		photo = new Photo();
		String comment = "hahahaha";
		photo.addComment(comment);
		
	}
	
	
	@Test
	public void testAddComment() {

	    String comment = "hahahaha";  
		assertEquals(1, photo.getCommentList().size());
		assertTrue(photo.getCommentList().contains(comment));

	}
	
}
