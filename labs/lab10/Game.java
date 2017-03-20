package lab10;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;

import sedgewick.StdDraw;

public class Game {

	public static void main(String[] args) {

		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);

		//	0 = yellow, 1 = green, 2 = blue, 3 = orange, 4 = magenta
		Alien a1 = new Alien(-0.4, 0.8, 0);
		Alien a2 = new Alien(-0.2, 0.8, 0);
		Alien a3 = new Alien(0.0, 0.8, 0);
		Alien a4 = new Alien(-0.4, 0.6, 0);
		Alien a5 = new Alien(-0.2, 0.6, 0);
		Alien a6 = new Alien(0.0, 0.6, 0);
		Alien a7 = new Alien(0.2, 0.8, 1);
		Alien a8 = new Alien(0.4, 0.8, 2);
		Alien a9 = new Alien(0.2, 0.6, 1);
		Alien a10 = new Alien(0.4, 0.6, 2);
		Alien a11 = new Alien(0.2, 0.8, 3);
		Alien a12 = new Alien(0.4, 0.8, 3);
		Alien a13 = new Alien(0.2, 0.4, 4);
		Alien a14 = new Alien(0.4, 0.4, 4);

		ArrayList<Alien> aliens = new ArrayList<>();

		aliens.add(a1);
		aliens.add(a2);
		aliens.add(a3);
		aliens.add(a4);
		aliens.add(a5);
		aliens.add(a6);
		aliens.add(a7);
		aliens.add(a8);
		aliens.add(a9);
		aliens.add(a10);
		aliens.add(a11);
		aliens.add(a12);
		aliens.add(a13);
		aliens.add(a14);
		
		Player[] players = new Player[2];
		Player p1 = new Player(0, -0.9, "First Player");
		players[0] = p1;
		ArrayList<Bullet> bullets = new ArrayList<Bullet>(); 
		HashSet<Alien> removeSet = new HashSet<Alien>();

		while(true) {
			while(p1.getLivesRemaining() > 0) {
				p1.draw();
				p1.move();
				p1.displayScore();
				p1.displayLives();

				if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_B)) {
					Bullet b = new Bullet(p1);
					bullets.add(b);
				}
				
				for(Bullet bullet : bullets) {
					bullet.draw();
					bullet.move();
				}
				for(Alien a : aliens) {
					a.draw();
					a.move();
					a.collision(p1);
				}
				for(Bullet bullet : bullets) {
					for(Alien a : aliens) {
						if(bullet.hit(a, p1) == true) {
							removeSet.add(a);
							StdDraw.pause(30);
						}
					}
				}
				for(Alien rem : removeSet) {
					aliens.remove(rem);
				}

				if(aliens.size() == 0) {
					aliens.add(a1);
					aliens.add(a2);
					aliens.add(a3);
					aliens.add(a4);
					aliens.add(a5);
					aliens.add(a6);
					aliens.add(a7);
					aliens.add(a8);
					aliens.add(a9);
					aliens.add(a10);
					aliens.add(a11);
					aliens.add(a12);
					aliens.add(a13);
					aliens.add(a14);
					removeSet.clear();
				}
				StdDraw.show(25);
				StdDraw.clear(Color.black);
			}
			StdDraw.clear(Color.black);
			StdDraw.setPenRadius(0.1);
			StdDraw.setPenColor(Color.ORANGE);
			StdDraw.text(0, 0, "GAME OVER!!");
			StdDraw.text(0, 0.2, "Press R to Restart");
			StdDraw.show(300);
			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_E)) {
				p1.setLivesRemaining(3);
			}
		}
	}
}