package studio1;
import cse131.ArgsProcessor;

public class Grading {

	public static void main(String[] args) {
		// initialize the grading percentage of each fields
		double participationPercentage = 0.05;
		double quizPercentage = 0.05;
		double studioPercentage = 0.1;
		double labPercentage = 0.25;
		double extensionPercentage = 0.25;
		double examPercentage = 0.3;
		double score = 0;
		boolean plus, minus;
		
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("Enter your name: ");
		double participation = ap.nextDouble("Enter your participation points: ");
		double quiz = ap.nextDouble("Enter your average quiz score: ");
		double studio = ap.nextDouble("Enter the number of studio points you received: ");
		double lab = ap.nextDouble("Enter the number of lab points you received: ");
		double extension = ap.nextDouble("Enter the extension points you received: ");
		double examOne = ap.nextDouble("Enter your exam one score: ");
		double examTwo = ap.nextDouble("Enter your exam two score: ");
		double examThree = ap.nextDouble("Enter your exam three score: ");
		
		score += participation * participationPercentage;
		score += quiz * quizPercentage;
		score += studio * studioPercentage;
		score += lab * labPercentage;
		score += extension * extensionPercentage;
		score += (examOne + examTwo + examThree) / 3.0 * examPercentage;
		
		if (score%10 < 3) {
			plus = false;
			minus = true;
		}
		else if (score%10 >= 7) {
			plus = true;
			minus = false;
		}
		else {
			plus = false;
			minus = false;
		}
		
		System.out.println(name+":");
		System.out.println("    Total Score: "+score);
		System.out.println("    Grade for this course: "+(int)score);
		System.out.println("    Final grade has a...");
		System.out.println("        Plus: "+plus);
		System.out.println("        Minus: "+minus);
	}
}
