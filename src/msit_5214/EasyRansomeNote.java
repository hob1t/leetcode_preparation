package msit_5214;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b" Output: false
 * 
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab" Output: false
 * 
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab" Output: true
 *
 * 
 */
public class EasyRansomeNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magazineMap = getCounterMap(magazine);
		Map<Character, Integer> ransomeNoteMap = getCounterMap(ransomNote);

		for (Character ch : ransomeNoteMap.keySet()) {
			if (!magazineMap.containsKey(ch) || magazineMap.get(ch) < ransomeNoteMap.get(ch)) {
				return false;
			}
		}
		return true;

	}

	Map<Character, Integer> getCounterMap(String orig) {
		Map<Character, Integer> holder = new HashMap<>();

		for (char ch : orig.toCharArray()) {
			if (!holder.containsKey(ch)) {
				holder.put(ch, 1);
			} else {
				holder.merge(ch, 1, Integer::sum);
			}
		}

		return holder;
	}

	public static void main(String[] args) {
		EasyRansomeNote runner = new EasyRansomeNote();
		String ransomNote = "aa", magazine = "aab";
		System.out.println(runner.canConstruct(ransomNote, magazine));

	}

}
