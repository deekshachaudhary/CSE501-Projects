package studio7;

import java.math.BigInteger;

public class Fraction {

	private int numerator, denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;		
	}
	
	public Fraction simplify() {
		// googled gcd built in function java
		
		int gcd = (BigInteger.valueOf(this.numerator)
				.gcd(BigInteger.valueOf(this.denominator)))
				.intValue();
		Fraction simplifiedRes;
		if(gcd == 1) {
			 simplifiedRes = new Fraction(this.numerator, this.denominator);
			 return simplifiedRes;
		}
		else {
			simplifiedRes = new Fraction(this.numerator/gcd, this.denominator/gcd);
			return simplifiedRes;
		}
	}
	
	public Fraction add(Fraction other) {
		int additionResDen = this.denominator * other.denominator;
		int additionResNum = this.numerator * other.denominator + 
							other.numerator * this.denominator;
		return (new Fraction(additionResNum, additionResDen).simplify());
	}
	
	public Fraction multiply(Fraction other) {
		Fraction multRes = new Fraction(this.numerator * other.numerator, 
							this.denominator * other.denominator);
		return multRes.simplify() ;
	}
	
	public Fraction reciprocal() {
		return new Fraction(this.denominator,this.numerator);
	}
	
	@Override
	public String toString() {
		return "Fraction " + numerator + "/" + denominator;
	}

//	public static void main(String[] args) {
//		Fraction f1 = new Fraction(3,4);
//		Fraction f2 = new Fraction(2,6);
//		System.out.println("Sum of " +f1+ " and " +f2+ ": " +f1.add(f2));
//		System.out.println("Product of " +f1+ " and " +f2+ ": " +f1.multiply(f2));
//		System.out.println("Reciprocal of " +f1+ ": " +f1.reciprocal());
//		System.out.println("Reciprocal of " +f2+ ": " +f2.reciprocal());
//		System.out.println("Simplification of " +f1+ ": " +f1.simplify());
//		System.out.println("Simplification of " +f2+ ": " +f2.simplify());
//		
//	}
}
