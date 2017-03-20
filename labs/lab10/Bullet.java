package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Bullet implements Movables {

//	
//	set and get x and y values
//	move
//	hit
//	

	double xValue;
	double yValue;
	double xVelocity;
	double yVelocity;
	boolean isThere;
	
	/**
	 * 
	 * @param p1 player
	 */
	public Bullet(Player p1) {
		this.xValue = p1.getxValue();
		this.yValue = p1.getyValue() + 0.1;
		this.xVelocity = 0;
		this.yVelocity = 0.015;
		this.isThere = true;
	}
	
	/**
	 * 
	 * @return x coordinate
	 */
	public double getxValue() {
		return xValue;
	}

	/**
	 * 
	 * @param xValue x coordinate
	 */
	public void setxValue(double xValue) {
		this.xValue = xValue;
	}

	/**
	 * 
	 * @return y coordinate
	 */
	public double getyValue() {
		return yValue;
	}

	/**
	 * 
	 * @param yValue y coordinate
	 */
	public void setyValue(double yValue) {
		this.yValue = yValue;
	}

	/**
	 * 
	 * @return x velocity
	 */
	public double getxVelocity() {
		return xVelocity;
	}

	/**
	 * 
	 * @param xVelocity x velocity
	 */
	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	/**
	 * 
	 * @return y velocity
	 */
	public double getyVelocity() {
		return yVelocity;
	}

	/**
	 * 
	 * @param yVelocity y velocity
	 */
	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	/**
	 * change position
	 */
	@Override
	public void move() {
		this.xValue = this.xValue + xVelocity;
		this.yValue = this.yValue + yVelocity;
	}
	
	/**
	 * draw bullets
	 */
	@Override
	public void draw() {
		StdDraw.setPenColor(Color.GRAY);
		StdDraw.setPenRadius(0.007);
		StdDraw.line(this.xValue, this.yValue, this.xValue,
				this.yValue + 0.01);
	}
	
	/**
	 * 
	 * @param a1 alien
	 * @param p1 player
	 * @return
	 */
	public boolean hit(Alien a1, Player p1) {
		double xportion = Math.pow(Math.abs(this.xValue-a1.getxValue()), 2);
		double yportion = Math.pow(Math.abs(this.yValue-a1.getyValue()), 2);
		double dist = Math.pow(xportion+yportion, .5); 
		if(dist <= 0.06) {
			if(a1.getType() == 0) {
				StdDraw.setPenColor(Color.yellow);
				StdDraw.setPenRadius(0.01);
				StdDraw.text(a1.getxValue(), a1.getyValue() + 0.1, "100");
			}
			
			else if(a1.getType() == 1) {
				StdDraw.setPenColor(Color.green);
				StdDraw.setPenRadius(0.01);
				StdDraw.text(a1.getxValue(), a1.getyValue() + 0.1, "200");
			}
			
			else if(a1.getType() == 2){
				StdDraw.setPenColor(Color.blue);
				StdDraw.setPenRadius(0.01);
				StdDraw.text(a1.getxValue(), a1.getyValue() + 0.1, "300");
			}
			
			else if(a1.getType() == 3){
				StdDraw.setPenColor(Color.orange);
				StdDraw.setPenRadius(0.01);
				StdDraw.text(a1.getxValue(), a1.getyValue() + 0.1, "200");
			}
			
			else {
				StdDraw.setPenColor(Color.magenta);
				StdDraw.setPenRadius(0.01);
				StdDraw.text(a1.getxValue(), a1.getyValue() + 0.1, "300");
			}
			p1.setScore(p1.getScore() + a1.getPoints());
			a1.setIsAlive(false);
			return true;
		}
		return false;
	}
}
