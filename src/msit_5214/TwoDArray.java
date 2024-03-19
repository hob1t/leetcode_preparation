package msit_5214;

public class TwoDArray {
	
	public void print2DArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		int[][] input = {{2,3,4}, {4,5,6,}, {6,7,8}};
		TwoDArray twodArray = new TwoDArray();
		twodArray.print2DArray(input);

	}

}
