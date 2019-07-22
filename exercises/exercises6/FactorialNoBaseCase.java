package exercises6;

public class FactorialNoBaseCase {
	
	// since we do not have a base case in this factorial method,
	// the program will never know where to stop
	public static int factorial(int n) {
		return n * factorial(n-1);
	}

	public static void main(String[] args) {
		int ans = factorial(2);
		System.out.println("Answer is " + ans);
	}
}
