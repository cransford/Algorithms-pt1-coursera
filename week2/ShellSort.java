import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {

	public static void sort(Comparable[] a) {
		
		//calculate h
		int h = 1;
		while(h < a.length/3) h = 3*h + 1;
		
		while(h >= 1) {
			for(int j = h; j < a.length; j += h) {
				for(int k = j; k > 0 && less(a[k], a[k-h]); k -= h) {
					exch(a, k, k-h);
				}
			}
			h /= 3;
		}
		
	}
	
	private static boolean less(Comparable w, Comparable v) {
		return w.compareTo(v) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	//for testing
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	//for testing
	public static void printArray(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method 
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