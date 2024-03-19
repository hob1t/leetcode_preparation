package msit_5214;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * You are given a sorted unique integer array nums.
 * 
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b "a" if a == b
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: The
 * ranges are: [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7"
 * 
 * Example 2:
 * 
 * Input: nums = [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation:
 * The ranges are: [0,0] --> "0" [2,4] --> "2->4" [6,6] --> "6" [8,9] --> "8->9"
 *
 * 
 */
public class EasyRangeSummary {
	public List<String> summaryRanges(int[] nums) {
		// we are going to use two pointers and a helper function which returns result
		int left = 0, right = 1;
		List<String> sumOfRanges = new ArrayList<>();
		
		for(int i = 0; i < nums.length; i++) {
			// case 1: diff = 1
			if((right < nums.length) && (nums[right] - nums[i]) == 1) {
				right++;
			} else {
				String result = buildRangeStr(left, i, nums);
				sumOfRanges.add(result);
				left = i + 1;
				right++;
			}
		}
		
		
		return sumOfRanges;
	}
	
	public String buildRangeStr(int leftInx, int rightInx, int[] nums) {
		StringBuffer sb = new StringBuffer();
		
		if(leftInx == rightInx) {
			sb.append(nums[leftInx]);
			return sb.toString();
		}
		
		sb.append(nums[leftInx]).append("->").append(nums[rightInx]);
		return sb.toString();
	}
	
	

	public static void main(String[] args) {
		EasyRangeSummary runner = new EasyRangeSummary();
		int[] nums = new int[] {0,2,3,4,6,8,9};
		List<String> drt = runner.summaryRanges(nums);
		drt.forEach(item -> {
			System.out.println(item);
		});
		
		int[] second = new int[] {0,1,2,4,5,7};
		drt = runner.summaryRanges(second);
		drt.forEach(item -> {
			System.out.println(item);
		});
		
	}

}
