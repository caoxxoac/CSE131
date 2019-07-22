package lab8;

public class DensePolynomial implements Polynomial{
	private final double[] poly;

	public DensePolynomial() {
		this.poly = new double[1];
		this.poly[0] = 0.0;
	}
	
	private DensePolynomial(double[] newPoly) {
		this.poly = newPoly;
	}
	
	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		if (coefficient == 0.0) {
			return new DensePolynomial(this.poly);
		}
		else {
			double[] newPoly = CoefficientArrayUtils.createNextCoefficients(coefficient, degree, this.poly);
			return new DensePolynomial(newPoly);
		}
	}

	@Override
	public int degree() {
		if (this.poly.length == 1) {
			return 0;
		}
		return this.poly.length - 1;
	}

	@Override
	public double getCoefficientAtDegree(int degree) {
//		for (int i=0; i<this.poly.length; i++) {
//			double d = this.poly[i] - ((int)this.poly[i]);
//			String d1 = ""+d;
//			d1 = d1.substring(2);
//			String d2 = ""+degree;
//			if (d1 == d2) {
//				return this.poly[i];
//			}
//		}
//		return 0;
		if (degree < this.poly.length) {
			return this.poly[degree];
		}
		return 0;
	}

	@Override
	public double evaluate(double x) {
		int degree = this.degree();
		double sum = 0;
		for (int i=0; i<= degree; i++) {
			double coe = this.getCoefficientAtDegree(i);
			sum += coe*Math.pow(x, i);
		}
		return sum;
	}

	@Override
	public DensePolynomial derivative() {
		// since the derivative of a constant is 0
		if (this.poly.length == 1) {
			return new DensePolynomial(new double[] {0});
		}
		double[] newPoly = new double[this.poly.length-1];
		for (int i=1; i<this.poly.length; i++) {
			// degree * coefficient and then assign the result to previous term
			newPoly[i-1] = this.poly[i] * i;
		}
		return new DensePolynomial(newPoly);
	}

	@Override
	public Polynomial sum(Polynomial other) {
		int degree = this.degree();
		int otherDegree = other.degree();
		double[] newPoly;
		if (degree > other.degree()) {
			newPoly = new double[degree+1];
			for (int i=0; i<=degree; i++) {
				if (i > otherDegree) {
					newPoly[i] = this.poly[i];
				}
				else {
					newPoly[i] = this.poly[i] + other.getCoefficientAtDegree(i);
				}
			}
		}
		else {
			newPoly = new double[otherDegree+1];
			for (int i=0; i<=otherDegree; i++) {
				if (i > degree) {
					newPoly[i] = other.getCoefficientAtDegree(i);
				}
				else {
					newPoly[i] = this.poly[i] + other.getCoefficientAtDegree(i);
				}
			}
		}
		return new DensePolynomial(newPoly);
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i=0; i<this.poly.length; i++) {
			if (i != this.poly.length-1) {
				s += this.poly[i] + "*x^" + i + "+";
			}
			else {
				s += this.poly[i] + "*x^" + i;
			}
		}
		return s;
	}

}
