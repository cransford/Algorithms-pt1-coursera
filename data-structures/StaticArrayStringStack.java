// impementation of stack using an array instead of a linked list  constructor used to predefine capacity of stack -- will do a dynamic implementation later


public class StaticArrayStringStack {
	private String[] a;
	private int index;
	
	public  StaticArrayStringStack(int cap) {
		a = new String[cap];
	}
	
	public void push(String item) {
		a[index++] = item;
	}
	
	public String pop() {
		return a[--index];
	}
	
	public boolean isEmpty() {
		return index == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
