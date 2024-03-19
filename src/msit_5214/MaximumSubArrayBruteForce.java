package msit_5214;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Translation to Java from:
 * 
 * 
 * 
 * @author olegtikhonov
 *
 */
public class MaximumSubArrayBruteForce {
	public static final int NUM_ITERATIONS = 100000;

	public static List<Integer> findMaxSubarayBruteForce(int[] array, int low, int high) {
		List<Integer> result = new ArrayList<>(3);

		int left = low, right = high, tmpSum;
		int sum = Integer.MIN_VALUE;

		for (int inx = 0; inx < array.length; inx++) {
			tmpSum = 0;
			for (int jnx = inx; jnx < high; jnx++) {
				tmpSum = tmpSum + array[jnx];
				if (tmpSum > sum) {
					sum = tmpSum;
					left = inx;
					right = jnx;
				}
			}
		}

		result.add(left);
		result.add(right);
		result.add(sum);

		return result;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	static int maxCrossingSum(int arr[], int low, int mid, int high) {

		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if (sum > leftSum)
				leftSum = sum;
		}

		sum = 0;

		for (int i = mid; i <= high; i++) {
			sum = sum + arr[i];
			if (sum > rightSum)
				rightSum = sum;
		}

		return Math.max(leftSum + rightSum - arr[mid], Math.max(leftSum, rightSum));
	}

	public static int findMaxSubarrayRecursive(int[] array, int low, int high) {
		if (low > high)
			return Integer.MIN_VALUE;

		if (low == high) {
			return array[low];
		}

		int mid = (low + high) / 2;
		// possible three options: left, right and crossing
		int left = findMaxSubarrayRecursive(array, low, mid - 1);
		int right = findMaxSubarrayRecursive(array, mid + 1, high);
		int cross = maxCrossingSum(array, low, mid, high);
		return Math.max(Math.max(left, right), cross);
	}

	public static void main(String[] args) {
		System.out.println("Size            BruteForce Time             Recursive Time");
		System.out.println("==========================================================");
		for (int inx = 2; inx <= 100; inx++) {
			int[] array = new Random().ints(inx, -100, 100).toArray();
			/*
			 * MaximumSubArrayBruteForce.printArray(array); List<Integer> result =
			 * MaximumSubArrayBruteForce.findMaxSubarayBruteForce(array, 0, array.length);
			 * 
			 * int maxSumOfRec = MaximumSubArrayBruteForce.findMaxSubarrayRecursive(array,
			 * 0, array.length - 1); System.out.println(result + " <==> " + maxSumOfRec);
			 */

			long startTime = System.currentTimeMillis();
			long bfEndTime = 0, rcTime = 0;

			for (int jnx = 0; jnx < NUM_ITERATIONS; jnx++) {
				MaximumSubArrayBruteForce.findMaxSubarayBruteForce(array, 0, array.length - 1);
				bfEndTime = System.currentTimeMillis() - startTime;
			}

			for (int jnx = 0; jnx < NUM_ITERATIONS; jnx++) {
				MaximumSubArrayBruteForce.findMaxSubarrayRecursive(array, 0, array.length - 1);

				rcTime = System.currentTimeMillis() - startTime;
			}

			System.out.println("input size:=" + inx + " bf_time:=" + bfEndTime + " rc_time:=" + rcTime);

			if (bfEndTime > rcTime) {
				System.out.println("Cross over point =" + inx);
				System.exit(inx);
			}

		}
	}
}
