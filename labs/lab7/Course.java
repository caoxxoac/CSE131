package lab7;

import lab5.Strings;

public class Course {
	private String courseName;
	private int credits;
	private int seatsLeft;
	private int seatsTaken;
	private Student[] students;
	private String[] rosterNames;
	
	public Course(String courseName, int credits, int capacity) {
		this.courseName = courseName;
		this.credits = credits;
		this.seatsLeft = capacity;
		this.seatsTaken = 0;
		this.students = new Student[capacity];
		this.rosterNames = new String[capacity];
	}
	
	public String getName() {
		return this.courseName;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getCapacity() {
		return this.seatsLeft+this.seatsTaken;
	}
	
	public int getSeatsRemaining() {
		return this.seatsLeft;
	}

	public boolean addStudent(Student s) {
		if (this.seatsLeft == 0) {
			return false;
		}
		for (int i=0; i<this.seatsTaken; i++) {
			if (Strings.equals(this.rosterNames[i], s.getFullName())) {
				return false;
			}
		}
		this.rosterNames[this.seatsTaken] = s.getFullName();
		this.students[this.seatsTaken] = s;
		this.seatsLeft -= 1;
		this.seatsTaken += 1;
		return true;
	}
	
	public String generateRoster() {
		String roster = new String();
		for (int i=0; i<this.seatsTaken; i++) {
			roster += this.rosterNames[i];
		}
		return roster;
	}
	
	public double calculateAverageGPA() {
		double gpa = 0;
		// int allAttempt = 0;
		double allQuality = 0;
		for (int i=0; i<this.seatsTaken; i++) {
			//allAttempt += this.students[i].getTotalAttemptedCredits();
			gpa = (double) this.students[i].calculateGradePointAverage();
			allQuality += (double) gpa; // * this.students[i].getTotalAttemptedCredits();
		}
		return (double) allQuality / this.seatsTaken;
	}
	
	public String toString() {
		return this.courseName + " "+this.credits;
	}
}
