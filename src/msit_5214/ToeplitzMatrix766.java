package msit_5214;

/**
 * 
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise,
 * return false.
 * 
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]] Output: true Explanation: In
 * the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]",
 * "[3, 3]", "[4]". In each diagonal all elements are the same, so the answer is
 * True.
 * 
 * Example 2:
 * 
 * Input: matrix = [[1,2],[2,2]] Output: false Explanation: The diagonal "[1,
 * 2]" has different elements.
 *
 * 
 */
public class ToeplitzMatrix766 {

	public boolean isToeplitzMatrix(int[][] matrix) {

		// go through columns
		for (int col = 0; col < matrix[0].length; col++) {
			if (!isSame(0, col, matrix)) {
				return false;
			}
		}

		for (int row = 1; row < matrix.length; row++) {
			if (!isSame(row, 0, matrix)) {
				return false;
			}
		}

		return true;
	}

	private boolean isSame(int row, int col, int[][] matrix) {
		int number = matrix[row][col];
		while (row < matrix.length && col < matrix[0].length) {
			if (matrix[row][col] != number) {
				return false;
			}
			row++;
			col++;
		}
		return true;
	}

	public static void main(String[] args) {
		ToeplitzMatrix766 runner = new ToeplitzMatrix766();
		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		int[][] matrix = { { 1, 2 }, { 2, 2 } };
		boolean result = runner.isToeplitzMatrix(matrix);
		System.out.println("is toeplitz:= " + result);
	}

}
