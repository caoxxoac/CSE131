package homeowning;
import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		String apartmentName = ap.nextString("Enter the apartment name: ");
		String zip = ap.nextString("Enter the zip code of your apartment: ");
		double rent = ap.nextDouble("Enter the monthly rent of the apartment: ");
		double dailyInterest = ap.nextDouble("Enter the daily interest payment for your mortgage on the house: ");
		
		int rentCent = (int) (rent * 100);
		int dailyInterestCent = (int) (dailyInterest * 100);
		String action;
		
		int rentYear = rentCent * 12;
		int rentWeek = rentYear / 52;
		
		int weekInterest = dailyInterestCent * 7;
		int yearInterest = dailyInterestCent * 365;
		
		System.out.println(apartmentName+" is located in the Zip Code "+zip);
		System.out.println("Rent per year: "+(rentYear/100)+"."+(rentYear%100));
		System.out.println("Rent per week: "+(rentWeek/100)+"."+(rentWeek%100));
		System.out.println();
		System.out.println("Interest paid per year: "+(yearInterest/100)+"."+(yearInterest%100));
		System.out.println("Interest paid per week: "+(weekInterest/100)+"."+(weekInterest%100));
		
		if (yearInterest > rentYear) {
			action = "rent";
		}
		else {
			action = "own";
		}
		System.out.println("I should "+action);
	}

}
