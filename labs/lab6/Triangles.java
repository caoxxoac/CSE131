package lab6;

import sedgewick.StdDraw;

public class Triangles {
	public static void main(String[] args) {
		StdDraw.setXscale(-1, +1);
		StdDraw.setYscale(-1, +1);
		
		double[] x = {-1, 0, 1};
		double[] y = {-Math.sqrt(3)/2, Math.sqrt(3)/2, -Math.sqrt(3)/2};
		StdDraw.filledPolygon(x, y);
		StdDraw.line(-1, -Math.sqrt(3)/2, 1, -Math.sqrt(3)/2);
		StdDraw.line(-1, -Math.sqrt(3)/2, 0, Math.sqrt(3)/2);
		StdDraw.line(1, -Math.sqrt(3)/2, 0, Math.sqrt(3)/2);
		recursiveTriangles(0, 0, 1);
	}
	
	public static void recursiveTriangles(double x, double y, double length) {
		if (length < 0.03) {
			return;
		}
		else {
			double[] xSet = {x-length/2, x, x+length/2};
			double[] ySet = {y, y-length*Math.sqrt(3)/2, y};
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledPolygon(xSet, ySet);
			
//			StdDraw.line(x-length/2, y, x+length/2, y);
//			StdDraw.line(x-length/2, y, x, y-length*Math.sqrt(3)/2);
//			StdDraw.line(x+length/2, y, x, y-length*Math.sqrt(3)/2);
			
			
			recursiveTriangles(x-length/2, y-length*Math.sqrt(3)/4, length/2);
			recursiveTriangles(x+length/2, y-length*Math.sqrt(3)/4, length/2);
			recursiveTriangles(x, y+length*Math.sqrt(3)/4, length/2);
		}
	}
}
