import java.util.Iterator;

public class LinkedListGenericStack <Item> implements Iterable<Item> {
	
	private Node first = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public void push(Item newItem) {
		Node oldFirst = first;
		first = new Node();
		first.item = newItem;
		first.next = oldFirst;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
		
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListGenericStack<Integer> test = new LinkedListGenericStack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		
		
		for(Integer i : test) {
			System.out.println(i);
		}
		
		System.out.println(test.pop());
;
	}

}
 