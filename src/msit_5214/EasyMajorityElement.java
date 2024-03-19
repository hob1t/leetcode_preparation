package msit_5214;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,3] Output: 3
 * 
 * Example 2:
 * 
 * Input: nums = [2,2,1,1,1,2,2] Output: 2
 *
 * 
 */
public class EasyMajorityElement {
    public int majorityElement(int[] nums) {
    	Map<Integer, Integer> holder = new HashMap<>();
    	
    	for(int inx = 0; inx < nums.length; inx++) {
    		if(!holder.containsKey(nums[inx])) {
    			holder.put(nums[inx], 1);
    		} else {
    			holder.merge(nums[inx], 1, Integer::sum);
    		}
    	}
    	
    	int majority = nums.length / 2;
    	
    	for(int key : holder.keySet()) {
    		if(holder.get(key) > majority) {
    			return key;
    		}
    	}
    	
        return -1;
    }

	public static void main(String[] args) {
		EasyMajorityElement runner = new EasyMajorityElement();
		int[] first = new int[] {3,2,3};
		int result = runner.majorityElement(first);
		System.out.println("Result:=" + result);
        
		int[] second = new int[] {2,2,1,1,1,2,2};
		result = runner.majorityElement(second);
		System.out.println("Result:=" + result);
	}
}
