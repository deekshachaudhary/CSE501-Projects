package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Player implements Movables{

	private String name;
	private double xValue;
	private double yValue;
	private int livesRemaining;
	private int score;

	//	
	//	get name
	//	set and get livesRemaining
	//	Methods:
	//		move
	//	

	/**
	 * 
	 * @param name name of player
	 */
	public Player(double xValue, double yValue, String name){
		this.name = name;
		this.xValue = xValue;
		this.yValue = yValue;
		this.livesRemaining = 3;
		this.score = 0;
	}

	/**
	 * 
	 * @return name of player
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return lives left
	 */
	public int getLivesRemaining() {
		return livesRemaining;
	}
	
	/**
	 * 
	 * @param livesRemaining lives left
	 */
	public void setLivesRemaining(int livesRemaining) {
		this.livesRemaining = livesRemaining;
	}

	/**
	 * 
	 * @param xValue x position
	 */
	public void setxValue(double xValue) {
		this.xValue = xValue;
	}

	/**
	 * 
	 * @return x position
	 */
	public double getxValue() {
		return xValue;
	}

	/**
	 * 
	 * @return y position
	 */
	public double getyValue() {
		return yValue;
	}

	/**
	 * 
	 * @param yValue y position
	 */
	public void setyValue(double yValue) {
		this.yValue = yValue;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * draw player
	 */
	@Override
	public void draw() {
		StdDraw.setPenColor(Color.red);
		StdDraw.picture(this.xValue, this.yValue, "images/SpaceShip.png");
	}
	
	public void displayScore() {
		StdDraw.setPenColor(Color.PINK);
		StdDraw.setPenRadius(0.05);
		StdDraw.text(-0.9, 0.95, "SCORE "+this.score);
	}
	
	public void displayLives() {
		StdDraw.setPenColor(Color.cyan);
		StdDraw.setPenRadius(0.05);
		StdDraw.text(0.9, 0.95, "LIVES "+this.livesRemaining);
	}
	
	/**
	 * move player
	 */
	@Override
	public void move() {
		if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)) {
			this.xValue = this.xValue - 0.01;
			if(this.xValue <= -1 || this.xValue >= 1) {
				this.xValue = -1;
			}
		}

		else if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)) {
			this.xValue = this.xValue + 0.01;
			if(this.xValue <= -1 || this.xValue >= 1) {
				this.xValue = 1;
			}
		}
		
		else if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN)) {
			this.yValue = this.yValue - 0.01;
			if(this.yValue <= -1 || this.yValue >= 1) {
				this.yValue = -1;
			}
		}
		
		else if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
			this.yValue = this.yValue + 0.01;
			if(this.yValue <= -1 || this.yValue >= 1) {
				this.yValue = 1;
			}
		}
	}
}
