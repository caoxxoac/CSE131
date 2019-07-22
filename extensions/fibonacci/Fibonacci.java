package fibonacci;

public class Fibonacci {
	
	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * @param n
	 * @return fib(n), computed recursively
	 */
	public static int recursive(int n) {
		if (n <= 1) {
			return n;
		}
		return recursive(n-1)+recursive(n-2); // FIXME
	}
	
	/**
	 * Below write your solution to Fibonacci, using iteration
	 * @param n
	 * @return fib(n), computed iteratively
	 */
	public static int iterative(int n) {
		if (n == 0) {
			return 0;
		}
		int num1 = 0;
		int num = 1;
		for (int i=0; i<n-1; i++) {
			int temp = num;
			num = num1 + num;
			num1 = temp;
		}
		return num;
	}

}
