package exercises2;

import cse131.ArgsProcessor;

public class Heads {

	public static void main(String[] args) {

		// what are the concepts?
		int numHeads = 0;
		int numFlips = 0;
		
		// to count the total flips of all experiments
		int totalFlips = 0;
		// average number of flips to achieve 10 heads
		double averageFlips = 0;

		// let user enter the number of experiment times
		ArgsProcessor ap = new ArgsProcessor(args);
		int times = ap.nextInt("How many times do you want to run the experiment? ");
		
		// now flip a coin until we see 10 heads
		for (int i=0; i<times; i++) {
			numHeads = 0;
			while (numHeads != 10) {
				boolean isHeads = Math.random() < 0.5;
				if (isHeads) {
					numHeads = numHeads + 1;
				}
				numFlips = numFlips + 1;
				totalFlips += 1;
			}
		}
		
		averageFlips = (double) totalFlips / times;		
		System.out.println("For "+times+" times of experiments, "+
				"the average numbe of coin flips to achieve 10 heads is "+averageFlips);

	}

}
