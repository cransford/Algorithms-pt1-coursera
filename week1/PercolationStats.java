
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
	private double sampleMean;
	private double[] percThresholdResults;
	private double stdDev;
	private int trials;
	private double confidenceHi;
	private double confidenceLo;
	// perform number of trials on a nxn grid
	public PercolationStats(int n, int trials) {
		if(n <= 0 || trials <= 0) {
			throw new IllegalArgumentException("Number of trials and grid size must both be greater than zero.");
		}
		
		percThresholdResults = new double[trials];
		this.trials = trials;
		// run trials
		for(int i = 0; i < trials; i++) {
			Percolation percolator = new Percolation(n);
			// while percolator does not percolate select a random site and open it
			while(!percolator.percolates()) {
				int randomRow = StdRandom.uniform(n) + 1;
				int randomCol = StdRandom.uniform(n) + 1;
				percolator.open(randomRow, randomCol);
			}
			// add threshold results to threshold results array
			percThresholdResults[i] = (double)percolator.numberOfOpenSites() / (n*n);
		}
		sampleMean = StdStats.mean(percThresholdResults);
		stdDev = StdStats.stddev(percThresholdResults);
		confidenceHi = sampleMean + ((1.96*stdDev) / Math.sqrt(trials));
		confidenceLo = sampleMean - ((1.96*stdDev) / Math.sqrt(trials));
		
	}
	
	// sample mean of percolation threshhold
	public double mean() {
		return sampleMean;
	}
	
	// sample standard deviation of percvolation threshhold
	public double stddev() {
		return stdDev;
	}
	
	// low endpopint of 95% confidence interval
	public double confidenceLo() {
		return confidenceLo;
	}
	
	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return confidenceHi;
	}
	//for test client
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// take in n, grid size and t, trials.  initialize PercolationStats object and print results
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		
		
		PercolationStats percStats = new PercolationStats(n, trials);
		StdOut.println("Mean = " + percStats.mean() );
		StdOut.println("Standard Deviation = " + percStats.stddev());
		StdOut.println("Confidence Interval: ["+ percStats.confidenceLo() + ", " + percStats.confidenceHi() + "]");
	}

}
