package DataStructures;

public class FixedCapacityStack <Item>{
	private Item[] a;
	private int size;
	
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
		size = 0;
		
	}
	
	public void push(Item newItem) {
		a[size++] = newItem;
	}
	
	public Item pop() {
		return a[--size];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
