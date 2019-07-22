package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numSticks = ap.nextInt("Enter the number of sticks in the pile: ");
		String goFirst = ap.nextString("Do you want to go first?(yes/no)");
		boolean playerWin = false;
		boolean playerTurn = false;
		int roundCount = 0;
		int[] startSticksArray = new int[numSticks];
		
		if (goFirst.toLowerCase().equals("yes")) {
			playerTurn = true;
			System.out.println("Player starts");
		}
		else {
			System.out.println("Computer starts");
		}
		
		while (numSticks != 0) {
			startSticksArray[roundCount] = numSticks;
			int playerTake = 0;
			int computerTake = 0;
			if (playerTurn) {
				playerTake = ap.nextInt("Enter the number of sticks you want to take: ");
				if (numSticks < playerTake || playerTake > 2 || playerTake < 1) {
					System.out.println("You can't take that number of sticks!!!");
				}
				else {
					numSticks -= playerTake;
					playerTurn = false;
					System.out.println("Round "+roundCount+", "+startSticksArray[roundCount]+ " sticks at start, human took "+playerTake
							+", so "+numSticks+" sticks remain");
					roundCount ++;
				}
				if (numSticks == 0) {
					playerWin = true;
				}
			}
			else {
				double computerRandom = Math.random();
				if (computerRandom >= 0.5 && numSticks >= 2) {
					computerTake = 2;
				}
				else {
					computerTake = 1;
				}
				numSticks -= computerTake;
				System.out.println("Round "+roundCount+", "+startSticksArray[roundCount]+ " sticks at start, computer took "+computerTake
						+", so "+numSticks+" sticks remain");
				roundCount ++;
				playerTurn = true;
			}
				
		}
		
		// print out the winner
		if (playerWin) {
			System.out.print("Player Win!!! Congrats");
		}
		else {
			System.out.println("Computer Win");
		}
	}

}
