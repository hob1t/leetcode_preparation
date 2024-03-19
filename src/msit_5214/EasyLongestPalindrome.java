package msit_5214;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string s which consists of lowercase or uppercase letters, return the
 * length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abccccdd" Output: 7 Explanation: One longest palindrome that can
 * be built is "dccaccd", whose length is 7.
 * 
 * Example 2:
 * 
 * Input: s = "a" Output: 1 Explanation: The longest palindrome that can be
 * built is "a", whose length is 1.
 * 
 * 
 */
public class EasyLongestPalindrome {
	
	public int longestPalindrome(String s) {
		if(s.length() <= 1) {
			return 1;
		}

		Map<Character, Integer> holder = new HashMap<>();
		// now go over s.toCharArray and count the chars
		for(char ch : s.toCharArray()) {
			if(!holder.containsKey(ch)) {
				holder.put(ch, 1);
			} else {
				holder.merge(ch, 1, Integer::sum);
			}
		}
		
		int longest = 0;
		int lonlyOne = 0;
		
		for(Character ch : holder.keySet()) {
			
			if(holder.get(ch) % 2 == 0) {
				longest += holder.get(ch);
			}
			
			if(holder.get(ch) == 1) {
				lonlyOne++;
			}
		}
		
		if(lonlyOne > 0 && longest > 0)
			return 1 + longest;
		
		return -1;
	}

	public static void main(String[] args) {
		EasyLongestPalindrome runner = new EasyLongestPalindrome();
		String s = "abccccdd";
		System.out.println("Longest palindrome that can we built is " + runner.longestPalindrome(s));
	}

}
