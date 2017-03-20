package exercises7;

/**
 * 
 * Identify the parts of this object:
 *      Constructor
 *      Instance variables
 *      Methods
 *         Accessors
 *         Mutators
 *         Other
 *
 */
public class Person {
	
	// instance variable
	private int height, age;
	
	// constructor
	public Person(int height) {
		this.height = height;
		this.age    = 0;
	}
	
	// mutator
	public void setHeight(int height) {
		this.height = height;
	}
	
	// other
	public void happyBirthday() {
		this.age = this.age + 1;
	}
	
	// accessor
	public int getHeight() {
		return this.height;
	}
	
	// accessor
	public int getAge() {
		return this.age;
	}
	

}
