package msit_5214;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abab" Output: true Explanation: It is the substring "ab" twice.
 * 
 * Example 2:
 * 
 * Input: s = "aba" Output: false
 * 
 * Example 3:
 * 
 * Input: s = "abcabcabcabc" Output: true Explanation: It is the substring "abc"
 * four times or the substring "abcabc" twice.
 *
 * 
 */
public class EasyRepeatedSubStringPattern {

	public boolean repeatedSubstringPattern(String s) {
		Map<Character, Integer> holder = new HashMap<>();
		
		for(char ch : s.toCharArray()) {
			if(!holder.containsKey(ch)) {
				holder.put(ch, 1);
			} else {
				holder.merge(ch, 1, Integer::sum);
			}
		}
		
		Set<Integer> setOf = new HashSet<>();
		for(Character ch : holder.keySet()) {
			setOf.add(holder.get(ch));
		}

		return (setOf.size() > 1) ? false : true;
	}

	public static void main(String[] args) {
		EasyRepeatedSubStringPattern runner = new EasyRepeatedSubStringPattern();
		System.out.println(runner.repeatedSubstringPattern("abcabcabcabc"));
	}
}
