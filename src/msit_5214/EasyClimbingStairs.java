package msit_5214;

/**
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step 2. 2 steps
 * 
 * Example 2:
 * 
 * Input: n = 3 Output: 3 Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 *                   3
 *                1    2
 *              2   1 1 0
 *  It is bottom up dynamic programming problem
 *  two last positions are both 1
 */
public class EasyClimbingStairs {
	
    public int climbStairs(int n) {
    	int one = 1, two = 1;
    	for(int i = 0; i < n - 1; i++) {//last two positions are both 1
    		int tmp = one;
    		one = one + two;
    		two = tmp;
    	}
    	
        return one;
    }

	public static void main(String[] args) {
		EasyClimbingStairs easyClimbingStairs = new EasyClimbingStairs();
		int result = easyClimbingStairs.climbStairs(5);
		System.out.println(result);
	}

}
