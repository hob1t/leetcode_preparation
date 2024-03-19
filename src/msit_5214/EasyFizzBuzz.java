package msit_5214;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * 
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5. answer[i] == "Fizz" if
 * i is divisible by 3. answer[i] == "Buzz" if i is divisible by 5. answer[i] ==
 * i (as a string) if none of the above conditions are true.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: ["1","2","Fizz"]
 * 
 * Example 2:
 * 
 * Input: n = 5 Output: ["1","2","Fizz","4","Buzz"]
 * 
 * Example 3:
 * 
 * Input: n = 15 Output:
 * ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * 
 */
public class EasyFizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int inx = 1; inx <= n; inx++) {
			if ((inx % 3) == 0 && (inx % 5) == 0) {
				result.add("FizzBuzz");
			} else if ((inx % 3) == 0) {
				result.add("Fizz");
			} else if ((inx % 5) == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(inx));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		EasyFizzBuzz runner = new EasyFizzBuzz();
        
		int n = 15;
        
		List<String> res = runner.fizzBuzz(n);
        
        res.forEach(System.out::println);
	}

}
