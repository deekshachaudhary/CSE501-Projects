package lab8;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

	final private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//
		// Set the instance variable (list) to be a new linked list of Double type
		//
		list = new LinkedList<Double>();
	}
	
	public String toString() {
		String poly = "";
		for(int i = 0; i < list.size(); i++) {
			if(i == 0)
				poly = poly + Math.round(list.get(i));
			else if(i == 1)
				poly = poly+ " + "  + Math.round(list.get(i))+ "x";
			else
				poly = poly+ " + " +Math.round(list.get(i))+ "x^" +i;
		}
		return poly;
	}

	/**
	 * 
	 * @param coeff- coefficient of the new term to be added to polynomial
	 * @return new list
	 */
	public Polynomial addTerm(double coeff) {	
		list.add(coeff);
		return this;
	}

	/**
	 * 
	 * @param x- number on which we need to compute value of polynomial
	 * @return value of polynomial on point x
	 */
	public double evaluate(double x) {
		Iterator<Double> itr = list.iterator();
		if ( list.size() == 0 || list == null )
			return 0;
		//return helper(x, 0);
		return helper( x, itr );
	}

//	public double helper(double x, int index) {
//    	if(index == list.size() - 1) {
//    		return list.getLast();
//    	}
//    	else {
//    		return list.get(index) + x * helper(x, index+1);    	
//    	}
//	}

	/**
	 * 
	 * @param numFromEval- number passed from evaluate function, same as point at which we need to compute value of polynomial
	 * @param itr- a list iterator
	 * @return value of smaller instance of polynomial
	 */
	public double helper(double numFromEval, Iterator<Double> itr) {
    	if(!itr.hasNext()) {
    		return 0;
    	}
    	else {
    		return itr.next() + (numFromEval * helper(numFromEval, itr));

    	}
	}
	   
	
	/**
	 * 
	 * @return derivative of polynomial
	 */
	public Polynomial derivative() {
		Polynomial deriv = new Polynomial();
		for(int i = 1; i < list.size(); i++) {
			deriv.list.add(this.list.get(i) * i);
//			deriv.list.add(i-1, (this.list.get(i)*i));
		}
		return deriv;
	}
	
	/**
	 * 
	 * @param another- polynomial to be added to the current one
	 * @return sum of the polynomials
	 */
	public Polynomial sum(Polynomial another) {
		Polynomial result = new Polynomial();
		if(this.list.size() < another.list.size()) {
			
			for(int i = 0; i < this.list.size(); i++) {
				result.list.add(this.list.get(i) + 
						another.list.get(i));
			}
			for(int i = this.list.size(); i < another.list.size(); i++) {
				result.list.add(another.list.get(i));
			}
		}
		
		else if(this.list.size() > another.list.size()) {
			for(int i = 0; i < another.list.size(); i++) {
				result.list.add(this.list.get(i) + 
						another.list.get(i));
			}
			for(int i = another.list.size(); i < this.list.size(); i++) {
				result.list.add(this.list.get(i));
			}
		}
		
		else {
			for(int i = 0; i < this.list.size(); i++) {
				result.list.add(this.list.get(i) + 
						another.list.get(i));
			}
		}
			
		return result;
	}

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}
