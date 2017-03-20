package project;

import sedgewick.StdDraw;

public class Alien implements Moveable {
	
	private double posX;
	private double posY;
	private final double startX;
	private final double startY;
	private final double width = 0.15;
	private final double height = 0.15;
	private double speed;	
	private boolean upDown;
	private boolean isAlive = true;
	
	/**
	 * Creates an Alien object to be implemented in the game
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param speed- speed at which the alien moves 
	 * @param upDown- true if alien moves up/down pattern; false if alien moves side-to-side pattern
	 */
	public Alien(double x, double y, double speed, boolean upDown) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.speed = -speed;
		this.upDown = upDown;
	}
	
	/**
	 * Returns current value of x-coordinate of the Alien
	 * @return x-coordinate's value of Alien
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * Returns current value of y-coordinate of the Alien
	 * @return y-coordinate's value of Alien
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * Returns width of the Alien
	 * @return width of the Alien
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * Returns height of the Alien
	 * @return height of the Alien
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * This method draws the Alien it is called upon
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
	}
	
	/**
	 * This method changes the position and speed of the Alien to move it
	 */
	public void move() {
		if (isOffScreen()) {
			speed *= -1;
		}
		if (upDown) {
			this.posY += speed;
		} else {
			this.posX += speed;
		}

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
		return (this.posX > 1 || this.posX < -1 || this.posY > 1 || this.posY < -1);
	}
		
	/**
	 * Resets the Alien to its initial position 
	 */
	public void moveToStart() {
		this.posX = startX;
		this.posY = startY;
	}
	
	/**
	 * Tells if the Alien is alive or not
	 * @return true if the Alien is alive, i.e. has not been hit by a bullet
	 * 			false if Alien is dead, has been hit by a Bullet
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * Makes the Alien dead by setting the isAlive value of the Alien
	 * 			 to false
	 */
	public void die() {
		this.isAlive = false;
	}

}
