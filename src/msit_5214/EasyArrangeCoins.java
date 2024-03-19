package msit_5214;

/**
 * 
 * You have n coins and you want to build a staircase with these coins. The
 * staircase consists of k rows where the ith row has exactly i coins. The last
 * row of the staircase may be incomplete.
 * 
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 * 
 * 
 * 
 * Input: n = 5 Output: 2 Explanation: Because the 3rd row is incomplete, we
 * return 2.
 *
 * 
 */
public class EasyArrangeCoins {

	public int arrangeCoins(int n) {
		int numRows = 0;
		int prev = 0, local = n;
		
		for (int i = 1; i <= n; i++) {
			prev += i;
			if ((local - prev) > 0) {
				numRows++;
			} else if ((local - prev) == 0) {
				numRows++;
			}
			
			local -= 1;
		}
		return numRows;
	}

	public static void main(String[] args) {
		EasyArrangeCoins runner = new EasyArrangeCoins();
		int result = runner.arrangeCoins(5);
		System.out.println(result);

	}
}
