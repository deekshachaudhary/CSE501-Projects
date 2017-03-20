package studio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest {

	Complex c1 = new Complex(2,3);
	Complex c2 = new Complex(4,5);
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void addTest() {
		Complex c3 = new Complex(6,8);
		if(c3.equals(c1.add(c2)))
			assert(true);
	}

	@Test
	public void multiplyTest() {
		// a+bi x c+di = (ac-bd) + (ad+bc)i
		// 2+3i x 4+5i = 8-15   +   10+12
		
		Complex c3 = new Complex(-7, 22);
		if(c3.equals(c1.multiply(c2)))
			assert(true);
	}
	
}
