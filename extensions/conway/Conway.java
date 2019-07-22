package conway;

/**
 * 
 *
 */
public class Conway {
	private double[][] cells;
	private int rows;
	private int cols;

	public Conway(int rows, int cols){
		this.cells = new double[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}


	public int getRows(){
		return this.rows;             // FIXME
	}

	public int getColumns(){
		return this.cols;
	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * @param b if true, the cell is alive; if false, the cell is dead 
	 * @param row
	 * @param col
	 */
	public void setLiveness(boolean b, int row, int col){
		if (b) {
			this.cells[row][col] = 1;
		}
		else {
			this.cells[row][col] = 0;
		}
	}


	/**
	 *  
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive. 
	 *    If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col){
		if (col >= getColumns() || row >= getRows() || row < 0 || col < 0) {
			return false;
		}
		if (this.cells[row][col] > 0) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Make every cell not alive
	 */
	public void clear(){
		for (int i=0; i<getRows(); i++) {
			for (int j=0; j<getColumns(); j++) {
				this.cells[i][j] = 0;
			}
		}
	}


	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 *   n  n  n
	 *   n  c  n
	 *   n  n  n
	 *   
	 *  Above, if c represents the cell at (row, col), each n is
	 *  a neighbor of c, according to the above definition.
	 *  The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col){
		int aliveNum = 0;
		if (row > 0 && row < getRows()) {
			for (int i=row-1; i<row+2; i++) {
				if (col > 0 && col < getColumns()) {
					for (int j=col-1; j<col+2; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else if (col == 0){
					for (int j=col; j<col+2; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else if (col+1 == getColumns()) {
					for (int j=col; j<col+1; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else {
					return 0;
				}
			}
		}
		else if (row == 0) {
			for (int i=row; i<row+2; i++) {
				if (col > 0 && col < getColumns()) {
					for (int j=col-1; j<col+2; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else if (col == 0){
					for (int j=col; j<col+2; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else if (col+1 == getColumns()) {
					for (int j=col; j<col+1; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else {
					return 0;
				}
			}
		}
		else if (row+1 == getRows()) {
			for (int i=row; i<row+1; i++) {
				if (col > 0 && col < getColumns()) {
					for (int j=col-1; j<col+2; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else if (col == 0){
					for (int j=col; j<col+2; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else if (col+1 == getColumns()) {
					for (int j=col; j<col+1; j++) {
						if ((i != row || j != col) && isAlive(i, j)) {
							aliveNum ++;
						}
					}
				}
				else {
					return 0;
				}
			}
		}
		else {
			return 0;
		}
		return aliveNum;
	}

	/**
	 * Executes a generation of life.  Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	public void step(){
		// FIXME
		boolean allAlive = false;
		while (!allAlive) {
			int count = 0;
			for (int i=0; i<getRows(); i++) {
				for (int j=0; j<getColumns(); j++) {
					if (countLivingNeighbors(i, j) != 2 && countLivingNeighbors(i, j) != 3 && isAlive(i, j)) {
						this.cells[i][j] = 0;
						count ++;
					}
					else if (!isAlive(i, j) && countLivingNeighbors(i, j) == 3) {
						this.cells[i][j] = 1;
					}
				}
			}
			if (count == 0) {
				allAlive = true;
			}
		}
	}

	/**
	 * creates a blinker
	 */
	public void blinker() {

		if (this.getRows() < 3 || this.getColumns() < 3) {
			System.out.println("Grid is too small for premade pattern Blinker. " +
					"Conway must be at least 3x3");
		}
		else {
			this.setLiveness(true, 1, 0);
			this.setLiveness(true, 1, 1);
			this.setLiveness(true, 1, 2);
		}
	}

	public void fourBlinkers() {
		clear();
		if (this.getRows() < 9 || this.getColumns() < 9) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 9x9");
		}
		else {
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					this.setLiveness(true, i, j);
				}
			}
		}
	}


	public void gosperGliderGun() {
		clear();
		if (this.getRows() < 50 || this.getColumns() < 50) {
			System.out.println("Grid is too small for premade pattern Gosper Glider Gun. " +
					"Conway must be at least 50x50");
		}
		else {
			this.setLiveness(true,0,27);
			this.setLiveness(true,1,25);
			this.setLiveness(true,1,27);
			this.setLiveness(true,2,15);
			this.setLiveness(true,2,16);
			this.setLiveness(true,2,23);
			this.setLiveness(true,2,24);
			this.setLiveness(true,2,37);
			this.setLiveness(true,2,38);
			this.setLiveness(true,3,14);
			this.setLiveness(true,3,18);
			this.setLiveness(true,3,23);
			this.setLiveness(true,3,24);
			this.setLiveness(true,3,37);
			this.setLiveness(true,3,38);
			this.setLiveness(true,4,3);
			this.setLiveness(true,4,4);
			this.setLiveness(true,4,13);
			this.setLiveness(true,4,19);
			this.setLiveness(true,4,23);
			this.setLiveness(true,4,24);
			this.setLiveness(true,5,3);
			this.setLiveness(true,5,4);
			this.setLiveness(true,5,13);
			this.setLiveness(true,5,17);
			this.setLiveness(true,5,19);
			this.setLiveness(true,5,20);
			this.setLiveness(true,5,25);
			this.setLiveness(true,5,27);
			this.setLiveness(true,6,13);
			this.setLiveness(true,6,19);
			this.setLiveness(true,6,27);
			this.setLiveness(true,7,14);
			this.setLiveness(true,7,18);
			this.setLiveness(true,8,15);
			this.setLiveness(true,8,16);


		}
	}

	public void glider() {
		clear();
		if (this.getRows() < 10 || this.getColumns() < 10) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 10x10");
		}
		else {

			this.setLiveness(true,1,1);
			this.setLiveness(true,1,3);
			this.setLiveness(true,2,2);
			this.setLiveness(true,2,3);
			this.setLiveness(true,3,2);

		}
	}

	public void yourDesignOne() {

	}

	public void yourDesignTwo() {

	}


	public void logAndCapture() {

	}

}