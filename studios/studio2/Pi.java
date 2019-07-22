package studio2;

public class Pi {

	public static void main(String[] args) {
		double areaSquare = 1.0;
		int totalThrows = 10000000;
		int inCircle = 0;
		double pi;
		
		double x, y;
		
		for (int i=0; i<totalThrows; i++) {
			x = Math.random() / 2;
			y = Math.random() / 2;
			if (Math.sqrt(x*x+y*y) <= (areaSquare / 2)) {
				inCircle ++;
			}
		}
		
		
		pi = (double) 4 * inCircle / totalThrows;
		System.out.println(pi);
	}

}
