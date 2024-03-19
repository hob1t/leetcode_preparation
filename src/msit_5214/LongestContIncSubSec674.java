package msit_5214;

/**
 * 
 * Given an unsorted array of integers nums, return the length of the longest
 * continuous increasing subsequence (i.e. subarray). The subsequence must be
 * strictly increasing.
 * 
 * A continuous increasing subsequence is defined by two indices l and r (l < r)
 * such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for
 * each l <= i < r, nums[i] < nums[i + 1].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,4,7] Output: 3 Explanation: The longest continuous
 * increasing subsequence is [1,3,5] with length 3. Even though [1,3,5,7] is an
 * increasing subsequence, it is not continuous as elements 5 and 7 are
 * separated by element 4.
 * 
 * Example 2:
 * 
 * Input: nums = [2,2,2,2,2] Output: 1 Explanation: The longest continuous
 * increasing subsequence is [2] with length 1. Note that it must be strictly
 * increasing.
 * 
 * Date:  March 19, 2024 still looking for the job.
 * Inspired by: https://www.youtube.com/watch?v=jSvoE-_Yhs4&t=2s
 * 
 */
public class LongestContIncSubSec674 {
	
    public int findLengthOfLCIS(int[] nums) {
    	// idea here to use sliding window
    	// we will have two variables: 1. result and 2. anchor - which will be shifted when needed
    	int result = 0, anchor = 0;
    	for(int inx = 0; inx < nums.length; inx++) {
    		if(inx > 0 && nums[inx - 1] >= nums[inx]) {
    			anchor = inx;
    		}
    		result = Math.max(result , inx - anchor + 1);
    	}
        
        return result;
    }

	public static void main(String[] args) {
		LongestContIncSubSec674 runner = new LongestContIncSubSec674();
		int[] nums = {1,3,5,4,7};
		System.out.println(runner.findLengthOfLCIS(nums));
	}
}
