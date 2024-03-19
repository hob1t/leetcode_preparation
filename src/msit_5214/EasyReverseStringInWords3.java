package msit_5214;

import java.util.StringJoiner;

/**
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL
 * tsetnoc"
 * 
 * Example 2:
 * 
 * Input: s = "Mr Ding" Output: "rM gniD"
 * 
 */
public class EasyReverseStringInWords3 {

	public String reverseWords(String s) {
		String[] words = s.split(" ");
		StringJoiner sj = new StringJoiner(" ");

		for (String aWord : words) {
			StringBuilder sb = new StringBuilder(aWord);
			sb.reverse();
			sj.add(sb.toString());
		}

		return sj.toString();

	}

	public static void main(String[] args) {
		EasyReverseStringInWords3 runner = new EasyReverseStringInWords3();
		String sentense = runner.reverseWords("Mr Ding");
		System.out.println("Reversed str: " + sentense);
	}
}
