package baseball;
import cse131.ArgsProcessor;

public class BaseballStats {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("Enter the name of the player: ");
		
		int atBats = ap.nextInt("Enter the number of at-bats the player has provided: ");
		int hits = ap.nextInt("Enter the number of hits ");
		
		String allStar = "Not A All Star";
		double batAverage = (double) hits / atBats;
		batAverage = (double) Math.round(batAverage * 1000) / 1000;
		
		if (atBats >= 200 && batAverage >= 0.27) {
			allStar = "An All Star";
		}
		
		System.out.println(name+" has a batting average: "+batAverage+". And he is "+allStar);
	}

}
