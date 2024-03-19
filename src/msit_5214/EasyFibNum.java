package msit_5214;

import java.util.HashMap;
import java.util.Map;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * Given n, calculate F(n).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 1 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * Example 2:
 * 
 * Input: n = 3 Output: 2 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * Example 3:
 * 
 * Input: n = 4 Output: 3 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * LC - 509
 * 
 */
public class EasyFibNum {
	public int fib(int n) {
		Map<Integer, Integer> holder = new HashMap<>();
		return fibMemo(n, holder);
	}

	int fibMemo(int num, Map<Integer, Integer> holder) {
		if (num == 0 || num == 1) {
			return num;
		}

		if (holder.get(num) != null) {
			return holder.get(num);
			
		} else {
			int result = fibMemo(num - 1, holder) + fibMemo(num - 2, holder);
			holder.put(num, result);
			return result;
		}
	}

	public static void main(String[] args) {
		EasyFibNum runner = new EasyFibNum();
		int result = runner.fib(10);
		System.out.println("Num:= " + result);
	}

}
