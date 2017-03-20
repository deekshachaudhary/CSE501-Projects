package studio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTests {

//	Rectangle r1 = new Rectangle(3,4);
//	Rectangle r2 = new Rectangle(5,4);
//	Rectangle r3 = new Rectangle(4,4);

//	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void area() {
		for(double l = 0; l < 100; l++) {
			for(double w = 0; w < 100; w++) {
				Rectangle r = new Rectangle(l,w);
				assertEquals(l*w, r.area(), 1e-8);				
			}
		}
	}
	
	@Test
	public void perimeter() {
		for(double l = 0; l < 100; l++) {
			for(double w = 0; w < 100; w++) {
				Rectangle r = new Rectangle(l,w);
				assertEquals(2*(l+w), r.perimeter(), 1e-8);				
			}
		}
	}

	@Test
	public void isSmallerThan() {
		for(double l1 = 0; l1 < 100; l1++) {
			for(double w1 = 0; w1 < 100; w1++) {
				Rectangle r1 = new Rectangle(l1,w1);
				Rectangle r2 = new Rectangle(100-l1,100-w1);
				if(l1*w1 < (100-l1)*(100-w1))
					assertEquals(true, r1.isSmallerThan(r2));
			}
		}
	}
	
	
	public void isSquare() {
		for(double l = 0; l < 100; l++) {
			for(double w = 0; w < 100; w++) {
				Rectangle r = new Rectangle(l,w);
				if(l == w)
					assertEquals(true, r.isSquare());
			}

		}
	}
}