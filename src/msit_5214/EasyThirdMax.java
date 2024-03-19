package msit_5214;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Given an integer array nums, return the third distinct maximum number in this
 * array. If the third maximum does not exist, return the maximum number.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,1] Output: 1 Explanation: The first distinct maximum is 3.
 * The second distinct maximum is 2. The third distinct maximum is 1.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2] Output: 2 Explanation: The first distinct maximum is 2.
 * The second distinct maximum is 1. The third distinct maximum does not exist,
 * so the maximum (2) is returned instead.
 * 
 * Example 3:
 * 
 * Input: nums = [2,2,3,1] Output: 1 Explanation: The first distinct maximum is
 * 3. The second distinct maximum is 2 (both 2's are counted together since they
 * have the same value). The third distinct maximum is 1.
 *
 * 
 */
public class EasyThirdMax {

	public int thirdMax(int[] nums) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for (int inx = 0; inx < nums.length; inx++) {
			if(!maxHeap.contains(nums[inx])) {
			    maxHeap.add(nums[inx]);
			}
		}
		
		List<Integer> holder = new ArrayList<>();
		int counter = 3;
		
		while (counter >= 1) {
			if (!maxHeap.isEmpty()) {
				holder.add(maxHeap.remove());
			} else {
				counter = 0;
			}
			counter--;
		}

		holder.forEach(System.out::println);

		return (holder.size() >= 3) ? holder.get(holder.size() - 1) : holder.get(0);
	}

	public static void main(String[] args) {
		EasyThirdMax runner = new EasyThirdMax();
        int[] nums = {2,2,3,1};
        int result = runner.thirdMax(nums);
        System.out.println("Result is " + result);
	}

}
