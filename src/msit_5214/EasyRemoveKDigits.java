package msit_5214;

/**
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
 * and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
 * the number and it is left with nothing which is 0.
 * 
 */
public class EasyRemoveKDigits {

	public String removeKdigits(String num, int k) {
		// idea - go over all digits and check each parameter.
		if(num.length() < k) {
			return "-1";
		}
		
		if(num.length() == k) {
			return "0";
		}
		
		int min = Integer.valueOf(num.substring(k));
		
		for(int i = 1; i < num.length(); i++) {
			if((i + k) <= num.length()) {
				String firstInterval = num.substring(0, i);
				String secondInterval = num.substring(i + k);
				int newNum = Integer.valueOf(firstInterval  + secondInterval);
				
				min = Math.min(min, newNum);
			}
		}
		
		return String.valueOf(min);

	}

	public static void main(String[] args) {
		EasyRemoveKDigits runner = new EasyRemoveKDigits();
		String num = "10200"; 
		int k = 1;
		String result = runner.removeKdigits(num, k);
        System.out.println("Result " + result);
	}

}
