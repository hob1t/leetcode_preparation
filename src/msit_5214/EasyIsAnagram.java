package msit_5214;

/**
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 *
 * 
 */
public class EasyIsAnagram {
    private final static int NUM_ABC = 26;
	public boolean isAnagram(String s, String t) {
		// define array of chars
		// increment and then check second with the array
		int[] alefbet = new int[NUM_ABC];
		
		if(s.length() != t.length()) {
			return false;
		}
		
		for(char ch : s.toCharArray()) {
			alefbet[ch - 'a'] += 1;
		}
		
		for(char ch : t.toCharArray()) {
			alefbet[ch - 'a'] -= 1;
		}
		
		for(int i = 0; i < alefbet.length; i++) {
			if(alefbet[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		EasyIsAnagram runner = new EasyIsAnagram();
		String s = "rat", t = "car";
		boolean result = runner.isAnagram(s, t);
        System.out.println("Result " + result);
	}

}
