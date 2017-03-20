package exercises8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.biojava.bio.structure.align.util.SynchronizedOutFile;

public class Point {
	
	//
	// has-a x and y coordinate, both integers
	//  these are immutable so you should declare them "final"
	//
	// declare instance variables here:
	//
	
	private final int x, y;
	
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}


	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;


		//		return (int)(Math.random()*100000);
		//			This makes duplicate copies allowable
		// 			because it violates the consistency contract
		//			that it should return the same value when
		//			run multiple times

		
		//		return 0;
		//			It would work, it only assigns all the objects to
		//			the same buckey
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(3,4);
		Point p2 = new Point(4,5);
		System.out.println(p1 + " \n" +p2);
		List<Point> set = new LinkedList<Point>();
		set.add(new Point(131, 132));
		set.add(new Point(131,132));
		System.out.println("Set has " + set);
		
		// changing .equals to always return false
		// breaks reflexive contract, a is not equals
		// a itself
		
		System.out.println(set.contains(new Point(131,132)));
	}

}
