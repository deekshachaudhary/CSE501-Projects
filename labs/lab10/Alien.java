package lab10;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import imageprocessor.GUI;
import imageprocessor.MenuTransformable;
import sedgewick.Picture;
import sedgewick.StdDraw;

public class Alien implements Movables{

	double xValue;
	double yValue;
	double xVelocity;
	double yVelocity;
	boolean isAlive;
	int type; // horizontal yellow = 0, vertical green = 1, 
			  // diagonal blue = 2, orange vertical = 3, magenta diagonal = 4
	int points;

//	
//	Behaviors: 
//	set and get x,y,liveliness
//		setPosition
//		move
//		die
//		shoot
//	
	
	/**
	 * 
	 * @param xValue x position
	 * @param yValue y position
	 */
	public Alien(double xValue, double yValue, int type) {
		this.xValue = xValue;
		this.yValue = yValue;
		this.type = type;

		if(this.type == 0) {
			this.xVelocity = 0.015;
			this.yVelocity = 0;
			this.points = 100;
		}
		
		else if(this.type == 1 || this.type == 3) {
			this.xVelocity = 0;
			this.yVelocity = 0.015;
			this.points = 200;
		}
		
		else {
			this.xVelocity = 0.015;
			this.yVelocity = 0.015;
			this.points = 300;
		}
		
		this.isAlive = true;
	}

	/**
	 * 
	 * @return x position
	 */
	public double getxValue() {
		return this.xValue;
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
	 * @return y position
	 */
	public double getyValue() {
		return this.yValue;
	}

	/**
	 * 
	 * @param yValue y position
	 */
	public void setyValue(double yValue) {
		this.yValue = yValue;
	}

	/**
	 * 
	 * @return type of alien
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * 
	 * @return points of alien
	 */
	public int getPoints() {
		return this.points;
	}

	
	/**
	 * 
	 * @return true if the alien is alive
	 */
	public boolean getIsAlive() {
		return this.isAlive;
	}

	/**
	 * 
	 * @param isAlive set value of isAlive to parameter passed
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Alien isAlive=" + isAlive + ", type=" + type;
	}
	
	/**
	 * update positions of Aliens
	 */
	@Override
	public void move() {
		if(Math.abs(xValue + xVelocity) > 1.0 - 0.01) {
			xVelocity = -xVelocity;
		}
		if(Math.abs(yValue + yVelocity) > 1.0 - 0.01) {
			yVelocity = -yVelocity;
		}			
		xValue = xValue + xVelocity;
		yValue = yValue + yVelocity;
	}
	
	/**
	 * draw Aliens
	 */
	@Override
	public void draw() {
		if(type == 0) {
			StdDraw.picture(this.xValue, this.yValue, "images/Alien2.png");
		}

		else if(type == 1) {
			StdDraw.picture(this.xValue, this.yValue, "images/Alien3.png");
		}
		
		else if(type == 2){
			StdDraw.picture(this.xValue, this.yValue, "images/Alien4.png");
		}
		
		else if(type == 3) {
			StdDraw.picture(this.xValue, this.yValue, "images/Alien1.png");
		}
		
		else {
			StdDraw.picture(this.xValue, this.yValue, "images/Alien5.png");
		}
	}

	/**
	 * 
	 * @param p1 player to which collision with
	 */
	public void collision(Player p1) {
		double xportion = Math.pow(Math.abs(xValue-p1.getxValue()), 2);
		double yportion = Math.pow(Math.abs(yValue-p1.getyValue()), 2);
		double dist = Math.pow(xportion+yportion, .5); 
		if(dist <= 0.06) {
			p1.setxValue(0);
			p1.setyValue(-0.8);
			p1.setLivesRemaining(p1.getLivesRemaining() - 1);
		}
	}
}
