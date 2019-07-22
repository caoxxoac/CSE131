package lab10;

public class Ship {
	public int[][] ship;
	public Ship(int topLeftX, int topLeftY, int length, boolean isHorizontal) {
		this.ship = new int[length][3];
		
		int tempX = topLeftX;
		int tempY = topLeftY;
		for (int i=0; i<length; i++) {
			this.ship[i][0] = tempX;
			this.ship[i][1] = tempY;
			this.ship[i][2] = 1;
			if (isHorizontal) {
				tempX ++;
			}
			else {
				tempY ++;
			}
		}
	}
	
	public boolean isHit(int x, int y) {
		for (int i=0; i<this.ship.length; i++) {
			if (this.ship[i][0] == x && this.ship[i][1] == y && this.ship[i][2] == 0) {				
				return true;
			}
		}
		return false;
	}
	
	public boolean isSunk() {
		for (int i=0; i<this.ship.length; i++) {
			if (this.ship[i][2] == 1) {
				return false;
			}
		}
		return true;
	}
}
