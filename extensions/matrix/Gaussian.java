package matrix;

public class Gaussian {
	
	Matrix coeff;
	Matrix constants;
	
	public Gaussian(Matrix matCoeff, Matrix matConst){
		this.coeff = matCoeff;
		this.constants = matConst;
	}
	
	
	/**
	 * The hard part!
	 * @return
	 */
	public Matrix getSolution(){
		// FIXME
		double[][] newM = new double[this.coeff.getNumRows()][this.coeff.getNumCols()+1];
		for (int i=0; i<this.coeff.getNumRows(); i++) {
			for (int j=0; j<this.coeff.getNumCols()+1; j++) {
				if (j == this.coeff.getNumCols()) {
					newM[i][j] = this.constants.getValue(i, 0);
				}
				else {
					newM[i][j] = this.coeff.getValue(i, j);
				}
			}
		}
		double first = newM[0][0];
		for (int i=0; i<newM[0].length; i++) {
			newM[0][i] /= first;
		}
		
		for (int i=1; i<newM.length; i++) {
			double firstNum = newM[i][0];
			for (int j=0; j<newM[i].length; j++) {		
				newM[i][j] -= firstNum * newM[0][j];
			}
		}
		
		double secondNum = newM[2][1] / newM[1][1];
		for (int i=0; i<newM[2].length; i++) {
			newM[2][i] -= newM[1][i] * secondNum;
		}
		
		
		double thirdNum = newM[1][2] / newM[2][2];
		for (int i=0; i<newM[2].length; i++) {
			newM[1][i] -= newM[2][i] * thirdNum;
		}
		
		thirdNum = newM[2][2] / newM[0][2];
		for (int i=0; i<newM[2].length; i++) {
			newM[0][i] -= newM[2][i] * thirdNum;
		}
		
		secondNum = newM[0][1] / newM[1][1];
		for (int i=0; i<newM[0].length; i++) {
			newM[0][i] -= newM[1][i] * secondNum;
		}
		
		for (int i=0; i<newM.length; i++) {
			for (int j=0; j<newM[0].length; j++) {
				newM[i][j] /= newM[i][i];
			}
		}
		return new Matrix(newM);
		
	}
	
	public String toString(){
		String string ="";
		for(int i=0; i<this.coeff.getNumRows(); i++){
			string+="\n";
			for(int j=0; j<this.coeff.getNumCols()+1; j++){
				if(j==this.coeff.getNumCols()){
					string+= this.constants.getValue(i,0)+ "  ";
				}else{
					string+= this.coeff.getValue(i,j) + "  ";
				}
			}
		}
		System.out.println(string);

		return string;
	}

}
