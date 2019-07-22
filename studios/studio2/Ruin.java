package studio2;
import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int startAmount = ap.nextInt("Enter the amount of money you start with: ");
		while (startAmount <= 0) {
			System.out.println("The start amount cannot be less than or equal to 0!!! Try it one more time");
			startAmount = ap.nextInt("Enter the amount of money you start with: ");
		}
		double winChance = ap.nextDouble("Enter the probability that you win a gamble: ");
		while (winChance < 0 && winChance > 1) {
			System.out.println("The win chance cannot be less than 0 or greater than 1!!! Try it one more time");
			winChance = ap.nextDouble("Enter the probability that you win a gamble: ");
		}
		int winAmount = ap.nextInt("Enter the amount of money you need to win: ");
		while (winAmount < startAmount) {
			System.out.println("The amount of money for win cannot be less than the startAmount!!! Try it one more time");
			winAmount = ap.nextInt("Enter the amount of money you need to win: ");
		}
		int totalPlays = ap.nextInt("Enter the number of times you simulate the problem: ");
		while (totalPlays <= 0) {
			System.out.println("The number of times you play cannot be less than or equal to 0!!! Try it one more time");
			totalPlays = ap.nextInt("Enter the number of times you simulate the problem: ");
		}
		boolean win = false;
		int numWins = 0;

		double lossChance = 1 - winChance;
		double Ruin;
		if (lossChance != winChance) {
			Ruin = (Math.pow((lossChance / winChance), startAmount) -
					Math.pow((lossChance / winChance), winAmount)) / (1 - Math.pow((lossChance / winChance), winAmount));
		}
		else {
			Ruin = 1 - startAmount / winAmount;
		}
		
		for (int i=0; i<totalPlays; i++) {
			int money = startAmount;
			int rounds = 0;
			while (winAmount > money && money > 0) {
				if (Math.random() < 0.25) {
					money ++;
				}
				else {
					money --;
				}
				rounds ++;
			}
			if (money != 0) {
				win = true;
			}
			else {
				win = false;
			}
			
			// check if user win
			if (win) {
				System.out.println("Simulation "+(i+1)+": "+rounds+" rounds         WIN");
				numWins ++;
			}
			else {
				System.out.println("Simulation "+(i+1)+": "+rounds+" rounds         LOSE");
			}
		}
		
		// print everything
		System.out.println("Losses: "+(totalPlays-numWins)+"   Simulations: "+totalPlays);
		System.out.println("Actual Ruin Rate: "+((double)(totalPlays-numWins)/totalPlays)+
				"  Expected Ruin Rate: "+Ruin);
	}

}
