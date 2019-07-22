package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Enter the number of people that will enter the room: ");
		
		double[][] birthday = new double[12][31];
		
		for (int i=0; i<12; i++) {
			for (int j=0; j<31; j++) {
				birthday[i][j] = 0;
			}
		}
		
		for (int i=0; i<N; i++) {
			double randomMonth = Math.random();
			double randomDay = Math.random();
			int month = (int) (randomMonth * 12);
			int day = (int) (randomDay * 31);
			birthday[month][day] ++;
		}
		
		double sameMonth = 0;
		double sameDay = 0;
		double exactSame = 0;
		double sum = 0;
		
		for (int i=0; i<12; i++) {
			double samePerMonth = 0;
			for (int j=0; j<31; j++) {
				if (birthday[i][j] > 1) {
					samePerMonth += birthday[i][j];
					exactSame += birthday[i][j];
				}
				else {
					sum += birthday[i][j];
					System.out.println("sum: "+sum);
				}
			}

			samePerMonth = (double) samePerMonth * 100 / N;
			System.out.println("The fraction of people who born in that month is: "+samePerMonth+"%");
			sameMonth += samePerMonth;
		}
		double averageMonth = (double) sameMonth  / 12;
		System.out.println("The average of 12 values is: "+averageMonth+"%");
		System.out.println();
		
		for (int i=0; i<31; i++) {
			double samePerDay = 0;
			for (int j=0; j<12; j++) {
				if (birthday[j][i] > 1) {
					samePerDay += birthday[j][i];
				}
			}
			samePerDay = (double) samePerDay * 100 / N;
			System.out.println("The fraction of people who born on that day is: "+samePerDay+"%");
			sameDay += samePerDay;
		}
		double averageDay = (double) sameDay / 31;
		System.out.println("The average of 31 values is: "+averageDay+"%");
		
		double exactSamePercent = (double) exactSame * 100 / N; 
		System.out.println("The fraction of people born on exactly the same day: "+exactSamePercent+"%");
	}
}
