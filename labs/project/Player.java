package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Player implements Moveable {
	
	private String name;
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private final double width = 0.1;
	private final double height = 0.1;
	private Color color;
	private int lives;
	private double speed;
	private final Color [] colors0 = {StdDraw.BOOK_LIGHT_BLUE, StdDraw.BOOK_BLUE, StdDraw.BLUE};
	private final Color [] colors1 = {StdDraw.PINK, StdDraw.BOOK_RED, StdDraw.RED};
	
	/**
	 * Creates a Player object to be implemented in the game
	 * @param name- name of the player (First Player or Second Player)
	 * @param x- x-coordinate of player (center)
	 * @param y- y-coordinate of player (center)
	 * @param speed- speed at which the player moves 
	 * @param lives- number of lives the player starts with
	 * startPosX is the starting x-position of the player
	 * startPosY is the starting y-position of the player
	 * colors0 is the array of colors for Player 0 to change the color
	 * 		when player 0 collides with an alien
	 * colors1 is the array of colors for Player 1 to change the color
	 * 		when player 0 collides with an alien
	 */
	public Player(String name, double x, double y, double speed, int lives) {
		this.name = name;
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
		this.speed = speed;
		this.lives = lives;
		if(this.name == "First Player") {
			this.color = colors0[(this.lives-1) % 3];
		}
		if(this.name == "Second Player") {
			this.color = colors1[(this.lives-1) % 3];
		}
	}
		
	/**
	 * Draws the player at the position(posX, posY) with height height
	 * and width width
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
		StdDraw.filledRectangle(this.posX, (this.posY + this.height/1.5), this.width/6, this.height/2);
	}
	
	/**
	 * Moves the specified player if specified keys are pressed
	 * Player 0 moves with A and D
	 * Player 1 moves using LEFT and RIGHT KEY
	 */
	public void move() {
		
		//If movements are possible:
		if(this.name == "First Player") {
			if ((ArcadeKeys.isKeyPressed(0, 1)) && (this.posX - this.speed > -1)) {
				this.posX -= this.speed;
			}
			else if ((ArcadeKeys.isKeyPressed(0, 3)) && (this.posX + this.speed < 1)) {
				this.posX += this.speed;
			}
		}
		
		else if(this.name == "Second Player") {
			if ((ArcadeKeys.isKeyPressed(1, 1)) && (this.posX - this.speed > -1)) {
				this.posX -= this.speed;
			}
			else if ((ArcadeKeys.isKeyPressed(1, 3)) && (this.posX + this.speed < 1)) {
				this.posX += this.speed;
			}
		}
	}
	
	/**
	 * Returns name of the player
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns x-coordinate value of the player
	 * @return x-coordinate value of the player
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * Returns y-coordinate value of the player
	 * @return y-coordinate value of the player
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * See how many lives are left
	 * @return number of lives remaining
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * Checks if specified fire keys are pressed
	 * @return true if fire key is pressed
	 * 			false if fire key is not pressed
	 */
	public boolean fire() {
		if(this.name == "First Player") {
			return (ArcadeKeys.isKeyPressed(0, 0)); //key w pushed
		}
		if(this.name == "Second Player") {
			return (ArcadeKeys.isKeyPressed(1, 0)); //key UP pushed
		}
		return false;
	}
	
	/**
	 * Kills player by reducing life and changing colors
	 * Player 0 colors change from Cyan to Orange to 
	 * Player 1 colors change from Pink to Orange to 
	 */
	public void die() {
		this.lives--;
		if (this.lives != 0) {
			if(this.name == "First Player") {
				this.color = colors0[this.lives - 1];
			}
			else if(this.name == "Second Player") {
				this.color = colors1[this.lives - 1];
			}
		}
		this.posX = this.startPosX;
		this.posY = this.startPosY; //doesn't do anything but good form
	}
	
	/**
	 * Checks if player has lost all the lives
	 * @return true if player has lost all the lives
	 * 			false if player has at least one life remaining
	 */
	public boolean isPlayerGameOver() {
		if(this.getLives() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determine if the player and alien collide based on comparing upper left and bottom right coordinates of each
	 * @param a- alien that player potentially collided with
	 * @return true if collision occurred
	 */
	public boolean collide(Alien a) {	
		double myTopLeftX = this.posX - this.width/2;
		double myTopLeftY = this.posY + this.height/2;
		double myBottomRightX = this.posX + this.width/2;
		double myBottomRightY = this.posY - this.height/2;
		
		double otherTopLeftX = a.getPosX() - a.getWidth()/2;
		double otherTopLeftY = a.getPosY() + a.getHeight()/2;
		double otherBottomRightX = a.getPosX() + a.getWidth()/2;
		double otherBottomRightY = a.getPosY() - a.getHeight()/2;
		
		return (myTopLeftY >= otherBottomRightY && 
				myBottomRightY <= otherTopLeftY && 
				myBottomRightX >= otherTopLeftX && 
				myTopLeftX <= otherBottomRightX);
	}

}
