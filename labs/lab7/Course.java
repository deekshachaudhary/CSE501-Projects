package lab7;

import java.util.LinkedList;
import lab7.Student;

public class Course {

	private String name;
	private int credits;
	private int numSeats;
	private LinkedList<Student> roster;
	private int remainingSeats;

	public Course() {
		name = null;
		credits = 0;
		numSeats = 0;
		this.roster = new LinkedList<Student>();
		remainingSeats = numSeats;
	}
	
	/**
	 * 
	 * @param name - course name
	 * @param credits - total credits
	 * @param numSeats - total number of seats
	 */

	public Course(String name, int credits, int numSeats) {
		this.name = name;
		this.credits = credits;
		this.numSeats = numSeats;
		this.remainingSeats = numSeats;
		this.roster = new LinkedList<Student>();

	}

	/**
	 * 
	 * @return student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name = student name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return number of seats
	 */
	public int getNumSeats() {
		return numSeats;
	}

	/**
	 * 
	 * @param numSeats total seats in course
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	/**
	 * 
	 * @return remaining seats
	 */
	public int getRemainingSeats() {
		return remainingSeats;
	}

	/**
	 * 
	 * @param numRemainingSeats remaining seats
	 */
	public void setRemainingSeats(int numRemainingSeats) {
		this.remainingSeats = numRemainingSeats;
	}
	
	/**
	 * 
	 * @return = list of students
	 */
	public LinkedList<Student> getRoster() {
		return roster;
	}

	/**
	 * 
	 * @param roster list of students
	 */
	public void setRoster(LinkedList<Student> roster) {
		this.roster = roster;
	}
	
	/**
	 * 
	 * @return - String list of students
	 */
	public String generateRoster() {
		for(Student student : roster) {
			if(student != null) {
				return student.getFirstName()+ " " +student.getLastName();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param s - student
	 * @return - if the student was successfully added or not
	 */
	public boolean addStudent(Student s) {
	
		if(this.roster.contains(s) || this.getRemainingSeats() == 0) {
			return false;
		}
		else {
			roster.add(s);
			remainingSeats = remainingSeats - 1;
			this.setRemainingSeats(remainingSeats);
			return true;
		}
	}

	/**
	 * 
	 * @return - average gpa of that course
	 */
	public double averageGPA() {
		double sum = 0.0;
		int count = 0;
		double currGPA;
		for(Student s : roster) {
			currGPA = s.getGPA();
			sum = sum + currGPA;
			count++;
		}
		return (double)sum/count;
	}

	@Override
	public String toString() {
		return name + ", credits:" + credits;
	}


}
