package msit_5214;

/**
 * 
 * Example 1:
 * 
 * Input: x = 4 Output: 2 Explanation: The square root of 4 is 2, so we return
 * 2.
 * 
 * Example 2:
 * 
 * Input: x = 8 Output: 2 Explanation: The square root of 8 is 2.82842..., and
 * since we round it down to the nearest integer, 2 is returned.
 *
 * 
 */
public class EasySqrt {
	/**
	 * Idea:
	 * from number minus odd number and count number of occurrences.
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		int numOfOccur = 0;
		int curOdd = 1;
		boolean isDone = false;
		while(!isDone) {
			if((x - curOdd) >= 0) {
			    x = x - curOdd;
			    curOdd += 2;
			    numOfOccur++;
			} else {
				isDone = true;
			}
		}
		
        return numOfOccur;
	}

	public static void main(String[] args) {
		EasySqrt easySqrt = new EasySqrt();
		int result = easySqrt.mySqrt(4);
        System.out.println(result);
	}

}
