package msit_5214;

import java.util.BitSet;

/**
 * Given a string s, return true if a permutation of the string could form a
 * palindrome and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "code" Output: false
 * 
 * Example 2:
 * 
 * Input: s = "aab" Output: true
 * 
 * Example 3:
 * 
 * Input: s = "carerac" Output: true
 * 
 */
public class EasyPalindromePermutation {
	// Solution is based on property of palindrome, at most one character count can be odd
	// and then we will use BitSet flip on/off and cardinality 

	public boolean canPermutePalindrome(String s) {
		BitSet bs = new BitSet(256); // num of ASCII
		for(char c : s.toCharArray()) {
			bs.flip(c);
		}
		
		return bs.cardinality() <= 1;
	}
	
	public static void main(String[] args) {
		EasyPalindromePermutation runner = new EasyPalindromePermutation();
		System.out.println(runner.canPermutePalindrome("code"));
	}

}
