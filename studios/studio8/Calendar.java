package studio8;

public class Calendar {
	public final Appointment appointment;
	
	public Calendar(Appointment a) {
		this.appointment = a;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
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
		Calendar other = (Calendar) obj;
		if (appointment == null) {
			if (other.appointment != null)
				return false;
		} else if (!appointment.equals(other.appointment))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Appointment a = new Appointment(new Date(12, 31, true), new Time(12, 30));
		Appointment b = new Appointment(new Date(12, 30, true), new Time(12, 30));
		Appointment c = new Appointment(new Date(12, 31, true), new Time(12, 30));
		
		Calendar cal1 = new Calendar(a);
		Calendar cal2 = new Calendar(b);
		Calendar cal3 = new Calendar(c);
		
		System.out.println(cal1.equals(cal3));
		System.out.println(cal1.equals(cal2));
	}
}
