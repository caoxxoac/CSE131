package studio3;
import cse131.ArgsProcessor;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int userInput = ap.nextInt("The prime numbers under what number? ");
		
		// since we do not want to include 0 and 1
		int[] numbers = new int[userInput-2];
		for (int i=0; i<userInput-2; i++) {
			numbers[i] = i+2;
		}
		for (int i=0; i<userInput-2; i++) {
			if ((i+2)*2 < userInput) {
				numbers[(i+2)*2-2] = 0;
			}
			if ((i+2)*3 < userInput) {
				numbers[(i+2)*3-2] = 0;
			}
			if ((i+2)*5 < userInput) {
				numbers[(i+2)*5-2] = 0;
			}
			if ((i+2)*7 < userInput) {
				numbers[(i+2)*7-2] = 0;
			}
		}
		System.out.print("Prime number under "+userInput+" =");
		for (int i=0; i<userInput-2; i++) {
			if (numbers[i] != 0) {
				System.out.print(" "+numbers[i]);
			}
		}
	}

}
