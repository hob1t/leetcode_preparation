package msit_5214;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You are given an integer array score of size n, where score[i] is the score
 * of the ith athlete in a competition. All the scores are guaranteed to be
 * unique.
 * 
 * The athletes are placed based on their scores, where the 1st place athlete
 * has the highest score, the 2nd place athlete has the 2nd highest score, and
 * so on. The placement of each athlete determines their rank:
 * 
 * The 1st place athlete's rank is "Gold Medal". The 2nd place athlete's rank is
 * "Silver Medal". The 3rd place athlete's rank is "Bronze Medal". For the 4th
 * place to the nth place athlete, their rank is their placement number (i.e.,
 * the xth place athlete's rank is "x").
 * 
 * Return an array answer of size n where answer[i] is the rank of the ith
 * athlete.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: score = [5,4,3,2,1] Output: ["Gold Medal","Silver Medal","Bronze
 * Medal","4","5"] Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 * 
 * Example 2:
 * 
 * Input: score = [10,3,8,9,4] Output: ["Gold Medal","5","Bronze Medal","Silver
 * Medal","4"] Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 * 
 * 
 */
public class EasyRelativeRanks {

	public String[] findRelativeRanks(int[] score) {
		String[] result = new String[score.length];

		List<Integer> list = Arrays.stream(score).boxed().collect(Collectors.toList());
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int i = 0; i < score.length; i++) {
			result[i] = getPlace(list.indexOf(score[i]) + 1);
		}

		return result;
	}

	public String getPlace(int rank) {
		if (rank == 1) {
			return "Gold Medal";
		} else if (rank == 2) {
			return "Silver Medal";
		} else if (rank == 3) {
			return "Bronze Medal";
		} else {
			return String.valueOf(rank);
		}
	}

	public static void main(String[] args) {
		EasyRelativeRanks runner = new EasyRelativeRanks();
		int[] score = { 10,3,8,9,4 };
		String[] result = runner.findRelativeRanks(score);
		Stream.of(result).forEach(System.out::println);
	}
}
