package finalproject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import cse131.ArgsProcessor;
import cse131.NotYetImplementedException;

public class HumanPlayer implements Player {

	private final ArgsProcessor ap; // Don't change this!
	private String name;
	private int height;
	private int width;
	private int[][] board;
	private Ship[] ships;

	/**
	 * Creates an instance of the HumanPlayer class
	 * Note that we already dealt with taking in an ArgsProcessor object
	 * 		We know you've never seen this before, which is why it's given to you
	 * 		You can treat this ArgsProcessor (ap) throughout the HumanPlayer class
	 * 			like any other ArgsProcessor you've used in 131
	 * We leave the rest of the constructor to you
	 * 
	 * @param name the name of the player
	 * @param height the height of the board
	 * @param width the width of the board
	 * @param ap the ArgsProcessor object
	 */
	public HumanPlayer(String name, int height, int width, ArgsProcessor ap) {
		this.ap = ap;
		this.name = name;
		this.height = height;
		this.width = width;
		this.board = new int[height][width];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				this.board[i][j] = 0;
			}
		}
		this.ships = new Ship[] {};
	}

	@Override
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

	@Override
	public int[] getTargetLocation() {
		int x = this.ap.nextInt("Enter the x coordinate");
		int y = this.ap.nextInt("Enter the y coordinate");
		while (x < 0 || y < 0 || x >= this.width || y >= this.height) {
			x = this.ap.nextInt("Enter the x coordinate");
			y = this.ap.nextInt("Enter the y coordinate");
		}
		return new int[] {x, y};
	}

	@Override
	public void recordHitOrMiss(int x, int y, boolean isHit) {
		if (isHit) {
			this.board[y][x] = -1;
		}
		else {
			this.board[y][x] = 2;
		}
	}

	@Override
	public Ship decideShipPlacement(int length) {
		int x = this.ap.nextInt("Enter the x coordinate");
		int y = this.ap.nextInt("Enter the y coordinate");
		boolean isHorizontal = this.ap.nextBoolean("Is Horizontal?");
		Ship newShip = new Ship(x, y, length, isHorizontal);
		while (!this.isValidShipToAdd(newShip)) {
			x = this.ap.nextInt("Enter the x coordinate");
			y = this.ap.nextInt("Enter the y coordinate");
			isHorizontal = this.ap.nextBoolean("Is Horizontal?");
			newShip = new Ship(x, y, length, isHorizontal);
		}
		return newShip;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean respondToFire(int x, int y) {
		for (int i=0; i<this.ships.length; i++) {
			if (this.ships[i].isHit(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
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

	@Override
	public boolean addRandomShip(int length) {
		int x = (int) (Math.random() * (this.width));
		int y = (int) (Math.random() * (this.height));
		boolean isHorizontal = (Math.random() < 0.5);
		Ship newShip = new Ship(x, y, length, isHorizontal);
		while (!this.isValidShipToAdd(newShip)) {
			x = (int) (Math.random() * (this.width));
			y = (int) (Math.random() * (this.height));
			isHorizontal = (Math.random() < 0.5);
			newShip = new Ship(x, y, length, isHorizontal);
		}
		this.addShip(newShip);
		return true;
	}

	@Override
	public boolean isValidShipToAdd(Ship s) {
		boolean overlap = false;
		for (int i=0; i<s.ship.length; i++) {
			if (s.ship[i][1] >= this.height || s.ship[i][1] < 0 || s.ship[i][0] >= this.width || s.ship[i][0] < 0) {
				return false;
			}
			if (this.board[s.ship[i][1]][s.ship[i][0]] == 1) {
				overlap = true;
			}
			
		}
		return !overlap;
	}

	@Override
	public void printRadar() {
		for (int i=0; i<this.height; i++) {
			for (int j=0; j<this.width; j++) {
				if (this.board[i][j] == 0 || this.board[i][j] == 1) {
					System.out.print(".");
				}
				else if (this.board[i][j] == -1) {
					System.out.print("x");
				}
				else {
					System.out.print("o");
				}
			}
			System.out.println();
		}
	}


}
