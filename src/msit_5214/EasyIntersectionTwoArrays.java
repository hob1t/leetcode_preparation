package msit_5214;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return
 * the result in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2]
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Explanation: [4,9]
 * is also accepted.
 *
 * 
 */
public class EasyIntersectionTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> holder = new HashSet<>();

		for (int inx = 0; inx < nums1.length; inx++) {
			holder.add(nums1[inx]);
		}

		for (int inx = 0; inx < nums2.length; inx++) {
			if (holder.contains(nums2[inx])) {
				if(!result.contains(nums2[inx]))
				result.add(nums2[inx]);
			}
		}

		// O(N^2)
		// can we do better?
		// O(nlogn) sort and binary search
		// HashSet
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		EasyIntersectionTwoArrays runner = new EasyIntersectionTwoArrays();
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] res = runner.intersection(nums1, nums2);
        IntStream.of(res).forEach(System.out::println);
	}

}
