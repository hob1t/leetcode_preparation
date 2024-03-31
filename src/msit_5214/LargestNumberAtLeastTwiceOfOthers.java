package msit_5214;

/**
 * You are given an integer array nums where the largest integer is unique.
 * 
 * Determine whether the largest element in the array is at least twice as much
 * as every other number in the array. If it is, return the index of the largest
 * element, or return -1 otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,6,1,0] Output: 1 Explanation: 6 is the largest integer. For
 * every other number in the array x, 6 is at least twice as big as x. The index
 * of value 6 is 1, so we return 1.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4] Output: -1 Explanation: 4 is less than twice the
 * value of 3, so we return -1.
 * 
 */
public class LargestNumberAtLeastTwiceOfOthers {
	public int dominantIndex(int[] nums) {
		int max = Integer.MIN_VALUE, index = -1, len = nums.length - 1;
		
		// first scan we find the max
		for (int inx = 0; inx < nums.length; inx++) {
			max = Math.max(max, nums[inx]);
			if (max == nums[inx]) {
				index = inx;
			}
		}

		// the second scan check each element if it is bigger
		// that max.
		for (int inx = 0; inx < nums.length; inx++) {
			if (nums[inx] == 0 && (max - nums[inx] >= 2)) {
				--len;
			}
            // prevent division by zero
			if (nums[inx] != 0 && (max / nums[inx]) >= 2) {
				--len;
			}
		}

		return (len == 0) ? index : -1;
	}

	public static void main(String[] args) {
		LargestNumberAtLeastTwiceOfOthers runner = new LargestNumberAtLeastTwiceOfOthers();
		int[] nums = { 1,2,3,4 };
		int result = runner.dominantIndex(nums);
		System.out.println("Result " + result);
	}
}
