package matrix;


public class Matrix {
	
	private double[][] values;
		
	/**
	 * The Matrix is based on the supplied two-dimensional array of values.
	 * Be sure to make your own copy of the values, so that changes to the
	 *    array outside of this class do not affect your work.
	 * @param values
	 */
	public Matrix(double[][] in) {
//		values = null;  // FIXME -- make a copy of in
		                //  this is not the same thing as writing:
		                //  values = in
		int numRows = in.length;
		int numCols = in[0].length;
		this.values = new double[numRows][numCols];
		for(int r = 0; r < numRows; r++) {
			for(int c = 0; c < numCols; c++) {
				values[r][c] = in[r][c];
			}
		}
	}
	
	/**
	 * 
	 * @param row row
	 * @param col column
	 * @return
	 */
	public double getValue(int row, int col) {
		return this.values[row][col];  // Do not change this!
	}
	
	/**
	 * 
	 * @return number of rows
	 */
	public int getNumRows() {
		return values.length;  // Do not change!
	}
	
	/**
	 * 
	 * @return number of columns
	 */
	public int getNumCols() {
		return values[0].length; // Do not change!
	}
	
	/**
	 * You must complete this method, or the equals(Object) test will always
	 *   return false. 
	 * Arrays one and two are considered
	 * equal if and only if:
	 *   1) They have the same shape (number of rows and columns agree)
	 *   2) The contents of the two arrays are the same, element by element
	 * @param one
	 * @param two
	 * @return true iff the arrays have the same shape and contents
	 */
	private static boolean arraysAreEqual(double[][] one, double[][] two) {
		if(one.length == two.length && 
				one[0].length == two[0].length) {
			for(int r = 0; r < one.length; r++) {
				for(int c = 0; c < one[0].length; c++) {
					if(one[r][c] != two[r][c]) {
						return false;
					}
				}
			}
			return true;
		}
		else
			return false;
	}
	
	/**
	 * This was generated initially by eclipse, but
	 *   eclipse does not know how to compare two-dimensional arrays.
	 *   We therefore call arraysAreEequal to do that job.
	 */
	public boolean equals(Object obj) {
		// If this and obj are the same object, they must be equal
		if (this == obj)
			return true;
		// If obj is null ("this" cannot be null), then they are not equal
		if (obj == null)
			return false;
		// If the two objects are not the same type, they are not equal
		if (getClass() != obj.getClass())
			return false;
		//
		// If we get here, we have two objects of the same type.
		// Calling your helper method to determine the arrays' equality.
		Matrix other = (Matrix) obj;
		return arraysAreEqual(this.values, other.values);
	}
	
	/**
	 * 
	 * @param other matrix to add
	 * @return
	 */
	public Matrix plus(Matrix other) {
		double[][] newMatrix = new double[this.values.length]
							[this.values[0].length];
		Matrix sumMatrix = new Matrix (newMatrix);

		if(this.values.length != other.values.length || 
				this.values[0].length != other.values[0].length) {
			throw new IllegalArgumentException(); //googled how to throw an exception
		}
		for(int i = 0; i < this.values.length; i++) {
			for(int j = 0; j < this.values[0].length; j++) {
				sumMatrix.values[i][j] = other.values[i][j] + 
						this.values[i][j]; 
			}
		}
		return sumMatrix;
	}
	
	/**
	 * Returns a **new Matrix** that is the product of this and the other one.
	 * Does not change this Matrix at all.
	 * @param other
	 * @return
	 */
	public Matrix times(Matrix other) {
		double[][] newMatrix = new double[this.values.length]
				[other.values[0].length];
		Matrix timesMatrix = new Matrix (newMatrix);
		if(this.values[0].length != other.values.length) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < this.values.length; i++) {
			for(int j = 0; j < other.values[0].length; j++) {
				for(int k = 0; k < this.values[0].length; k++) {
					timesMatrix.values[i][j] = timesMatrix.
							values[i][j] + (this.values[i][k] 
									*other.values[k][j]);
				}
			}
		}
		return timesMatrix;		
	}
	
	/**
	 * Returns a **new Matrix** that is the transpose of this one.
	 * Does not change this Matrix at all.
	 * @return
	 */
	public Matrix transpose() {
		double[][] newMatrix = new double[this.values[0].length]
				[this.values.length];
		Matrix transposed = new Matrix (newMatrix);
		for(int i = 0; i < this.values.length; i++) {
			for(int j = 0; j < this.values[0].length; j++) {
				transposed.values[j][i] = this.values[i][j];
			}
		}
		return transposed;
	}

	/**
	 * Modifies this Matrix by scaling row i by the supplied factor.
	 * @param i the row to scale, where 0 is the top row
	 * @param factor the amount by which to scale each element of row i
	 */
	public void scaleRow(int i, double factor) {
		if(i == values.length) {
			throw new IllegalArgumentException();
		}
		for(int j = 0; j < this.getNumCols(); j++) {
			this.values[i][j] = this.values[i][j] * factor;
		}
	}

	/**
	 * Modifies this matrix by adding row i to row j.  Row 0 is the top row.
	 * @param i
	 * @param j
	 */
	public void addRows(int i, int j) {
		for(int k = 0; k < values[0].length; k++) {
			values[j][k] = values[i][k] + values[j][k];
		}		
	}
	
	/**
	 * Modifies the Matrix by exchanging row i with row j
	 * @param i
	 * @param j
	 */
	public void exchangeRows(int i, int j){
		double temp;
		for(int k = 0; k < this.values[0].length; k++) {
			temp = values[i][k];
			values[i][k] = values[j][k];
			values[j][k] = temp;
		}
	}

	/**
	 * My gift to you.  This returns a String representation of
	 * the Matrix.  The contents of each row is separated by a tab (\t)
	 * so that columns (kind of) line up.  Each row is separated by a
	 * newline (\n) so that the output looks like a matrix.  The output
	 * of this method should <i>not</i> be used to compare matrices for
	 * equality:  use the .equals(Object) method instead!
	 */
	public String toString() {
		String ans = "";
		for (int i=0; i < values.length; ++i) {
			ans = ans + "\n";
			// Loop below assumes all rows have the same number of columns
			for (int j=0; j < values[0].length; ++j) {
				ans = ans + values[i][j] + "\t";
			}
		}
		return ans;
	}

}
