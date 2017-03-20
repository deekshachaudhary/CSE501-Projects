package studio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void randomInt() {
		for(int i = 1; i <= 50; i++) {
			Die d = new Die(i);
			if(Math.abs(1-i) <= d.randomInt())
				assert(true);
		}
	}
}
