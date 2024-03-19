package msit_5214;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,0,1,1,1] Output: 3 Explanation: The first two digits or
 * the last three digits are consecutive 1s. The maximum number of consecutive
 * 1s is 3.
 * 
 * Example 2:
 * 
 * Input: nums = [1,0,1,1,0,1] Output: 2
 * 
 */
public class EasyMalConsecensiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int left = 0;
		int localCounter = 1, max = 0;
		
		while(left < nums.length) {
			if(nums[left] == 1) {
				localCounter++;
			}
			
			if(nums[left] == 0) {
				max = Math.max(max, localCounter);
				localCounter = 0;
			}
			left++;
		}
		

		return max;
	}

	public static void main(String[] args) {
		EasyMalConsecensiveOnes runner = new EasyMalConsecensiveOnes();
        int[] nums = {1,0,1,1,0,1};		
        int result = runner.findMaxConsecutiveOnes(nums);
        System.out.println(result);
	}

}
