package studio8;

public class Appointment {
	private final Date date;
	private final Time time;
	
	public Appointment(Date d, Time t) {
		this.date = d;
		this.time = t;
	}
	
	
	public static void main(String[] args) {
		Appointment a = new Appointment(new Date(12, 31, true), new Time(12, 30));
		Appointment b = new Appointment(new Date(12, 30, true), new Time(12, 30));
		Appointment c = new Appointment(new Date(12, 31, true), new Time(12, 30));
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
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
}