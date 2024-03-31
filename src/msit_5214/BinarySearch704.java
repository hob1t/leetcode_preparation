package msit_5214;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4
 * 
 * Example 2:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not
 * exist in nums so return -1
 * 
 */
public class BinarySearch704 {
	
    public int search(int[] nums, int target) {
    	
    	int left = 0, right = nums.length -1, middle = 0;
    	
    	// 9 -> (left + right) / 2 = 0 + 5 / 2 = 2; == 3 
    	// if(3 < target) left = middle; (left + right) / 2 = 2 + 5 = 3
    	// if( 5 < target) -> left = middle; (left + right) / 2 = (3 + 5)/2 = 4
    	//(if local == target) return index
    	
    	while(left <= right) {
    		System.out.println("Left = " + left + ", right:= " + right + ", middle:= " + middle);
    		middle = (left + right) / 2;
    		
    		if(nums[middle] == target) {
    			return middle;
    		}
    		
    		
    		if(nums[middle] < target) {
    			left = middle + 1;
    		} else {
    			right = middle - 1;
    		} 
    	}
    	
        return -1;   
    }

	public static void main(String[] args) {
		BinarySearch704 runner = new BinarySearch704();
		int[] nums = {-1,0,3,5,9,12};
		int target = 2;
		int result = runner.search(nums, target);
		System.out.println("result:= " + result);

	}

}
