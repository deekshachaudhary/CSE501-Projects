package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumTest {

	@Test
	public void testSum() {
		assertEquals(0, Sum.sum(0));
		assertEquals(1, Sum.sum(1));
		assertEquals(3, Sum.sum(2));
		assertEquals(15, Sum.sum(5));
		
		// copied from solution
		for(int i = 0; i < 1000; i++) {
			int sum = i*(i+1)/2;
			assertEquals(sum, Sum.sum(i));
		}
	}
}
