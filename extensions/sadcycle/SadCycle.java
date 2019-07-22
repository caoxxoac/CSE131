package sadcycle;

import java.util.HashSet;
import java.util.Set;

public class SadCycle {
	public static Set<Long> findCycle(int base, long n){
		int baseHit = 0;
		Set<Long> list = new HashSet<Long>();
		long currentNum = n;
		while (baseHit < 1) {
			long sum = 0;
			sum += Math.pow(currentNum % 10, 2);
			while (currentNum / 10 != 0) {
				currentNum = currentNum / 10;
				sum += Math.pow(currentNum % 10, 2);
			}
			list.add(sum);
			if (sum == base) {
				baseHit ++;
			}
			currentNum = sum;
			System.out.println(sum);
		}
		return list;
	}
	
	public static void main(String[] args) {
		Set<Long> test = findCycle(4, 4);
	}
}
