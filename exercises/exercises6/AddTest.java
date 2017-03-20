package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void testAdd1() {
		assertEquals(0, Add.add(0, 0));
		//
		// write other test cases here:
		//
		//copied
		for(int i=0; i < 10; i++) {
			assertEquals(i, Add.add(i, 0));
		}
	}

	@Test
	public void testAdd2() {
		//copied
		for(int i=0; i < 100; i++) {
			for(int j=0; j < 100; j++) {	
				assertEquals(i+j, Add.add(i, j));
			}
		}
	}

	@Test
	public void testAddAny() {
		assertEquals(5, Add.addAny(2, 3));
		assertEquals(-5, Add.addAny(-2, -3));
		assertEquals(1, Add.addAny(-2, 3));
		assertEquals(-1, Add.addAny(2, -3));
		for(int i=-100; i < 100; i++) {
			for(int j=-100; j < 200; j++) {	
				assertEquals(i+j, Add.addAny(i, j));
			}
		}
	
	}

}
