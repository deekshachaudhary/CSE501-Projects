package studio8;

import java.util.LinkedList;

public class Calendar{
			
	private LinkedList<Appointment> calendar;
	
	public Calendar(LinkedList<Appointment> calendar) {
		this.calendar = calendar;
	}

	public LinkedList<Appointment> getCalendar() {
		return calendar;
	}
	
	public static void main(String args[]) {
		LinkedList<Appointment> cal = new LinkedList<>(); 
		
		cal.add(new Appointment("Take to advisor",
					new Date(10, 28, 2016, false), 
					new Time(11,0,24)));

		cal.add(new Appointment("Course registration",
				new Date(11, 10, 2016, false), 
				new Time(7,30,24)));

		System.out.println(cal);
	}

}
