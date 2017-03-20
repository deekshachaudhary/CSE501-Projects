package studio7;

public class Complex {

	private double real, imaginary;
	
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public Complex add(Complex other) {
		Complex addRes = new Complex(this.real + other.real,
				this.imaginary + other.imaginary);
		return addRes;
	}

	// (a+bi) * (c+di) = (ac-bd) + (ad+bc)i
	// a - this.real
	// b - this.imaginary
	// c - other.real
	// d - other.imaginary
	
	public Complex multiply(Complex other) {
		Complex multRes = new Complex((this.real * other.real)
				- (this.imaginary * other.imaginary),
				(this.real * other.imaginary) + 
				(this.imaginary * other.real));
		return multRes;
	}

	@Override
	public String toString() {
		return "Complex (" +real+ "+" +imaginary+ "i)";
	}
	
	
}
