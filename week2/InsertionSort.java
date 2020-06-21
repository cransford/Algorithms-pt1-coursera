import edu.princeton.cs.algs4.StdRandom;

// insertion sort.  on the ith iteration, check the item to the left and swap if the item to the left is larger than item to the right.  Continue util proper point is reached.

public class InsertionSort {
	

	public static void sort(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			for(int j = i; j > 0 && less(a[j], a[j-1]); j-- ) { 
				exch(a, j, j-1);
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; // returns true if v is less than w
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	// primarily for testing...returns true if the array is sorted
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false; 
		}
		return true;
	}
	// for testing
	private static void printArray(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = new Integer[10];
		for(int i = 0; i < test.length; i++) {
			test[i] = StdRandom.uniform(20);
		}
		printArray(test);
		sort(test);
		System.out.println(isSorted(test));
		printArray(test);

	}

}
