package msit_5214;

/**
 * 
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetcode" Output: 0
 * 
 * Example 2:
 * 
 * Input: s = "loveleetcode" Output: 2
 * 
 * Example 3:
 * 
 * Input: s = "aabb" Output: -1
 * 
 */
public class EasyFirstUniqueCharInString {

	public int firstUniqChar(String s) {
		int num_letters = 26;
		int[] freq = new int[num_letters];
		int curInx = 0;
		
		for (char ch : s.toCharArray()) {
			curInx = ch - 'a';
			System.out.println("Char is " + ch + ", index " + curInx);
			freq[curInx] += 1;
		}

		// Here is a trick
		// go again the char and check its freq, first found where 1, return this index
		int position = 0;
		for (char ch : s.toCharArray()) {
			curInx = ch - 'a';
			if(freq[curInx] == 1) {
				return position;
			}
			++position;
		}
		return -1;
	}

	public static void main(String[] args) {
		EasyFirstUniqueCharInString runner = new EasyFirstUniqueCharInString();
		String s = "aabb";
		System.out.println(runner.firstUniqChar(s));

	}

}
