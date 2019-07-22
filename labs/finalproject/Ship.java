package finalproject;

import java.util.Arrays;

import cse131.NotYetImplementedException;

/**
 * @author Mariah Yelenick and Adam Kern
 * @version 11/18/18
 */
public class Ship {
	public int[][] ship;
	public int length;

	/**
	 * Create an instance of the ship class, recording all necessary information into
	 * any instance variables you choose to create
	 * 
	 * @param topLeftX the x coordinate of the ship's uppermost, leftmost space
	 * @param topLeftY the y coordinate of the ship's uppermost, leftmost space
	 * @param length the number of spaces the ship occupies
	 * @param isHorizontal if true, the ship is placed horizontally, else the ship is placed vertically
	 */
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
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + Arrays.deepHashCode(ship);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (length != other.length)
			return false;
		if (!Arrays.deepEquals(ship, other.ship))
			return false;
		return true;
	}

	/**
	 * Check if the ship has been sunk
	 * This should only be true if the ship was hit in all the spaces it occupies
	 * 
	 * @return true if the ship has been sunk
	 */
	public boolean isSunk() {
		for (int i=0; i<this.ship.length; i++) {
			if (this.ship[i][2] == 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if the ship occupies a space at (x, y)
	 * Note: Be sure to update the hits array so that you can check if the ship is sunk!
	 * 
	 * @param x the x coordinate to shoot at
	 * @param y the y coordinate to shoot at
	 * @return true if this ship occupies that spot (hit), false otherwise (miss)
	 */
	public boolean isHit(int x, int y) {
		for (int i=0; i<this.ship.length; i++) {
			if (this.ship[i][0] == x && this.ship[i][1] == y) {
				this.ship[i][2] = 0;
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Ship [ship=" + Arrays.toString(ship) + ", length=" + length + "]";
	}

}
