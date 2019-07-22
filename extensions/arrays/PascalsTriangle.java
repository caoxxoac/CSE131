package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Enter the number of rows you should compute of the triangle");
		int[][] array = new int[N][N];
		
		System.out.println("      Column");
		System.out.print("      ");
		for (int i=0; i<N; i++) {
			System.out.print(i+"  ");
		}
		
		System.out.println();
		System.out.println("row");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i == j) {
					array[i][j] = 1;
				}
				else if (j == 0) {
					array[i][j] = 1;
				}
				else if (j > i) {
					array[i][j] = 0;
				}
				else {
					array[i][j] = array[i-1][j] + array[i-1][j-1];
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.print(i+"     ");
			for (int j=0; j<N; j++) {
				if (array[i][j] != 0) {
					System.out.print(array[i][j]+"  ");
				}
			}
			System.out.println();
		}
	}

}
