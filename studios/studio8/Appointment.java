package studio8;

import java.util.LinkedList;
import java.util.List;

public class Appointment {

	private final String description;
	private final Date date;
	private final Time time;

	public Appointment(String description, Date date, Time time) {
		this.date = date;
		this.time = time;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return description + ": " + date + ", " + time;
	}

	
	public static void main(String[] args) {
		Appointment courseReg = new Appointment("Course Registration",
					(new Date(10, 28, 2016,false)),
					new Time(11,00,24));
		Appointment deptMeeting = new Appointment("CSE Department Meeting",
					(new Date(10, 30, 2016,false)),
					new Time(1,05,12));
		Appointment iceCreamFloat = new Appointment("Ice Cream Float",
					(new Date(11, 2, 2016,false)),
					new Time(4,30,24));
		System.out.println("Appointment 1: " +courseReg);
		System.out.println("Appointment 2: " +deptMeeting);
		System.out.println("Appointment 3: " +iceCreamFloat);

	}
	

}
