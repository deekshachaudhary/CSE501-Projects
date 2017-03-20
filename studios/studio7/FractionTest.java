package studio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	Fraction f1 = new Fraction(3,4);
	Fraction f2 = new Fraction(2,6);

	@Test
	public void test() {
		fail("Not yet implemented");
	}


	//	System.out.println("Sum of " +f1+ " and " +f2+ ": " +f1.add(f2));
	//	System.out.println("Product of " +f1+ " and " +f2+ ": " +f1.multiply(f2));
	//	System.out.println("Reciprocal of " +f1+ ": " +f1.reciprocal());
	//	System.out.println("Reciprocal of " +f2+ ": " +f2.reciprocal());
	//	System.out.println("Simplification of " +f1+ ": " +f1.simplify());
	//	System.out.println("Simplification of " +f2+ ": " +f2.simplify());

	@Test
	public void addTest() {
		Fraction f3 = new Fraction(13,12);
		if(f3.equals(f1.add(f2)))
			assert(true);
	}

	@Test
	public void multiplyTest() {
		Fraction f3 = new Fraction(1,4);
		if(f3.equals(f1.multiply(f2)))
			assert(true);
	}

	@Test
	public void reciprocalTest() {
		Fraction f3 = new Fraction(4,3);
		Fraction f4 = new Fraction(6,2);
		if(f3.equals(f1.reciprocal()) &&
				f4.equals(f2.reciprocal())) {
			assert(true);
		}
	}

	@Test
	public void simplifyTest() {
		Fraction f3 = new Fraction(3,4);
		Fraction f4 = new Fraction(1,4);
		if(f3.equals(f1.simplify()) && 
				f4.equals(f2.simplify())) { 
			assert(true);
		}
	}
}
