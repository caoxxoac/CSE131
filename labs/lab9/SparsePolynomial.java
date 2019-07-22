package lab9;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lab8.Polynomial;

public class SparsePolynomial implements lab8.Polynomial{
	private final Map<Integer, Double> poly;
	
	public SparsePolynomial() {
		this.poly = new HashMap<Integer, Double>();
	}

	private SparsePolynomial(Map<Integer, Double> newPoly) {
		this.poly = newPoly;
	}
	
	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		if (coefficient == 0) {
			return new SparsePolynomial(this.poly);
		}
		Map<Integer, Double> newPoly = MapDegreeToCoefficientUtils.createNextMap(coefficient, degree, this.poly);
		return new SparsePolynomial(newPoly);
	}

	@Override
	public int degree() {
		int max = 0;
		Set<Integer> keys = this.poly.keySet();
		for (int i:keys) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	@Override
	public double getCoefficientAtDegree(int degree) {
		if (this.poly.size() == 0) {
			return 0;
		}
		if (this.poly.containsKey(degree)) {
			return this.poly.get(degree);
		}
		else {
			return 0;
		}
	}

	@Override
	public double evaluate(double x) {
		double sum = 0;
		for (int i : this.poly.keySet()) {
			double coe = this.getCoefficientAtDegree(i);
			sum += coe*Math.pow(x, i);
		}
		return sum;
	}

	@Override
	public Polynomial derivative() {
		Map<Integer, Double> newMap = new HashMap<Integer, Double>();
		Set<Integer> keys = this.poly.keySet();
		for (int i:keys) {
			if (i != 0) {
				newMap.put(i-1, this.poly.get(i)*i);
			}
		}
		return new SparsePolynomial(newMap);
	}

	@Override
	public Polynomial sum(Polynomial other) {
		Map<Integer, Double> newPoly = MapDegreeToCoefficientUtils.copyMap(this.poly);
		int degree = this.degree();
		int otherDegree = other.degree();
		if (degree > otherDegree) {
			for (int i=0; i<=degree; i++) {
				double otherCOE = other.getCoefficientAtDegree(i);
				if (otherCOE != 0) {
					if (!this.poly.containsKey(i)) {
						newPoly.put(i, otherCOE);
					}
					else {
						newPoly.put(i, otherCOE+this.poly.get(i));
					}
				}
			}
		}
		else {
			for (int i=0; i<=otherDegree; i++) {
				double otherCOE = other.getCoefficientAtDegree(i);
				if (otherCOE != 0) {
					if (!this.poly.containsKey(i)) {
						newPoly.put(i, otherCOE);
					}
					else {
						newPoly.put(i, otherCOE+this.poly.get(i));
					}
				}
			}
		}
		return new SparsePolynomial(newPoly);
	}
	
	@Override
	public String toString() {
		String s = "";
		Set<Integer> keys = this.poly.keySet();
		for (int k:keys) {
			s += this.poly.get(k) + "*x^" + k + "+";
		}
		return s;
	}
}
