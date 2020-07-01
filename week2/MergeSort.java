import edu.princeton.cs.algs4.StdRandom;

public class MergeSort {
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo,  int hi) {
		// this will be called recursively, so first make sure theres something to do
		if(lo >= hi) return;
		// System.out.println("["+ lo +", "+hi+"]");
		int mid = lo + (hi - lo) / 2;
		
		//sort both sides
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	// private method will merge 2 sorted halves of subarrays of a.  it will be calledd in a private sort method which will call itself recursively
	//so that a will be split into numerous smaller arrays that will be sorted and merged up until finally a full 1/2 of a sorted will be 
	//merged with the other half of a sorted.
	private static void merge(Comparable a[], Comparable aux[], int lo, int mid, int hi) {
		// copy a to aux
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		// go through aux merging the two sorted halves of aux into a
		
		int i = lo; // left side index
		int j = mid+1; // right side index
		
		for(int k = lo; k <= hi; k++) {
			//if left side exhausted take from right
			if(i > mid) a[k] = aux[j++];
			//if right side exhausted take from left
			else if(j > hi) a[k] = aux[i++];
			//if right is less than left, take from right
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			//if left is less than right or right and left are qual take from left.  THE LEFT TAKING ON EUalITY MAKES MERGESORT A StaBLE SORT.  (see class notes for def of stability if needed
			else a[k] = aux[i++];
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
	
	// for testing, display array elements
		private static void printArray(Comparable[] a) {
			for(int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
		}

	public static void main(String[] args) {
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
