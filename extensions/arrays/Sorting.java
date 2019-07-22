package arrays;
import cse131.ArgsProcessor;

public class Sorting {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int size = ap.nextInt("Enter the size of the array: ");
		while (size <= 0) {
			size = ap.nextInt("array size cannot be smaller or equal to 0. Enter the size of the array again: ");
		}
		int sortCount = 0;
		int sum = 0;
		int min = 0;
		int max = 0;
		int range = 0;
		double mean = 0;
		double median = 0;
		
		
		int[] array = new int[size];
		for (int i=0; i<size; i++) {
			int newInt = ap.nextInt("Enter a number: ");
			array[i] = newInt;
		}
		
		
		/*
		for (int i=0; i<size; i++) {
			int min = array[i];
			int currentMin = i;
			for (int j=i+1; j<size; j++) {
				if (array[j] < min) {
					min = array[j];
					currentMin = j;
				}
			}
			if (currentMin != i) {
				int temp = array[i];
				array[i] = min;
				array[currentMin] = temp;
			}
		}
		*/
		
		while (sortCount < size) {
			int minimum = array[sortCount];
			int currentMin = sortCount;
			for (int i=sortCount; i<size; i++) {
				if (array[i] < minimum) {
					minimum = array[i];
					currentMin = i;
				}
			}
			if (currentMin != sortCount) {
				int temp = array[sortCount];
				array[currentMin] = temp;
				array[sortCount] = minimum;
			}
			sortCount ++;
		}
		
		for (int i=0; i<size; i++) {
			sum += array[i];
			System.out.print(array[i]+" ");
		}
		
		System.out.println();
		
		mean = (double) sum / size;
		median = array[size/2];
		min = array[0];
		max = array[size-1];
		range = max - min;
		System.out.println("Mean: "+mean);
		System.out.println("Median: "+median);
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
		System.out.println("Range: "+range);
	}

}
