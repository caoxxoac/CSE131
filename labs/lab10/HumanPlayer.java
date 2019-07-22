package lab10;

import java.util.Set;

import cse131.ArgsProcessor;

public class HumanPlayer {
	private String name;
	private int height;
	private int width;
	private double[][] board;
	private Ship[] ships;
	
	public HumanPlayer(String name, int height, int width, ArgsProcessor ap) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.board = new double[height][width];
		this.ships = new Ship[] {};
	}
	
	public String getName() {
		return this.name;
	}
	
	public int numShipsStillAfloat() {
		int count = 0;
		for (int i=0; i<this.ships.length; i++) {
			Ship current = this.ships[i];
			if (!current.isSunk()) {
				count ++;
			}
		}
		return count;
	}
	
	public boolean isValidShipToAdd(Ship s) {
		boolean overlap = false;
		for (int i=0; i<s.ship.length; i++) {
			if (this.board[s.ship[i][1]][s.ship[i][0]] != 0) {
				overlap = true;
			}
		}
		return overlap;
	}
	
	public boolean addShip(Ship s) {
		if (isValidShipToAdd(s)) {
			for (int i=0; i<s.ship.length; i++) {
				this.board[s.ship[i][1]][s.ship[i][0]] = 1;
			}
			Ship[] temp = new Ship[this.ships.length+1];
			for (int j=0; j<this.ships.length; j++) {
				temp[j] = this.ships[j];
			}
			temp[this.ships.length] = s;
			this.ships = temp;
			
			return true;
		}
		return false;
	}
}





