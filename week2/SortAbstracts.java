import java.io.File;

import edu.princeton.cs.algs4.In;

// this is a skeleton class containing the basic implementation of helper methods that will be used in all sorting algorithms.


public class SortAbstracts {
	
	public static void sort(Comparable[] a) {
		// 
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
	
	public static void main(String[] args) {
		File f = new File(args[0]);
		In in = new In(f);
		String[] a = in.readAllStrings();
		sort(a);
		System.out.println(isSorted(a));
	}
	

}
