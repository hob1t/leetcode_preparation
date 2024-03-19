package msit_5214;

import java.util.Arrays;

/**
 * 
 * In MATLAB, there is a handy function called reshape which can reshape an m x
 * n matrix into a new one with a different size r x c keeping its original
 * data.
 * 
 * You are given an m x n matrix mat and two integers r and c representing the
 * number of rows and the number of columns of the wanted reshaped matrix.
 * 
 * The reshaped matrix should be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 * 
 * If the reshape operation with given parameters is possible and legal, output
 * the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4 Output: [[1,2,3,4]]
 * 
 * Example 2:
 * 
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4 Output: [[1,2],[3,4]]
 * 
 */
public class EasyReshareMatrix {

	public int[][] matrixReshape(int[][] mat, int r, int c) {

		// we have to check if we can reshape, by comparing mat.lenght * mat[0].lenght
		// vs r * c
		// if they are equals
		int sizeOrig = (mat.length * mat[0].length);
		int sizeDest = r * c;

		if (sizeOrig == sizeDest) {
			// continue to reshape
			// row: i / col
			// col: i % col
			// result[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length]

			int[][] result = new int[r][c];

			for (int inx = 0; inx < (r * c); inx++) {
				result[inx / c][inx % c] = mat[inx / mat[0].length][inx % mat[0].length];
			}

			return result;
		}

		System.out.println("Cannot reshape");
		return mat;
	}

	public static void main(String[] args) {
		EasyReshareMatrix runner = new EasyReshareMatrix();
        int[][] mat = {{1,2}, {3, 4}};
        int r = 2, c = 4;
        
        int[][] result = runner.matrixReshape(mat, r, c);
        
        
        Arrays.stream(result).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
          });
	}
}
