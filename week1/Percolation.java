//note: only allowed public methods and imported libs are those included in assignment specification api.  Additional private methods are acceptable/


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int dimension; // dimension of percolation grid.  grid is dimension x dimension
	private boolean[] sites; //list of all sites in the grid, true if they site is open, false if closed 
	private int vTopRow; //virtual site that all top row is connected to.  
	private int vBottomRow;
	private int numOpenSites;
	private WeightedQuickUnionUF quickUnion;
	
	//creates nxn grid with all points filled
	public Percolation(int n) {
		//throw illegalargumentexception if n <= 0 
		
		if(n <= 0) {
			throw new IllegalArgumentException("The size of the grid  must be greater than 0");
		}
		//assign dimension to be equal to n

		dimension = n;
		//create weighetedquickuf object with dimension*dimension plus 2, vtop and v bottom.
		quickUnion = new WeightedQuickUnionUF(dimension*dimension + 2);
		
		//create and fill sites array, all blocked. 
		
		sites = new boolean[dimension*dimension];
		for (int i = 0; i < dimension*dimension; i++) {
			sites[i] = false;
		}
				
		//assign vtop and vbottom
		vTopRow = dimension*dimension; //since weighted quick unions array is 0 to n-1, dimension*dimension makes this outside of the grid
		vBottomRow = dimension*dimension + 1;
		
		//set numopensites to zero
		numOpenSites = 0;
		
	}
	//opens the site if it is not already open
	public void open(int row, int col) {
		//throw illegal arument exception if either argument is <=0 or > dimension
		if (row <= 0 || row > dimension || col <= 0 || col > dimension) {
			throw new IllegalArgumentException("Both arguments must be within 1 to " + dimension);
		}
		//check if target site is closed.  if it is, open the site.  if not do nothing
		//check top, bottom, left right of site.  unify target site with any of these that are already open
		if(!isOpen(row, col)) {
			
			int newOpenSite = to1DIndex(row, col);
			sites[newOpenSite] = true;
			numOpenSites++;
			//if top row connected to virtual top
			//if row is bottom, connected to bottom virtual site
			if(row == 1) {
				quickUnion.union(newOpenSite, vTopRow);
			} else {
				if(isOpen(row-1, col)) quickUnion.union(newOpenSite, to1DIndex(row-1, col));
			}
			if(row == dimension) {
				quickUnion.union(newOpenSite, vBottomRow);
			} else {
				if(isOpen(row+1, col)) quickUnion.union(newOpenSite, to1DIndex(row+1, col));
			}
			
			//now do columns, checking edge cases
			if(col < dimension) {
				if(isOpen(row, col+1)) quickUnion.union(newOpenSite, to1DIndex(row, col+1));
			}
			if(col > 1) {
				if(isOpen(row, col-1)) quickUnion.union(newOpenSite, to1DIndex(row, col-1));
			}
			
		}
		
	}
	
	//returns true if site is open
	public boolean isOpen(int row, int col) {
		return sites[to1DIndex(row, col)];
	}
	
	//returns true if the site is full (is connected to the top row)
	public boolean isFull(int row, int col) {
		//return true if connected to vTopRow
		return quickUnion.find(to1DIndex(row, col)) == quickUnion.find(vTopRow);
	}
	
	//returns number of oipen sites
	public int numberOfOpenSites() {
		return numOpenSites;
		
	}
	//returns true if the system percolates (at least one bottom row is connected to top row)
	public boolean percolates() {
		return quickUnion.find(vTopRow) == quickUnion.find(vBottomRow);
	}
	
	//translate 2d row and column arguments into its corresponding index on a [0, n-1] array.
	private int to1DIndex(int row, int col) {
		return (row-1)*dimension + (col - 1);
	}
	
	//for testing
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
