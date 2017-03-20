package lab7;

public class Student {

	private String firstName;
	private String lastName;
	private int studentId;
	private int credits;
	private double gpa;
	
	public Student() {
		this.firstName = null;
		this.lastName = null;
		this.studentId = 0;
		this.credits = 0;
		this.gpa = 0;
	}

	
	/**
	 * 
	 * @param firstName - first name of student
	 * @param lastName - last name of student
	 * @param studentId - student id
	 */
	public Student(String firstName, String lastName, int studentId) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.credits = 0;
		this.gpa = 0;
	}

	/**
	 * 
	 * @param firstName = first name
	 * @param lastName = lastname
	 * @param studentId = id
	 * @param credits = credits taken
	 * @param gpa = gpa
	 */
	public Student(String firstName, String lastName, int studentId,
			      int credits, double gpa) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.credits = credits;
		this.gpa = gpa;
	}	
	
	/**
	 * 
	 * @return credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * 
	 * @param credits = credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * 
	 * @return gpa
	 */
	public double getGPA() {
		return gpa;
	}

	/**
	 * 
	 * @param gpa = gpa
	 */
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	/**
	 * 
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return firstName+ " " +lastName;
	}

	/**
	 * 
	 * @return student id
	 */
	public int getStudentID() {
		return studentId;
	}
	
	@Override
	public String toString() {
		return "Student firstName= " + firstName + 
				", lastName= " + lastName +
				", StudentId= " + studentId;
	}

	/**
	 * 
	 * @return = returns class standing
	 */
	public String getClassStanding() {
		String classStanding = null;
		if (this.credits < 30)
			classStanding = "Freshman";
		else if (this.credits >= 30 && this.credits < 60)
			classStanding = "Sophomore";
		else if (this.credits >= 60 && this.credits < 90)
			classStanding = "Junior";
		else if (this.credits >= 90)
			classStanding = "Senior";
		return classStanding;
	}
	
	/**
	 * 
	 * @param courseGrade = grade scored in that course
	 * @param courseCredits = credits of that course
	 * @return = updated gpa
	 */
	public double submitGrade(double courseGrade, int courseCredits) {
		
		double qualityScore = courseCredits * courseGrade;
		this.gpa = ((this.gpa*this.credits) + qualityScore)
				/ (this.credits + courseCredits);
		double inter1 = this.gpa * 1000;
		double inter2 = Math.round(inter1);
		this.gpa = (double) inter2/1000;
		this.credits += courseCredits;
		return this.gpa;
	}

	/**
	 * 
	 * @param student = one of the parents
	 * @return = child student
	 */
	public Student createLegacy(Student student) {
		String childFirstName = this.getFirstName();
		String childLastName = student.getLastName();
		int childId = this.getStudentID() + student.getStudentID();
		double childGpa = (this.getGPA() + student.getGPA()) / 2;
		int childCredits = Math.max(this.getCredits(), student.getCredits());
		Student child = new Student(childFirstName, childLastName,
				childId, childCredits, childGpa);
		return child;
	}
}
