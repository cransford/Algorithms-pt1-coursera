import edu.princeton.cs.algs4.StdRandom;

public class BottomUpMerge {
	private static Comparable[] aux;
	
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[a.length];
		
		for(int sz = 1; sz < N; sz = sz+sz) {
			for(int lo = 0; lo < N - sz; lo += sz+sz) {
				merge(a, aux, lo, (lo+sz-1), Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	
	
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for(int n = lo; n <= hi; n++ ) { //HAD A BUG HERE!  NOTE: it is n<=hi not n < hi because hi is an actual index (the -1 is accounted for in the sort method when merge is called).    !
			aux[n] = a[n];
		}
		
		int i = lo;  // left hand index
		int j = mid+ 1; // right hand index
		
		
		for(int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = a[i++];
		}
		
	}
	
	
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	//  for testing...returns true if the array is sorted
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false; 
		}
		return true;
		
	}
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


