package msit_5214;

/**
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * 5 -1 = 4 max = 5
 * 
 * Input: prices = [7,1,5,3,6,4] // 1 - 7 = -6 Output: 5 Explanation: Buy on day
 * 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Note that
 * buying on day 2 and selling on day 1 is not allowed because you must buy
 * before you sell. Example 2:
 * 
 * 
 * max = 0 Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 
 * 0 <= prices[i] <= 104
 *
 */
public class AnaPlanInterview {
	
	public int calculateMaxProfit(int[] prices) {
		int max = 0, localProfit = 0;
		int buy = 0, sell = 1;

		for(int i = 0; i < prices.length; i++) {
			if(sell < prices.length) {
				max = Math.max(max, (prices[sell] - prices[buy]));
				localProfit = prices[sell] - prices[buy];
				// when I increase the sell ...
				if(localProfit < 0) {
					buy = sell;
					sell++;
				} 
				else {
					sell++; // problem
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		AnaPlanInterview runner = new AnaPlanInterview();
		int[] prices = {7,1,5,3,6,4}; //..
        int result = runner.calculateMaxProfit(prices);
        System.out.println("Result " + result);
	}

}
