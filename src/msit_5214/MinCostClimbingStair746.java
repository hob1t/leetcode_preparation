package msit_5214;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10,15,20] Output: 15 Explanation: You will start at index 1. -
 * Pay 15 and climb two steps to reach the top. The total cost is 15.
 * 
 * Example 2:
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1] Output: 6 Explanation: You will
 * start at index 0. - Pay 1 and climb two steps to reach index 2. - Pay 1 and
 * climb two steps to reach index 4. - Pay 1 and climb two steps to reach index
 * 6. - Pay 1 and climb one step to reach index 7. - Pay 1 and climb two steps
 * to reach index 9. - Pay 1 and climb one step to reach the top. The total cost
 * is 6.
 * 
 */
public class MinCostClimbingStair746 {

	// idea compare cost for cost[i] and cost for cost[i + 1]
	public int minCostClimbingStairs(int[] cost) {
		int dp1 = 0, dp2 = 0;
		
		for(int inx = 0; inx < cost.length; inx++) {
			int dp0 = cost[inx] + Math.min(dp1, dp2);
			
			dp2 = dp1;
			dp1 = dp0;
		}

		return Math.min(dp1, dp2);
	}

	public static void main(String[] args) {
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		MinCostClimbingStair746 runner = new MinCostClimbingStair746();
		int result = runner.minCostClimbingStairs(cost);
        System.out.println("Result " + result);
	}
}
