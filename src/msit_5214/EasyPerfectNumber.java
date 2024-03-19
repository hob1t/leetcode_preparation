package msit_5214;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A perfect number is a positive integer that is equal to the sum of its
 * positive divisors, excluding the number itself. A divisor of an integer x is
 * an integer that can divide x evenly.
 * 
 * Given an integer n, return true if n is a perfect number, otherwise return
 * false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 28 Output: true Explanation: 28 = 1 + 2 + 4 + 7 + 14 1, 2, 4, 7,
 * and 14 are all divisors of 28.
 * 
 * Example 2:
 * 
 * Input: num = 7 Output: false
 * 
 */
public class EasyPerfectNumber {

	public boolean checkPerfectNumber(int num) {
		List<Integer> holder = new ArrayList<>();

		// find all divisors
		for(int i = 1; i <= num / 2; i++) {
			if(num % i == 0) {
				holder.add(i);
			}
		}
		
		int result = holder.stream().mapToInt(el -> el).sum();
		System.out.println("Perfect number " + result);

		return (result == num);
	}

	public static void main(String[] args) {
		EasyPerfectNumber runner = new EasyPerfectNumber();
		runner.checkPerfectNumber(60);

	}

}
