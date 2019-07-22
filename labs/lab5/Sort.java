package lab5;

import cse131.NotYetImplementedException;

public class Sort {
	/**
	 * Searches an array from a starting fromIndex for the index of the
	 * lexicographically earliest value.
	 * 
	 * For example, when the array: { "A", "B", "D", "C", "E" } is paired with
	 * fromIndex: 2 the search would check the values "D", "C", and "E" and return
	 * the index of "C" which is 3.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * array, nor would it have any real reason to do so.
	 * 
	 * @param array     the array to search
	 * @param fromIndex the index from which to search until the each of the array
	 * @return the index of the lexicographically earliest value
	 */ 
	public static int findIndexOfLexicographicallyEarliestValue(String[] array, int fromIndex) {
		String minStr = "z";
		int minIndex = fromIndex;
		for (int i=fromIndex; i<array.length; i++) {
			if (Strings.isLessThan(array[i], minStr)){
				minStr = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	/**
	 * Swaps the values in the specified array at aIndex and bIndex. This will
	 * necessarily mutate (that is: change the contents of) the specified array.
	 * 
	 * For example: for array: { "A", "B", "D", "C", "E" }, aIndex: 1, and bIndex: 3
	 * the specified array will be changed to { "A", "D", "C", "B", E" }.
	 * 
	 * @param array  the array to mutate
	 * @param aIndex index whose value should be swapped with the value at
	 *               array[bIndex]
	 * @param bIndex index whose value should be swapped with the value at
	 *               array[aIndex]
	 */
	public static void swapValuesAtIndicesInPlace(String[] array, int aIndex, int bIndex) {
		String temp = array[aIndex];
		array[aIndex] = array[bIndex];
		array[bIndex] = temp;
	}

	/**
	 * Sorts the specified array into ascending lexicographical order. This will
	 * necessarily mutate (that is: change the contents of) the specified array.
	 * 
	 * @param array the array to sort in place
	 */
	public static void selectionSortInPlace(String[] array) {
		for (int i=0; i<array.length; i++) {
			int minIndex = i;
			for (int j=i; j<array.length; j++) {
				if (Strings.isLessThan(array[j], array[minIndex])){
					minIndex = j;
				}
			}
			String temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * Determines if the specified array is sorted in ascending lexicographical
	 * order.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * array, nor would it have any real reason to do so.
	 * 
	 * @param array the array to determine whether or not it is sorted
	 * @return true if the array is sorted, otherwise false.
	 */
	public static boolean isSorted(String[] array) {
		boolean isSorted = true;
		for (int i=0; i<array.length; i++) {
			for (int j=i; j<array.length; j++) {
				if (Strings.isLessThan(array[j], array[i])) {
					isSorted = false;
				}
			}
		}
		return isSorted;
	}
} 
