package msit_5214;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Idea is 
 * use left and right pointer on sorted array
 * Then use recursion which use while loop for calculating two values.
 * 
 */
public class FourSum {
	
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	// 1. Sort the array
    	Arrays.sort(nums);
    	// 2. Using two pointers, just go from left and right until sun is equals to target
    	int leftPtr = 0, rightPtr = nums.length - 1;
    	int tmpSum = 0;
    	
    	while((tmpSum != target) || leftPtr >= rightPtr) {
    		tmpSum = nums[leftPtr] + nums[rightPtr];
    		
    		if(tmpSum == target) {
    			result[0] = leftPtr;
    			result[1] = rightPtr;
    			return result;
    		}
    		
    		if(tmpSum < target) {
    			leftPtr++;
    		} else {
    			rightPtr--;
    		}
    	}
    	
    	
		return result;
        
    }
	
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	printArray(nums);
    	Arrays.sort(nums);
    	printArray(nums);
    	
		return null;
        
    }
    
    void printArray(int[] input) {
    	for(int i = 0; i < input.length; i++) {
    		System.out.print(input[i] + " ");
    	}
    	System.out.println();
    }
	

	public static void main(String[] args) {
		//int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		FourSum fourSum = new FourSum();
		//fourSum.fourSum(nums, target);
		//int[] res = fourSum.twoSum(nums, target);
		//System.out.println(res);
		//nums = [2,7,11,15], 
		target = 9;
		int[] nums2 = {2,7,11,15};
		int[] res = fourSum.twoSum(nums2, target);
		System.out.println(res);
	}
}
