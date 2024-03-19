package msit_5214;

/**
 * 
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,2,1] Output: 1
 * 
 * Example 2:
 * 
 * Input: nums = [4,1,2,1,2] Output: 4
 * 
 * Example 3:
 * 
 * Input: nums = [1] Output: 1
 *
 * 
 */
public class EasySingleNumber_Bit {
	
	/**
	 * Idea is to use xor. XOR compares two numbers, if they are equals it returns 0
	 * 
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
    	int result = 0;
    	for(int inx = 0; inx < nums.length; inx++) {
    		result ^= nums[inx];
    	}
    	
    	return result;
        
    }

	public static void main(String[] args) {
		EasySingleNumber_Bit runner = new EasySingleNumber_Bit();
		int[] nums = new int[] {2,2,1};
		int result = runner.singleNumber(nums);
		System.out.println("result:=" + result);
		
		int[] nums2 = new int[] {4,1,2,1,2};
		result = runner.singleNumber(nums2);
		System.out.println("result:=" + result);

	}

}
