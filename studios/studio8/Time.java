package studio8;

import java.util.LinkedList;

public class Time implements Working {
	private final int hour; // 0 to 23
	private final int minute; // 0 to 59
	private final int hourFormat;
	
	public Time(int hour, int minute, int hourFormat) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.hourFormat = hourFormat;
	}


	@Override
	public boolean amWorking() {

		if(hour >= 9 && hour <= 17) {
			listWorking.add(this);
			return true;
		}
		if(listWorking.contains(this))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		String toStringFormatted = null;
		if(hour < 12) {
			if(hourFormat == 12) {
				toStringFormatted = hour % 12 + 
						":" +minute+ " AM";		
			}
			else if(hourFormat == 24) {
				toStringFormatted = hour + ":" +minute;		
			}
		}
		
		else if(hour >= 12) {
			if(hourFormat == 12) {
				toStringFormatted = hour % 12 + 
						":" +minute+ " PM";		
			}
			else if(hourFormat == 24) {
				toStringFormatted = hour + ":" +minute;		
			}
		}
		return toStringFormatted;
	}

	public boolean isEarlierThan(Time other) {
		if(this.hour < other.hour) {
			return true;
		}
		
		else if(this.hour == other.hour) {
			if(this.minute < other.minute) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		Time t1 = new Time(8, 16, 12);
		Time t2 = new Time(11, 59, 12);
		Time t3 = new Time(23, 59, 12);
		Time t4 = new Time(20, 16, 24);
		Time t5 = new Time(11, 59, 24);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
		System.out.println(t1+ " equals to " +t2+ "? "
					+t1.equals(t2));
		System.out.println(t1+ " equals to " +t4+ "? "
					+t1.equals(t4));
		System.out.println(t2+ " equals to " +t3+ "? "
					+t2.equals(t3));
		System.out.println(t2+ " equals to " +t5+ "? "
					+t2.equals(t5));
		System.out.println(t3+ " equals to " +t4+ "? "
					+t3.equals(t4));
		System.out.println(t1+ " is earlier than " +t2+ "? "
				+t1.isEarlierThan(t2));
		System.out.println(t4+ " is earlier than " +t5+ "? "
				+t4.isEarlierThan(t5));
		
		Working w1 = new Time(9, 17, 12);
		Working w2 = new Time(3, 15, 24);
		Working w3 = new Time(9, 17, 24);
		listWorking.add(w1);
		listWorking.add(w2);
		listWorking.add(w3);
		System.out.println("Working at " +listWorking);
		System.out.println("Working at " +w1+ "? " +w1.amWorking());
		System.out.println("Working at " +t1+ "? " +t1.amWorking());
		System.out.println("Working at " +t2+ "? " +t2.amWorking());
		System.out.println("New working schedule " +listWorking);

	}

}
