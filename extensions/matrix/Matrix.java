package matrix;

import java.util.Arrays;

public class Matrix {
	
	private double[][] values;
		
	/**
	 * The Matrix is based on the supplied two-dimensional array of values.
	 * Be sure to make your own copy of the values, so that changes to the
	 *    array outside of this class do not affect your work.
	 * @param values
	 */
	public Matrix(double[][] in) {
		if (in.length > 0) {
			this.values = new double[in.length][in[0].length];
			for (int i=0; i<in.length; i++) {
				for (int j=0; j<in[i].length; j++) {
					this.values[i][j] = in[i][j];
				}
			}
		}
		else {
			this.values = new double[][]{};
		}
				 // FIXME -- make a copy of in
		                //  this is not the same thing as writing:
		                //  values = in
	}
	
	public double getValue(int row, int col) {
		return this.values[row][col];  // Do not change this!
	}
	
	public int getNumRows() {
		return values.length;  // Do not change!
	}
	
	public int getNumCols() {
		return values[0].length; // Do not change!
	}
	
	/**
	 * You must complete this method, or the equals(Object) test will always
	 *   return false. 
	 * Arrays one and two are considered
	 * equal if and only if:
	 *   1) They have the same shape (number of rows and columns agree)
	 *   2) The contents of the two arrays are the same, element by element
	 * @param one
	 * @param two
	 * @return true iff the arrays have the same shape and contents
	 */
	private static boolean arraysAreEqual(double[][] one, double[][] two) {
		int oneRow = one.length;
		int twoRow = two.length;
		if (oneRow != twoRow) {
			return false;
		}
		if (oneRow == 0) {
			return true;
		}
		int oneColumn = one[0].length;
		int twoColumn = two[0].length;
		if (oneColumn != twoColumn) {
			return false;
		}
		for (int i=0; i<oneRow; i++) {
			for (int j=0; j<oneColumn; j++) {
				if (one[i][j] != two[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This was generated initially by eclipse, but
	 *   eclipse does not know how to compare two-dimensional arrays.
	 *   We therefore call arraysAreEequal to do that job.
	 */
	public boolean equals(Object obj) {
		// If this and obj are the same object, they must be equal
		if (this == obj)
			return true;
		// If obj is null ("this" cannot be null), then they are not equal
		if (obj == null)
			return false;
		// If the two objects are not the same type, they are not equal
		if (getClass() != obj.getClass())
			return false;
		//
		// If we get here, we have two objects of the same type.
		// Calling your helper method to determine the arrays' equality.
		Matrix other = (Matrix) obj;
		return arraysAreEqual(this.values, other.values);
	}
	
	public Matrix plus(Matrix other) {
		int row = this.getNumRows();
		int column = this.getNumCols();
		int otherRow = other.getNumRows();
		int otherColumn = other.getNumCols();
		if (row == otherRow && column == otherColumn) {
			double[][] newMatrix = new double[row][column];
			for (int i=0; i<row; i++) {
				for (int j=0; j<column; j++) {
					newMatrix[i][j] = this.getValue(i, j) + other.getValue(i, j);
				}
			}
			return new Matrix(newMatrix);
		}
		throw new IllegalArgumentException("The number of columns and rows have to be consistent");
		 // FIXME
	}
	
	/**
	 * Returns a **new Matrix** that is the product of this and the other one.
	 * Does not change this Matrix at all.
	 * @param other
	 * @return
	 */
	public Matrix times(Matrix other) {
		if (this.getNumCols() != other.getNumRows()) {
			throw new IllegalArgumentException("The number of columns of the first matrix has to be equal to the number of rows of the second matrix");
		}
		// FIXME
		double[][] newMatrix = new double[this.getNumRows()][other.getNumCols()];
		
		for (int i=0; i<this.getNumRows(); i++) {
			for (int j=0; j<other.getNumCols(); j++) {
				double temp = 0;
				for (int m=0; m<other.getNumRows(); m++) {
					 temp += this.values[i][m] * other.getValue(m, j);
				}
				newMatrix[i][j] = temp;
			}
		}
		return new Matrix(newMatrix);
	}
	
	/**
	 * Returns a **new Matrix** that is the transpose of this one.
	 * Does not change this Matrix at all.
	 * @return
	 */
	public Matrix transpose() {
		double[][] newMatrix = new double[this.getNumCols()][this.getNumRows()];
		for (int i=0; i<this.getNumRows(); i++) {
			for (int j=0; j<this.getNumCols(); j++) {
				newMatrix[j][i] = this.values[i][j];
			}
		}
		return new Matrix(newMatrix);
	}

	/**
	 * Modifies this Matrix by scaling row i by the supplied factor.
	 * @param i the row to scale, where 0 is the top row
	 * @param factor the amount by which to scale each element of row i
	 */
	public void scaleRow(int i, double factor) {
		// FIXME
		if (i >= this.getNumRows()) {
			throw new IllegalArgumentException("row number cannot be greater or equal to the number of rows");
		}
		for (int j=0; j<this.getNumCols(); j++) {
			this.values[i][j] = factor * this.values[i][j];
		}
	}

	/**
	 * Modifies this matrix by adding row i to row j.  Row 0 is the top row.
	 * @param i
	 * @param j
	 */
	public void addRows(int i, int j) {
		// FIXME
		for (int m=0; m<this.getNumCols(); m++) {
			this.values[j][m] += this.values[i][m];
		}
	}
	
	/**
	 * Modifies the Matrix by exchanging row i with row j
	 * @param i
	 * @param j
	 */
	public void exchangeRows(int i, int j){
		for (int m=0; m<this.getNumCols(); m++) {
			double temp = this.values[i][m];
			this.values[i][m] = this.values[j][m];
			this.values[j][m] = temp;
		}
	}

	/**
	 * My gift to you.  This returns a String representation of
	 * the Matrix.  The contents of each row is separated by a tab (\t)
	 * so that columns (kind of) line up.  Each row is separated by a
	 * newline (\n) so that the output looks like a matrix.  The output
	 * of this method should <i>not</i> be used to compare matrices for
	 * equality:  use the .equals(Object) method instead!
	 */
	public String toString() {
		String ans = "";
		for (int i=0; i < values.length; ++i) {
			ans = ans + "\n";
			// Loop below assumes all rows have the same number of columns
			for (int j=0; j < values[0].length; ++j) {
				ans = ans + values[i][j] + "\t";
			}
		}
		return ans;
	}

}
