package msit_5214;

import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious
 * subsequence among all its possible subsequences.
 * 
 * A subsequence of array is a sequence that can be derived from the array by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,2,2,5,2,3,7] Output: 5 Explanation: The longest harmonious
 * subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4] Output: 2
 * 
 * Example 3:
 * 
 * Input: nums = [1,1,1,1] Output: 0
 * 
 */
public class EasyLongestHarmoniousSubSequence {

	public int findLHS(int[] nums) {
		// HashMap - O(N) required
		Map<Integer, Integer> holder = new HashMap<>();
		int counter = 0;
		// use hash to count frequency of elements
		for(int inx = 0; inx < nums.length; inx++) {
			if(!holder.containsKey(nums[inx])) {
				holder.put(nums[inx], 1);
			} else {
				holder.merge(nums[inx], 1, Integer::sum);
			}
		}
		// find max with neighbor keys
		for(Integer num : holder.keySet()) {
			if(holder.containsKey(num + 1)) {
				counter = Math.max(counter, (holder.get(num) + holder.get(num + 1)));
			} else if(holder.containsKey(num - 1)) {
				counter = Math.max(counter, (holder.get(num) + holder.get(num - 1)));
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		EasyLongestHarmoniousSubSequence runner = new EasyLongestHarmoniousSubSequence();
		int[] nums = {1,1,1,1};
		int result = runner.findLHS(nums);
        System.out.println("Result " + result);
	}

}
