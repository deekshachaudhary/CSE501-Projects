package exercises8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsingList {

	public static void main(String[] args) {

		List<String> eating = new ArrayList<String> ();
		eating.add("open mouth");
		eating.add("insert food");
		eating.add("chew");
		eating.add("chew");
		eating.add("swallow");
		System.out.println(eating);
		
		eating.add(2, "close mouth");
		eating.add(5, "chew again");
		eating.add("repeat");
		System.out.println(eating);

		eating.remove(5);
		System.out.println(eating);
		
		
	}

}
