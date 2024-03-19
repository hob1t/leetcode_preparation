package msit_5214;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in
 * nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1] Output: [2]
 *
 * 
 */
public class EasyFindAllDisapperedNumbersInArray {
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();

    	// idea to take a number and map to its index
    	for(int inx = 0; inx < nums.length; inx++) {
    		int absNum = Math.abs(nums[inx]);
    		
    		if(nums[absNum - 1] > 0) {
    			nums[absNum - 1] = -nums[absNum - 1];
    		}
    	}
    	
    	// now let's build result
    	for(int inx = 0; inx < nums.length; inx++) {
    		if(nums[inx] > 0) {
    			result.add(inx + 1);
    		}
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		EasyFindAllDisapperedNumbersInArray runner = new EasyFindAllDisapperedNumbersInArray();
		int[] nums = {4,3,2,7,8,2,3,1};
		runner.findDisappearedNumbers(nums);

	}

}
