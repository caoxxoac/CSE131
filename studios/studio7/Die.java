package studio7;

public class Die {
	private int numSide;
	
	private Die(int numSide) {
		this.numSide = numSide;
	}
	
	public int getRandom() {
		return (int) (this.numSide * Math.random()) + 1;
	}
	
	public static void main(String[] args) {
		Die die = new Die(6);
		for (int i=0; i<100; i++) {
			System.out.println(die.getRandom());
		}
	}
}
