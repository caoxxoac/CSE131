package studio8;

public class Time {
	private final int minute;
	private final int hour;
	
	public Time(int min, int h) {
		this.minute = min;
		this.hour = h;
	}
	
	public String toString() {
		if (this.minute < 60 && this.minute >= 0 && this.hour < 24 && this.hour >= 0) {
			return "The time is " + this.hour + ":" + this.minute;
		}
		else {
			return "Invalid time";
		}
	}
	
	public boolean isEarilerThan(Time other) {
		int h = other.hour;
		int min = other.minute;
		
		if (h < this.hour || (h == this.hour && min < this.minute)) {
			return true;
		}
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
		Time t = new Time(20, 3);
		System.out.println(t.toString());
		Time t1 = new Time(25, 13);
		System.out.println(t1.toString());
		Time t2 = new Time(60, 10);
		System.out.println(t2.toString());
	}

}
