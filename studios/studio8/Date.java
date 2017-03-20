package studio8;

import java.util.HashSet;
import java.util.LinkedList;

public class Date implements Working{
	
	private final int month;
	private final int day;
	private final int year;
	private final boolean isHoliday;
	
	public Date(int month, int day, int year, boolean isHoliday) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
		this.isHoliday = isHoliday;
	}

	@Override
	public boolean amWorking() {
		if(day % 2 == 0) {
			listWorking.add(this);
			return true;
		}
		else if(listWorking.contains(this))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
			return month + "/" + day + "/" + year;
	}

	public String getIsHoliday() {
		if(isHoliday) {
			return "Its a holiday!!";
		}
		else
			return "Its not a holiday";
	}
	
	public boolean isEarlierThan(Date other) {
		if(this.year < other.year) {
			return true;
		}
		else if(this.year == other.year) {
			if(this.month < other.month) {
				return true;
			}
		
			if(this.month == other.month) {
				if(this.day < other.day) {
					return true;
				}
				else
					return false;
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
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
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
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		Date date1 = new Date(9, 27, 2016, false);
		Date date2 = new Date(9, 30, 2016, true);
		Date date3 = new Date(9, 25, 2016, true);
		Date date4 = new Date(9, 27, 2016, false);
		Date date5 = new Date(9, 30, 2016, true);
		Date date6 = new Date(9, 30, 2016, false);
		Date date7 = new Date(9, 30, 2015, true);

		LinkedList<Date> list = new LinkedList<Date>();
		list.add(date1);
		list.add(date2);
		list.add(date4);
		System.out.println("List elements: " +list);
		list.add(2, date3);
		System.out.println("Elements after adding " +date3+ 
							": " +list);
		System.out.println("Index of "+date3+ ": " 
					+list.indexOf(date3));
		System.out.println("Size: " +list.size());
		System.out.println(date5+ " added successfully: " +list.add(date5));
		System.out.println(date7+ " added successfully: " +list.add(date7));
		System.out.println("Size now: " +list.size());
		System.out.println("Sublist: " +list.subList(1, 4));
		System.out.println(date4+ " removed: " +list.remove(date4));

		// same code but with hashSet
		//	indexOf, sublist, and adding to a particular
		//	index wont work because set does't have an order
		//	so nothing related to indexes would work
		
		HashSet<Date> hashSet = new HashSet<Date>();
		hashSet.add(date1);
		hashSet.add(date2);
		hashSet.add(date4);
		System.out.println("-------For HashSet-------");
		System.out.println("HashSet elements: " +hashSet);
		System.out.println("Elements after adding " +date3+ 
							": " +hashSet);
		System.out.println("Size: " +hashSet.size());
		System.out.println(date5+ " added successfully: " +hashSet.add(date5));
		System.out.println(date7+ " added successfully: " +hashSet.add(date7));
		System.out.println("Size now: " +hashSet.size());
		System.out.println(date4+ " removed: " +hashSet.remove(date4));

		
		System.out.println(date1);
		System.out.println(date1 + " " + date1.getIsHoliday());
		System.out.println(date2);
		System.out.println(date2 + " " + date2.getIsHoliday());
		System.out.println(date3);
		System.out.println(date3 + " " + date3.getIsHoliday());
		System.out.println(date7);
		System.out.println(date1+ " equals to " +date2+ ": " 
						+ date1.equals(date2));
		System.out.println(date1+ " equals to " +date4+ ": " 
						+ date1.equals(date4));
		System.out.println(date1+ " equals to " +date5+ ": " 
						+ date1.equals(date5));
		System.out.println(date1+ " equals to " +date6+ ": " 
						+ date1.equals(date6));
		System.out.println(date5+ " equals to " +date6+ ": " 
						+ date5.equals(date6));
		System.out.println(date5+ " equals to " +date7+ ": " 
				+ date5.equals(date7));
		System.out.println(date5+ " earlier than " +date6+ ": " 
				+ date5.isEarlierThan(date6));
		System.out.println(date5+ " earlier than " +date7+ ": " 
				+ date5.isEarlierThan(date7));
		System.out.println(date7+ " earlier than " +date5+ ": " 
				+ date7.isEarlierThan(date5));
		
		Working w4 = new Date(8, 11, 2016, false);
		Working w5 = new Date(8, 12, 2016, true);
		Working w6 = new Date(8, 12, 2016, false);
		listWorking.add(w4);
		listWorking.add(w5);
		listWorking.add(w6);
		System.out.println("Working on " +listWorking);
		System.out.println("Working on " +w4+ "? " +w4.amWorking());
		System.out.println("Working on " +date1+ "? " +date1.amWorking());
		System.out.println("Working on " +date2+ "? " +date2.amWorking());
		System.out.println("New working schedule " +listWorking);
	
	}
}
