package speeding;
import cse131.ArgsProcessor;

public class SpeedLimit {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int limitSpeed = ap.nextInt("Enter the speed limit of current road: ");
		int speed = ap.nextInt("Enter your current speed: ");
		int overSpeed = speed - limitSpeed;
		int fine = (overSpeed < 0) ? 0: ((overSpeed > 10) ? (50 + (overSpeed - 10) * 10) : 50);
		System.out.println("You reported a speed of "+speed+" MPH for a "
				+ "speed limit of "+limitSpeed+" MPH");
		System.out.println("You went "+overSpeed+" MPH over the speed limit");
		System.out.println("Your fine is $"+fine);
	}

}
