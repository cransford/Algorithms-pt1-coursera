import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickSort {
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		
		while(true) {
			while(less(a[++i], a[lo]))
				if(i == hi ) break;
			
			while(less(a[lo], a[--j]))
				if(j==lo) break;
			
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean less(Comparable w, Comparable v) {
		return w.compareTo(v) < 0;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = new Integer[1000000];
		for(int i = 0; i < test.length; i++) {
			test[i] = StdRandom.uniform(100000);
		}
		
		Stopwatch watch = new Stopwatch();
		sort(test);
		double time = watch.elapsedTime();
		System.out.println(isSorted(test));
		
		System.out.println(time);
	}

}
