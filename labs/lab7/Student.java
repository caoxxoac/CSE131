package lab7;

public class Student {
	private String firstname;
	private String lastname;
	private final int studentid;
	private int totalAttempt;
	private int totalPass;
	private double GPA;
	private double qualityPoints;
	private double bearBucks;
	
	public Student(String fn, String ln, int id) {
		this.firstname = fn;
		this.lastname =ln;
		this.studentid = id;
		this.totalAttempt = 0;
		this.totalPass = 0;
		this.GPA = Float.NaN;
		this.bearBucks = 0;
	}
	
	
	public String getFullName() {
		return this.firstname + " " + this.lastname;
	}
	
	public int getId() {
		return this.studentid;
	}
	
	public void submitGrade(double grade, int credits) {
		if (Double.isNaN(this.GPA)) {
			this.GPA = 0;
		}
		if (grade >= 1.7) {
			this.totalPass += credits;
		}
		this.qualityPoints = (double) this.totalAttempt * this.GPA + grade * credits;
		this.totalAttempt += credits;
		this.GPA = this.qualityPoints / this.totalAttempt;
	}
	
	public int getTotalAttemptedCredits() {
		return this.totalAttempt;
	}
	
	public int getTotalPassingCredits() {
		return this.totalPass;
	}
	
	public double calculateGradePointAverage() {
		return this.GPA;
	}
	
	public String getClassStanding() {
		if (this.totalPass < 30) {
			return "FirstYear";
		}
		else if (this.totalPass >= 30 && this.totalPass < 60) {
			return "Sophomore";
		}
		else if (this.totalPass >= 60 && this.totalPass < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		if (this.totalPass >= 98 && this.GPA >= 3.6) {
			return true;
		}
		else if (this.totalPass >= 75 && this.GPA >= 3.8) {
			return true;
		}
		return false;
	}
	
	public void depositBearBucks(double amount) {
		this.bearBucks += amount;
	}
	
	public void deductBearBucks(double amount) {
		this.bearBucks -= amount;
	}
	
	public double getBearBucksBalance() {
		return this.bearBucks;
	}
	
	public double cashOutBearBucks() {
		if (this.bearBucks <= 10) {
			return 0;
		}
		else {
			return this.bearBucks - 10;
		}
	}
	
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		this.bearBucks = this.cashOutBearBucks();
		otherParent.bearBucks = otherParent.cashOutBearBucks();
		Student child = new Student(firstName, this.lastname, id);
		if (isHyphenated) {
			child = new Student(firstName, this.lastname+"-"+otherParent.lastname, id);
			
		}
		child.bearBucks = this.bearBucks + otherParent.bearBucks;
		this.bearBucks = 0;
		otherParent.bearBucks = 0;
		return child;
	}
	
	public String toString() {
		return this.firstname + " " + this.lastname + " " + this.studentid;
	}
}