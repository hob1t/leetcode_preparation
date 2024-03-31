package msit_5214;

/**
 * 
 * Given an array of integers nums, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the
 * index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the
 * array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,7,3,6,5,6] Output: 3 Explanation: The pivot index is 3. Left
 * sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 Right sum = nums[4] +
 * nums[5] = 5 + 6 = 11
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output: -1 Explanation: There is no index that
 * satisfies the conditions in the problem statement.
 * 
 * Example 3:
 * 
 * Input: nums = [2,1,-1] Output: 0 Explanation: The pivot index is 0. Left sum
 * = 0 (no elements to the left of index 0) Right sum = nums[1] + nums[2] = 1 +
 * -1 = 0
 * 
 * 
 * Good explanation is here: https://www.youtube.com/watch?v=u89i60lYx8U
 * 
 */
public class FindPivotIndex724 {
	// the idea:
	// 1. sum entire array
	// 2. start from left and keep summing left side. When you come to the pivot,
	// just calculate rest sum of the right side. total_sum - sum +
	// "value_of_the_pivot"
	// if left sum == right sum then we done, i.e. found the pivot index.

	public int pivotIndex(int[] nums) {
		int total = 0, leftSum = 0, rightSum = 0;

		for (int inx = 0; inx < nums.length; inx++) {
			total += nums[inx];
		}

		for (int inx = 0; inx < nums.length; inx++) {
			rightSum = total - leftSum - nums[inx];

			if (leftSum == rightSum) {
				return inx;
			} else {
				leftSum += nums[inx];
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		FindPivotIndex724 runner = new FindPivotIndex724();
		int[] nums = { 1,7,3,6,5,6 };
        int result = runner.pivotIndex(nums);
        System.out.println("Pivot:= " + result);
	}

}
