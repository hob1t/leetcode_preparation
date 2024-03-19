package msit_5214;

import java.util.Stack;

/**
 * 
 * Given two non-negative integers, num1 and num2 represented as string, return
 * the sum of num1 and num2 as a string.
 * 
 * You must solve the problem without using any built-in library for handling
 * large integers (such as BigInteger). You must also not convert the inputs to
 * integers directly.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num1 = "11", num2 = "123" Output: "134"
 * 
 * Example 2:
 * 
 * Input: num1 = "456", num2 = "77" Output: "533"
 * 
 * Example 3:
 * 
 * Input: num1 = "0", num2 = "0" Output: "0"
 * 
 */
public class EasyAddStrings {

	public String addStrings(String num1, String num2) {
		Stack<Integer> holder = new Stack<>();
		if (num1 == null && num2 == null) {
			return "";
		}

		// case when s1.len == s2.len
		// case when one of them less then second. 
		// to take care of second case, add 0s to the smallest string.
		
		StringBuffer sb = new StringBuffer();
        if(compare(num1, num2) < 0) {
			int diff = num2.length() - num1.length();
			for(int i = 0; i < diff; i++) {
				sb.append('0');
			}
			sb.append(num1);
			num1 = sb.toString();
			
		} else {
			int diff = num1.length() - num2.length();
			for(int i = 0; i < diff; i++) {
				sb.append('0');
			}
			sb.append(num2);
			num2 = sb.toString();
		}
		
		System.out.println("First: " + num1 + ", second " + num2);
		
		int carry = 0;
		for (int inx = num1.length() - 1; inx >= 0; inx--) {
			int firstNum = Integer.valueOf(num1.charAt(inx) - '0');
			int secondNum = Integer.valueOf(num2.charAt(inx) - '0');
			

			int sum = firstNum + secondNum + carry;
			System.out.println("sum " + sum);
			
			if (sum <= 9) {
				holder.add(sum);
			} else {
				carry = sum / 10;
				holder.add(sum % 10);
			}
		}

		StringBuffer sbNew = new StringBuffer();

		while (!holder.empty()) {
			sbNew.append(holder.pop());
		}

		return sbNew.toString();
	}
	
	int compare(String num1, String num2) {
		// if 0 they are equals
		// if -1 second larger
		// if +1 first bigger
		return num1.length() - num2.length();
	}

	public static void main(String[] args) {
		EasyAddStrings runner = new EasyAddStrings();
		String f = "0", s = "0";
        String result = runner.addStrings(f, s);
        System.out.println("Result " + result);
	}

}
