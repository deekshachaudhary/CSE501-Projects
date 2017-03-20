package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class MotherShip implements Moveable {

	private double posX;
	private double posY;
	private final double startX;
	private final double startY;
	private double speed = 0.03;
	private final double width = 0.20;
	private final double height = 0.15;
	private boolean isAlive = true;
	
	/**
	 * Constructor that assigns posX and posY values to the MotherShip
	 * object when it is created.
	 */
	public MotherShip() {
		this.posX = -.9;
		this.posY = 0.75;
		this.startX = posX;
		this.startY = posY;
	}
	
	/**
	 * Tells the current x-coordinate value of the motherShip
	 * @return the current x-coordinate value of the motherShip
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * Sets the x-coordinate value of the motherShip equal to the parameter
	 * @param posX value to which the x-coordinate value is to be updated
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}

	/**
	 * Tells the current y-coordinate value of the motherShip
	 * @return the current y-coordinate value of the motherShip
	 */
	public double getPosY() {
		return posY;
	}

	/**
	 * Sets the y-coordinate value of the motherShip equal to the parameter
	 * @param posY value to which the y-coordinate value is to be updated
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	/**
	 * Returns the width of the motherShip
	 * @return width of the motherShip
	 */
	public double getWidth() {
		return this.width;
	}

	/**
	 * Returns the height of the motherShip
	 * @return height of the motherShip
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * Checks if the motherShip is alive
	 * @return true if motherShip is alive
	 * 		   false if motherShip is not alive
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * Sets the value of isAlive to the parameter passed
	 * @param isAlive value to which the isAlive value is to be set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * Tells if the Alien is out of the screen or not
	 * @return true is the Alien gets out of the screen i.e. when its
	 * 			x-coordinate or y-coordinate value is less than -1 or
	 * 			more than +1
	 * 			false if the Alien is inside the screen i.e. x and y
	 * 			values between -1 and +1
	 */
	public boolean isOffScreen() {
		return (this.posX > 1 || this.posX < -1);
	}
	
	/**
	 * Updates the x-coordinate value of the motherShip.
	 * The if statement sets the isAlive value of the motherShip to
	 * false if it goes off the screen
	 */
	public void move() {
		if(isOffScreen()) {
			this.setAlive(false);
		}
		this.posX += speed;
	}

	/**
	 * Draws the motherShip at the specific position (posX, posY)
	 */
	public void draw() {
		StdDraw.picture(posX, posY, "images/SpaceShip.png", width, height);
	}
	
	/**
	 * Reset the x and y-coordinate value of motherShip to the initial
	 * positions startX and startY
	 */
	public void reset() {
		this.posX = this.startX;
		this.posY = this.startY;
	}
	
	/**
	 * Stop displaying the motherShip by setting its isAlive value to false
	 */
	public void die() {
		this.isAlive = false;
	}

}
