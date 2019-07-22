package subsetsum;

public class SubsetSum {
	
	/**
	 * This static method will find a subset of the array that adds up to the sum provided
	 * @param allnums the set from which to find the numbers that add up to the provided sum
	 * @param sum the provided sum
	 * @return the subset of allnums that add up to sum
	 */
	public static int[] findSubset(int[] allnums, int sum) {
		int[] solution = new int[7];
//		for (int i=0; i<allnums.length; i++) {
//			for (int j=i+1; j<allnums.length; j++) {
//				for (int w=j+1; w<allnums.length; w++) {
//					for (int m=w+1; m<allnums.length; m++) {
//						for(int n=m+1; n<allnums.length; n++) {
//							for (int z=n+1; z<allnums.length; z++) {
//								for (int k=z+1; k<allnums.length; k++) {
//									int temp = allnums[i] + allnums[j] + allnums[w] +allnums[m] + allnums[n] + allnums[z] + allnums[k];
//									if (temp == sum) {
//										solution[0] = allnums[i];
//										solution[1] = allnums[j];
//										solution[2] = allnums[w];
//										solution[3] = allnums[m];
//										solution[4] = allnums[n];
//										solution[5] = allnums[z];
//										solution[6] = allnums[k];
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		return solution;
//		return isSubsetSum(allnums, sum, 7);
	}
//	
//	public static String[] isSubsetSum(int[] allnums, int sum, int n) {
//		if (sum == 0) {
//			return 
//		}
//		if (n == 0 && sum != 0) {
//			return;
//		}
//		return isSubsetSum(allnums, sum-allnums[n-1], n-1);
//	}
	
}