package lab9;

public class ListItem {
	//
	// Important:  Do NOT make these instance variables private
	// Our testing needs to be able to access them, so leave their
	//   declarations as you see them below.
	//
	final int number;
	ListItem next;

	/**
	 * Creates a single list item.
	 * @param number the value to be held in the item
	 * @param next a reference to the next item in the list
	 */
	ListItem(int number, ListItem next) {
		this.number = number;
		this.next   = next;
	}

	/**
	 * Return a copy of this list using recursion.  No
	 * credit if you use any iteration!  All existing lists should remain
	 * intact -- this method must not mutate anything.
	 * @return duplicate of the list
	 */
	public ListItem duplicate() {
		if(this.next == null) {
			return new ListItem(this.number, null);
		}
		else {
			return new ListItem(this.number, this.next.duplicate());
		}
	}

	/**
	 * Recursively compute the number of elements in the list. No
	 * credit if you use any iteration!  All existing lists should remain
	 * intact.
	 * @return length of linkedList
	 */
	public int length() {
		if(this.next == null) {			
			return 1;
		}
		else {
			return 1 + this.next.length();
		}
	}

	/**
	 * Return a new list, like duplicate(), but every element
	 * appears n times instead of once.  See the web page for details.
	 * You must do this method iteratively.  No credit
	 * if you use any recursion!
	 * @param n a positive (never 0) number specifying how many times to copy each element
	 * @return list with each element repeated n times
	 */

	public ListItem stretch(int n) {
		ListItem l = this;
		ListItem curr = new ListItem(this.number, null);
		while(l != null) {
			for(int i = 0; i < n; i++) {
				ListItem tracker = curr;
				while(tracker.next != null) {
					tracker = tracker.next;
				}
				ListItem newItem1 = new ListItem(l.number, null);
				tracker.next = newItem1;
			}
			l = l.next;
		}
		return curr.next;
	}


	/**
	 * Return the first ListItem, looking from "this" forward,
	 * that contains the specified number.  No lists should be
	 * modified as a result of this call.  You may do this recursively
	 * or iteratively, as you like.
	 * @param n number to find
	 * @return list starting by n
	 */

	public ListItem find(int n) {
		ListItem l = this;
		while(l != null) {
			if(l.number == n) {
				return l;
			}
			else {
				l = l.next;
			}
		}
		return null;
	}

	/**
	 * Return the maximum number contained in the list
	 * from this point forward.  No lists should be modified
	 * as a result of this call.  You may do this method recursively
	 * or iteratively,as you like.
	 * @return maximum number
	 */

	public int max() {
		int max = this.number;
		ListItem l = this;
		while(l != null) {
			if(l.number > max) {
				max = l.number;
			}
			else {
				l = l.next;
			}
		}
		return max;
	}

	/**
	 * Returns a copy of the list beginning at ls, but containing
	 * only elements that are even.
	 * @param ls
	 * @return
	 */
	public static ListItem evenElements(ListItem ls) {
		if(ls == null) {
			return null;
		}
		else {
			if(ls.number % 2 != 0) {
				return(evenElements(ls.next));
			}
			else {
				return new ListItem
						(ls.number, evenElements(ls.next));
			}
		}
	}

	/**
	 * Returns a string representation of the values reachable from
	 * this list item.  Values appear in the same order as the occur in
	 * the linked structure.  Leave this method alone so our testing will work
	 * properly.
	 */
	public String toString() {
		if (next == null)
			return ("" + number);
		else
			return (number + " " + next); // calls next.toString() implicitly
	}
}
