package msit_5214;

import java.util.BitSet;

/**
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital, like "Google".
 * 
 * Given a string word, return true if the usage of capitals in it is right.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "USA" Output: true
 * 
 * Example 2:
 * 
 * Input: word = "FlaG" Output: false
 * 
 * LC - 520
 * 
 */
public class EasyDetectCapitalUse {

	public boolean detectCapitalUse(String word) {
		BitSet holder = new BitSet();
		int index = 0;
		
		for (char ch : word.toCharArray()) {

			if (Character.isUpperCase(ch)) {
				holder.set(index, true);
			}
			
			index++;
		}
		// entire word is in upper case
		if (holder.cardinality() == word.length()) {
			return true;
		}

		// only first one is in upper case
		if (holder.get(0) == true && (holder.cardinality() == 1)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		EasyDetectCapitalUse runner = new EasyDetectCapitalUse();
		boolean result = runner.detectCapitalUse("UsA");
		System.out.println("Result " + result);
	}
}
