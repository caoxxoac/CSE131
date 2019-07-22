package exercises2;

public class RandomAverages {

	public static void main(String[] args) {
		//
		// Write a loop that computes the average
		//     of 1, 2, ... 1000 doubles
		// In each iteration of that loop, print
		//     the average of the doubles generated
		//     thus far.
		//
		// Your code goes below here.
		int count = 1;
		double total = 0.0;
		double average;
		while (count <= 1000) {
			total += Math.random();
			average = (double) total / count;
			System.out.println(count+" random doubles, our average is "+average);
			count ++;
		}
		System.out.println();
		
		//
		//  Some questions:
		//    1) How does the average change as your loop progresses?
		//    2) Can you write code in your loop that prints out the average only
		//         every 100 iterations, instead of each iteration?
		//
		//  Answer: the average is getting closer to 0.5 as the loop progresses
		// question (2)
		count = 1;
		total = 0.0;
		while (count <= 1000) {
			total += Math.random();
			if (count % 100 == 1) {
				average = (double) total /count;
				System.out.println(count+" random doubles, our average is "+average);
			}
			count ++;
		}
		 
	}

}
