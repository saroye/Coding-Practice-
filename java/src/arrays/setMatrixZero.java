package arrays;

public class setMatrixZero {

	public void setZeroes(int[][] matrix) {

		int[] rows   = new int[matrix.length];
		int[] col = new int[matrix[0].length];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j]==0) {
					this.set(matrix, i, j);
				}
			}
		}

	}
	public void set(int[][] matrix, int row, int col) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				
			}
		}
	}

	public static void main(String [] args) {

		setMatrixZero s = new setMatrixZero();

	}
}
