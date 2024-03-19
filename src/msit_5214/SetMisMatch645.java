package msit_5214;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * You have a set of integers s, which originally contains all the numbers from
 * 1 to n. Unfortunately, due to some error, one of the numbers in s got
 * duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 * 
 * You are given an integer array nums representing the data status of this set
 * after the error.
 * 
 * Find the number that occurs twice and the number that is missing and return
 * them in the form of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,4] Output: [2,3]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1] Output: [1,2]
 * 
 */
public class SetMisMatch645 {
	public int[] findErrorNums(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int curValue = nums[0];
		for (int inx = 1; (inx + 1) <= nums.length; inx++) {
			if (curValue != nums[inx]) {
				curValue = nums[inx];
			} else {
				result.add(curValue);
				curValue = nums[inx] + 1;
				result.add(curValue);
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		SetMisMatch645 runner = new SetMisMatch645();
		int[] nums = {1,2,2,4};
		int[] result = runner.findErrorNums(nums);
		IntStream.of(result).forEach(System.out::println);
	}
}
