package studio8;

import java.util.HashSet;
import java.util.LinkedList;

public class Date {
	private final int month;
	private final int day;
	private final boolean isHoliday;
	
	public Date(int m, int d, boolean holiday) {
		this.month = m;
		this.day = d;
		this.isHoliday = holiday;
	}
	
	public String toString() {
		String[] monthNames = {"Jan", "Feb", "Mar", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
		if (this.month < 13 && this.month > 0 && this.day < 32 && this.month > 0) {
			if (isHoliday) {
				return monthNames[this.month-1] + " " + this.day + ". Today is holiday!";
			}
			return monthNames[this.month-1] + " " + this.day;
		}
		else {
			return "Invalid date";
		}
	}
	
	public boolean isEarilerThan(Date other) {
		int d = other.day;
		int mon = other.month;
		
		if (mon < this.month || (mon == this.month && d < this.day)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + (isHoliday ? 1231 : 1237);
		result = prime * result + month;
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
		if (isHoliday != other.isHoliday)
			return false;
		if (month != other.month)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Date d = new Date(12, 3, true);
		System.out.println(d.toString());
		Date d1 = new Date(1, 13, false);
		System.out.println(d1.toString());
		Date d2 = new Date(1, 13, false);
		Date d3 = new Date(1, 13, true);
		Date d4 = new Date(20, 12, false);
//		System.out.println(d2.hashCode());
//		System.out.println(d1.hashCode());
//		System.out.println(d2.equals(d3));
//		System.out.print(d2.equals(d1));
		
		LinkedList<Date> ls = new LinkedList<Date>();
		ls.add(d);
		ls.add(d1);
		ls.add(d2);
		ls.add(d3);
		ls.add(d4);
		System.out.println(ls);
		
		HashSet<Date> set = new HashSet<Date>();
		set.add(d);
		set.add(d1);
		set.add(d2);
		set.add(d3);
		set.add(d4);
		System.out.print(set);
		
		
		
	}


}
