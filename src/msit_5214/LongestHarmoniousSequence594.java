package msit_5214;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 
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
public class LongestHarmoniousSequence594 {
	
    public int findLHS(int[] nums) {
    	int max = 0;

        if(nums == null || nums.length == 0) return max;
        
        Map<Integer, Integer> holder = new HashMap<>();
        
        IntStream.of(nums).forEach( item -> {
        	if(!holder.containsKey(item)) {
        		holder.put(item, 1);
        	} else {
        		holder.merge(item, 1, Integer::sum);
        	}
        });
        
        Integer[] keys = holder.keySet().toArray(new Integer[holder.keySet().size()]);
        for(int inx = 0; inx < keys.length; inx++) {
        	if((inx + 1) < keys.length) {
        		if(Math.abs(keys[inx] - keys[inx + 1]) == 1) {
        			max = Math.max(max, holder.get(keys[inx]) + holder.get(keys[inx + 1]));
        		}
        	}
        }
    	
    	return max;
    }

	public static void main(String[] args) {
		LongestHarmoniousSequence594 runner = new LongestHarmoniousSequence594();
        int[] nums = {1,1,1,1};		
        int max = runner.findLHS(nums);
        System.out.println("The answer is:= " + max);
	}

}
