// aaray stack implementation that includes resizing functionality.  also elminates loitering problem
public class ResizingArrayStringStack {
	private String[] a;
	private int index;

	public ResizingArrayStringStack() {
		a = new String[1];
	}
	
	public void push(String item) {
		if(index == a.length) resize(2*a.length);
		a[index++] = item;
	}
	
	public String pop() {
		String item = a[--index];
		a[index] = null;
		return item;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for( int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		a = copy;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
