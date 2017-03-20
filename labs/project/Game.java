package project;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;

import sedgewick.StdDraw;

/**
 * Plays game by using all created objects and Moveable interface
 * @author Zachary Polsky
 *
 */

public class Game {
	
	private LinkedList<Alien> aliens;
	private LinkedList<Moveable> move;
	private MotherShip motherShip;
	private int motherShipTimer;
	private LinkedList<Bullet> player0Bullets;
	private LinkedList<Bullet> player1Bullets;
	private Player[] players = new Player[2];
	private double alienSpeed;
	private int[] scores = new int[2];
	
	/**
	 * Game() is the constructor to instantiate objects for the game
	 * aliens is a LinkedList of Alien objects
	 * move is a LinkedList of Moveable objects which comprise of objects of
	 * 		classes Player, Alien, Bullet and MotherShip
	 * player0Bullets is a LinkedList of bullets belonging to player 0
 	 * player1Bullets is a LinkedList of bullets belonging to player 1
 	 * players[0] is Player object corresponding to player 0
 	 * players[1] is Player object corresponding to player 1
 	 * alienSpeed is the speed of the alien
 	 * scores[0] is the score of player 0
 	 * scores[1] is the score of player 1
 	 * motherShip is an object of MotherShip class
 	 * motherShipTimer is a variable which keeps track of when to display
 	 * 		the motherShip. It increments by 1 in each iteration.
	 */
	public Game() {
		aliens = new LinkedList<Alien>();
		move = new LinkedList<Moveable>();
		player0Bullets = new LinkedList<Bullet>();
		player1Bullets = new LinkedList<Bullet>();
		StdDraw.setScale(-1, 1);
		players[0] = new Player("First Player", -.3, -.9, .04, 3);
		players[1] = new Player("Second Player" ,.3, -.9, .04, 3);
		move.add(players[0]);
		move.add(players[1]);
		alienSpeed = 0.04;
		addAliens();
		scores[0] = 0;
		scores[1] = 0;
		motherShip = new MotherShip();
		motherShipTimer = 0;
	}
	
	/**
 	 * Draws the screen to place Aliens, player, and the bullets on
 	 * The first if statement displays the scores for player 0 on top
 	 * left corner if its game is not over yet.
 	 * The second if statement displays the scores for player 1 on top
 	 * right corner if its game is not over yet.
 	 * The third if statement displays Game Over in top left corner in
 	 * 		place of player 0 scores if player 0 has no lives remaining.
 	 * The fourth if statement displays Game Over in top right corner in
 	 * 		place of player 1 scores if player 1 has no lives remaining.
	 * @param score0 player 0 score
	 * @param score1 player 1 score
	 * @param isOver0 true if player 0 game is over, false otherwise
	 * @param isOver1 true if player 1 game is over, false otherwise
	 */
	public void drawBoard(int score0, int score1, boolean isOver0, boolean isOver1) {
		StdDraw.clear(StdDraw.BLACK);
		if(!isOver0) {
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(-.8, 1, "Player 0 Score: " + score0);
		}
		if(!isOver1) {
			StdDraw.setPenColor(Color.RED);
			StdDraw.text(0.8, 1, "Player 1 Score: " + score1);
		}
		if(isOver0) {
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(-0.75, 1, "Player 0 Game Over");
		}
		if(isOver1) {
			StdDraw.setPenColor(Color.RED);
			StdDraw.text(0.75, 1, "Player 1 Game Over");
		}

	}
		
	/**
	 * Checks if game is over, i.e. if both players have lost all 
	 * 	the lives
	 * @return true if both the players have lost all the lives
	 * 			false if at least 1 player has at least one life
	 * 			remaining
	 */
	public boolean isOver() {
		return (!(players[0].getLives() > 0 || players[1].getLives() > 0));
	}
	
	/**
	 * Stops drawing of player p if it is dead by removing it from
	 * 		the move LinkedList
	 */
	public void playerGameOver(Player p) {
		move.remove(p);
	}
	
	/**
	 * Draws more Aliens on the screen
	 */
	public void addAliens(){
		addAlien(0.5, 0.5, alienSpeed, true);
		addAlien(-0.5, 0.5, alienSpeed, true);
		addAlien(-0.9, 0.5, alienSpeed, false);
	}
	
	/**
	 * Draws more Aliens on the screen at a particular position
	 * @param x x-coordinate value where the Alien is to be drawn
	 * @param y y-coordinate value where the Alien is to be drawn
	 * @param speed speed of the Alien to be drawn
	 * @param upDown true if the Alien should move up and down
	 * 				false if the Alien would not move up and down
	 */
	private void addAlien(double x, double y, double speed, boolean upDown)
	{
		Alien a = new Alien(x, y, speed, upDown);
		aliens.add(a);
		move.add(a);
	}
	
	/**
	 * Draw the background, moves Aliens, player and bullets and lets the
	 * 		player shoot the Aliens.
	 */
	public void play(){
		// Draws the background along with the scores for both the players
		// scores[0] is the score of player 0 which are displayed on top
		// 		left corner of the screen.
		// scores[1] is the score of player 1 which are displayed on the
		// 		top right corner of the screen.
		// players[0].isPlayerGameOver() returns true if player 0 has lost
		// 		all its lives.
		// players[1].isPlayerGameOver() returns true if player 1 has lost
		// 		all its lives.
		// Then, loops through the LinkedList of Moveable objects resulting
		//		in calls to move() and draw() methods of every class that
		// 		implements the interface Movable, i.e. Alien, Player, Bullet
		//		and MotherShip.
		drawBoard(scores[0], scores[1], players[0].isPlayerGameOver(), players[1].isPlayerGameOver());
		for (Moveable m : move) {
			m.move();
			m.draw();
		}
		
		// When player fires, i.e. when the key in isKeyPressed is pressed,
		// and when size of bullets LinkedList is less than 3 (this prevents
		// player to have more than 3 bullets on the screen at a time),
		// a new bullet is created at the same x-coordinate as the center of
		// player but slightly more than player's y-coordinate because
		// the bullet should not fire from the center of the player but from
		// the upper most tip of the player. The bullet created is then added
		// to the LinkedList move and bullets
		// First if statement does the above for player 0.
		// Second if statement does this for player 1.
		if (players[0].fire() && player0Bullets.size() < 3) {
			Bullet b1 = new Bullet(players[0].getPosX(), players[0].getPosY() + .15, .05);
			move.add(b1);
			player0Bullets.add(b1);
		}

		if (players[1].fire() && player1Bullets.size() < 3) {
			Bullet b2 = new Bullet(players[1].getPosX(), players[1].getPosY() + .15, .05);
			move.add(b2);
			player1Bullets.add(b2);
		}
		
		// Displays the motherShip every 200 iterations
		// The motherShipTimer > 0 condition makes sure the motherShip is
		// not displayed in the first iteration when motherShipTimer is 0
		// reset() resets the position of the motherShip to the starting
		// position again. The third condition makes sure that we add the
		// motherShip to the LinkedList move only if it is not already
		// present.
		// If these conditions are met, isAlive value of motherShip is set
		// to be true and it is added to the move LinkedList so that it is
		// drawn in the coming iterations.
		if(motherShipTimer % 100 == 0 && motherShipTimer > 0 && !move.contains(motherShip)) {
			motherShip.reset();
			motherShip.setAlive(true);
			move.add(motherShip);
		}
		
		// For each Alien, this snippet checks for the collision with the
		// player or the bullet.
		// The first if statement checks if any of the Alien has collided 
		// with the player. If it has collided, the player dies and his
		// score is reduces by 10.
		// The nested for loop is checking if "ANY" Alien has collided with
		// "ANY" bullet. So, we check every bullet for one Alien and then
		// for the next until we check that for all the Aliens.
		// If any alien collides with any bullet, it dies; the bullet is
		// sent off the screen so that it disappears, and the score increases
		// by 50. If it does not collide, the bullet is simply made to 
		// disappear by setting it off screen.
		/*CODE A*/ // start
		for (Alien a : aliens) {
			if (players[0].collide(a)) {
				players[0].die();
				if(players[0].isPlayerGameOver()) {
					playerGameOver(players[0]);
				}
				scores[0] -= 10;
			}
			if (players[1].collide(a)) {
				players[1].die();
				if(players[1].isPlayerGameOver()) {
					playerGameOver(players[1]);
				}
				scores[1] -= 10;
			}
			
			for (Bullet b1 : player0Bullets) {
				if (b1.collide(a)) {
					a.die();
					b1.setOffScreen();
					scores[0] += 50;
				}
				else if (b1.getPosY() >= 1){
					b1.setOffScreen();
				}
			}
			for (Bullet b2 : player1Bullets) {
				if (b2.collide(a)) {
					a.die();
					b2.setOffScreen();
					scores[1] += 50;
				}
				else if (b2.getPosY() >= 1){
					b2.setOffScreen();
				}
			}
		}
		/*CODE A*/ //end
		
		
		// Checks if player 0's bullet has hit the motherShip
		// This for loop checks if player 0 has shot motherShip
		// If so, 200 points get added to player 0's score
		for (Bullet b1 : player0Bullets) {
			if (b1.collide(motherShip)) {
				motherShip.die();
				b1.setOffScreen();
				scores[0] += 200;
			}
			else if (b1.getPosY() >= 1){
				b1.setOffScreen();
			}
		}
		
		// Checks if player 1's bullet has hit the motherShip
		// This for loop checks if player 1 has shot the motherShip
		// If so, 200 points get added to player 1's score
		for (Bullet b2 : player1Bullets) {
			if (b2.collide(motherShip)) {
				motherShip.die();
				b2.setOffScreen();
				scores[1] += 200;
			}
			else if (b2.getPosY() >= 1){
				b2.setOffScreen();
			}
		}
		
		// Used to prevent concurrent modification errors
		Iterator<Alien> alienIter = aliens.iterator();
		while (alienIter.hasNext()) {
		    Alien a = alienIter.next();
		    if (!a.isAlive()) {
		    	alienIter.remove();
		    	move.remove(a);
		    }
		}
		
		// This snippet simply removes the bullet, that has gone out of
		// the screen i.e. x or y coordinate less than -1 or more than +1,
		// from player 0's bullets LinkedList so that it is not drawn in
		// the next iterations.
		Iterator<Bullet> player0BulletIter = player0Bullets.iterator();
		while (player0BulletIter.hasNext()) {
		    Bullet b = player0BulletIter.next();
		    if (b.getIsOffScreen()) {
		    	player0BulletIter.remove();
		    	move.remove(b);
		    }
		}
		
		// This snippet simply removes the bullet, that has gone out of
		// the screen i.e. x or y coordinate less than -1 or more than +1,
		// from player 1's bullets LinkedList so that it is not drawn in
		// the next iterations.
		Iterator<Bullet> player1BulletIter = player1Bullets.iterator();
		while (player1BulletIter.hasNext()) {
		    Bullet b = player1BulletIter.next();
		    if (b.getIsOffScreen()) {
		    	player1BulletIter.remove();
		    	move.remove(b);
		    }
		}
		
		// This snippet removes the motherShip from the move LinkedList
		// when its isAlive value is false.
		// This ensures the motherShip is not drawn on the screen until
		// the interval for it to be drawn arrives, i.e. until the timer
		// hits the 200 mark.
		if(!(motherShip.isAlive())) {
			move.remove(motherShip);
		}
		
		// This simply keeps on increasing motherShipTimer value in each
		// iteration so that it can be displayed in regular intervals.
		motherShipTimer++;
		
		// levelUp increases the speed of the new Aliens that get created
		// when the board is empty.
		levelUp();
		StdDraw.show(60);
		
		// Check if all the lives of both the players are 0
		// Calls drawGameEnd() if so, which draws GAME OVER
		if (isOver()){
			drawGameEnd();
		}
		
	}
	
	/**
	 * Increases the speed of the new Aliens that are created every time the
	 * board gets empty.
	 */
	public void levelUp() {
		if (aliens.isEmpty()) {
			alienSpeed *= 1.5;
			addAliens();
		}
	}
	
	/**
	 * Displays GAME OVER when game is over, i.e. when the player has no life
	 * remaining.
	 */
	public void drawGameEnd()
	{
		StdDraw.clear(Color.BLACK);
		StdDraw.setPenColor(Color.ORANGE);
		StdDraw.text(0, 0, "GAME OVER");
		StdDraw.show(100);
	}

	// Creates a game object and calls play() until the game is over i.e.
	// until both the players have lost all of their lives
	public static void main(String[] args) {
		Game game = new Game();
		while (!game.isOver()){
			game.play();
		}
	}
}
