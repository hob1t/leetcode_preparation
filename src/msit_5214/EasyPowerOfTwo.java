package msit_5214;

/**
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: true Explanation: 20 = 1
 * 
 * Example 2:
 * 
 * Input: n = 16 Output: true Explanation: 24 = 16
 * 
 * Example 3:
 * 
 * Input: n = 3 Output: false
 *
 * 
 */
public class EasyPowerOfTwo {
	
	public boolean isPowerOfTwo(int n) {
		if (n == 1) {
			return true;
		}
		
		int counter = 0;
		while (n % 2 == 0 && n > 0) {
			n = n / 2;
			counter++;
		}

		return counter > 0;
	}

	public static void main(String[] args) {
		EasyPowerOfTwo runner = new EasyPowerOfTwo();
		System.out.println(runner.isPowerOfTwo(3));
	}
}
