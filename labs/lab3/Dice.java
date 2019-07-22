package lab3;
import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int diceNumber = ap.nextInt("Enter the number of dice you want to use: ");
		int throwTimes = ap.nextInt("Enter the number of times you want to throw: ");
		
		int[][] dice = new int[throwTimes][diceNumber];
		int[] sumPossibleNum = new int[diceNumber*5+1];
		
		double frequency = 0;
		double sumFrequency = 0;
		int sameValue = 0;
		
		for (int i=0; i<throwTimes; i++) {
			for (int j=0; j<diceNumber; j++) {
				double randomNum = Math.random();
				int diceNum = (int) (randomNum * 6) + 1;
				dice[i][j] = diceNum;
			}
		}
		
		for (int i=0; i<throwTimes; i++) {
			for (int j=0; j<diceNumber; j++) {
				System.out.print(dice[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i=0; i<throwTimes; i++) {
			boolean same = true;
			int currentValue = dice[i][0];
			for (int j=1; j<diceNumber; j++) {
				if (dice[i][j] != currentValue) {
					same = false;
				}
			}
			if (same) {
				sameValue ++;
			}
		}
		
		for (int i=0; i<diceNumber*5+1; i++) {
			sumPossibleNum[i] = 0;
		}
		
		for (int i=0; i<throwTimes; i++) {
			int currentSum = 0;
			for (int j=0; j<diceNumber; j++) {
				currentSum += dice[i][j];
			}
			sumPossibleNum[currentSum-diceNumber] ++;
		}
		frequency = (double) sameValue / throwTimes;
		System.out.println("The number of same value we found is: "+sameValue);
		System.out.println("Frequency: "+frequency);
		
		System.out.println();
		System.out.println("Sum \t The number of times exits");
		for (int i=0; i<5*diceNumber+1; i++) {
			if (sumPossibleNum[i] != 0) {
				sumFrequency = (double) sumPossibleNum[i] / throwTimes;
				System.out.println((i+diceNumber)+"\t"+sumPossibleNum[i]+"\t"+sumFrequency);
			}
		}
	}

}
