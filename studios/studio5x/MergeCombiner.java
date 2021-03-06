package studio5x;

import cse131.NotYetImplementedException;
import lab5.Strings;

public class MergeCombiner {
	/**
	 * Produces an array which is the sorted result of merging the two specified,
	 * sorted input arrays a and b.
	 * 
	 * For example, when the arrays { "E", "G", "N" } and {"B", "I", "S" } are
	 * passed to this method, the resulting array { "B", "E", "G", "I", "N", "S" }
	 * should be returned.
	 * 
	 * If either input array a or b is unsorted, then the results are undefined.
	 * 
	 * This method must not mutate (that is: change the contents of) the input
	 * arrays a or b, nor would it have any real reason to do so.
	 * 
	 * @param a
	 *            a sorted array
	 * @param b
	 *            another sorted array
	 * @return a new array which contains the contents of both a and b, sorted.
	 */
	public static String[] createMergeCombinedArray(String[] a, String[] b) {
		int arrayLength = a.length + b.length;
		String[] c = new String[arrayLength];
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		while (cIndex < (a.length+b.length)) {
			if (bIndex < b.length && aIndex < a.length) {
				if (Strings.isLessThan(a[aIndex], b[bIndex])) {
					c[cIndex++] = a[aIndex++];
				}
				else {
					c[cIndex++] = b[bIndex++];
				}
			}
			else if (aIndex >= a.length) {
				c[cIndex++] = b[bIndex++];
			}
			else if (aIndex < a.length) {
				c[cIndex++] = a[aIndex++];
			}
		}
		return c;
	}
}
