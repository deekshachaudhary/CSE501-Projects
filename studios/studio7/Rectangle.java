package studio7;

public class Rectangle {

	private double length, width;
	
	public Rectangle() {
		this.length = 0;
		this.width = 0;
	}

	/**
	 * 
	 * @param length
	 * @param width
	 */
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double area() {
		return this.length * this.width;
	}
	
	public double perimeter() {
		return 2*(this.length + this.width);
	}
	
	/**
	 * 
	 * @param other the rectangle whose area is to be compared with
	 * @return
	 */
	public boolean isSmallerThan(Rectangle other) {
		if(this.area() < other.area())
			return true;
		else
			return false;
	}
	
	public boolean isSquare() {
		if(this.length == this.width)
			return true;
		else
			return false;		
	}
}
