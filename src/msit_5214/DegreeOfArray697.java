package msit_5214;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array Easy Topics Companies Hint
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,3,1] Output: 2 Explanation: The input array has a degree
 * of 2 because both elements 1 and 2 appear twice. Of the subarrays that have
 * the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2,
 * 2, 3], [2, 2] The shortest length is 2. So return 2.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,2,3,1,4,2] Output: 6 Explanation: The degree is 3 because
 * the element 2 is repeated 3 times. So [2,2,3,1,4,2] is the shortest subarray,
 * therefore returning 6.
 * 
 */
public class DegreeOfArray697 {
	
	class Pair {
		public int left;
		public int right;
		
		Pair(int l, int r) {
			this.left = l;
			this.right = r;
		}
	}
	
	
    public int findShortestSubArray(int[] nums) {
    	Map<Integer, Pair> holder = new HashMap<>();
    	int localMax = Integer.MIN_VALUE, localMin = Integer.MAX_VALUE;
    	
    	for(int inx = 0; inx < nums.length; inx++) {
    		if(!holder.containsKey(nums[inx])) {
    			holder.put(nums[inx], new Pair(1, inx));
    		} else {
    			Pair tmp = holder.get(nums[inx]);
    			tmp.left = tmp.left + 1;
    			tmp.right = inx;
    			localMax = Math.max(localMax, tmp.left);
    			holder.put(nums[inx], tmp);
    		}
    	}
    	
    	System.out.println("Local max:= " + localMax);
    	
    	for(Integer key : holder.keySet()) {
    		Pair tmp = holder.get(key);
    		if(tmp.left == localMax) {
    			localMin = Math.min(localMin, tmp.right);
    		}
    	}
    	
    	return localMin;
    }

	public static void main(String[] args) {
		DegreeOfArray697 runner = new DegreeOfArray697();
		int[] nums = {1,2,2,3,1,4,2};
		int result = runner.findShortestSubArray(nums);
		System.out.println("Result:= " + result);
	}

}
