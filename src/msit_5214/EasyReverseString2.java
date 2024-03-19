package msit_5214;

/**
 * Given a string s and an integer k, reverse the first k characters for every
 * 2k characters counting from the start of the string.
 * 
 * If there are fewer than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the
 * first k characters and leave the other as original.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 * 
 * Example 2:
 * 
 * Input: s = "abcd", k = 2 Output: "bacd"
 * 
 */
public class EasyReverseString2 {

	public String reverseStr(String s, int k) {
		char[] origAsChars = s.toCharArray();

		for (int i = 0; i < origAsChars.length; i += 2 * k) {
			reverseByIndex(i, i + k - 1, origAsChars);
		}

		return String.valueOf(origAsChars);
	}

	char[] reverseByIndex(int start, int end, char[] origAsChars) {
		char tmp = ' ';

		if (end >= origAsChars.length) {
			return origAsChars;
		}

		while (start <= end) {
			tmp = origAsChars[end];
			origAsChars[end] = origAsChars[start];
			origAsChars[start] = tmp;

			start++;
			end--;
		}

		return origAsChars;
	}

	public static void main(String[] args) {
		EasyReverseString2 runner = new EasyReverseString2();
		//"abcdefg", k = 2 Output: "bacdfeg"
		String result = runner.reverseStr("abcd", 2);
		System.out.println(result);
	}
}
