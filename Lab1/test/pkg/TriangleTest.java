package pkg;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {
	
	private Triangle triangle;
	
	@Before
	public void setUp() {
		
		triangle = new Triangle();
	}
	
	@After
	public void tearDown() {
		
		triangle = null;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testException() {
		
		triangle.givable(0);
	}
	
	@Test
	public void testGivable() {
		
		assertEquals(triangle.givable(1), true);
		assertEquals(triangle.givable(80), true);
		assertEquals(triangle.givable(83), true);
		assertEquals(triangle.givable(84), false);
	}
}
