package msit_5214;

import java.text.DecimalFormat;

/**
 * 
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,12,-5,-6,50,3], k = 4 Output: 12.75000 Explanation: Maximum
 * average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * 
 * Example 2:
 * 
 * Input: nums = [5], k = 1 Output: 5.00000
 * 
 */
public class MaximunAverageSubArray643 {
    public double findMaxAverage(int[] nums, int k) {
    	// try to use sliding window
    	int window = 0;
        for(int inx = 0; inx < k; inx++) {
        	window += nums[inx];
        }
    	
        double maxAverage = ((double)window / (double)k);
        
        // 
        for(int inx = 1; (inx + k) < nums.length; inx++) {
        	System.out.println("First:= " + nums[inx - 1] + ", second:= " + nums[inx + k]);
        	window = window - nums[inx - 1] + nums[inx + k - 1];
        	System.out.println("First:= " + window);
        	maxAverage = Math.max(maxAverage, (double)window / (double)k);
        }
    	
    	
		return maxAverage;
    }

	public static void main(String[] args) {
		MaximunAverageSubArray643 runner = new MaximunAverageSubArray643();
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		String formatter = "#0.00";
    	DecimalFormat df = new DecimalFormat(formatter);
		System.out.println("Max subarray average:= " + df.format(runner.findMaxAverage(nums, k)));
	}

}
