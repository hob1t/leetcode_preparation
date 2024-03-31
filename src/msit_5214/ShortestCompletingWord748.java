package msit_5214;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a string licensePlate and an array of strings words, find the shortest
 * completing word in words.
 * 
 * A completing word is a word that contains all the letters in licensePlate.
 * Ignore numbers and spaces in licensePlate, and treat letters as case
 * insensitive. If a letter appears more than once in licensePlate, then it must
 * appear in the word the same number of times or more.
 * 
 * For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b'
 * (ignoring case), and 'c' twice. Possible completing words are "abccdef",
 * "caaacab", and "cbca".
 * 
 * Return the shortest completing word in words. It is guaranteed an answer
 * exists. If there are multiple shortest completing words, return the first one
 * that occurs in words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
 * Output: "steps" Explanation: licensePlate contains letters 's', 'p', 's'
 * (ignoring case), and 't'. "step" contains 't' and 'p', but only contains 1
 * 's'. "steps" contains 't', 'p', and both 's' characters. "stripe" is missing
 * an 's'. "stepple" is missing an 's'. Since "steps" is the only word
 * containing all the letters, that is the answer.
 * 
 * Example 2:
 * 
 * Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
 * Output: "pest" Explanation: licensePlate only contains the letter 's'. All
 * the words contain 's', but among these "pest", "stew", and "show" are
 * shortest. The answer is "pest" because it is the word that appears earliest
 * of the 3.
 *
 * 
 */
public class ShortestCompletingWord748 {

	public boolean isComplete(String word, int[] frequency) {
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (frequency[index] > 0) {
				frequency[index]--;
			}
		}

		int sum = 0;
		for (int i = 0; i < frequency.length; i++) {
			sum += frequency[i];
		}

		return (sum == 0) ? true : false;
	}

	public String shortestCompletingWord(String licensePlate, String[] words) {
		Set<String> holder = new HashSet<>();
		// idea
		// 1. parse licensePlate and create array of result, where index is char
		// increase by one if you have met the char, 0 otherwise
		int[] letters = new int[26];
		licensePlate = licensePlate.replace(" ", "").toLowerCase();
		for (char ch : licensePlate.toCharArray()) {
			if (!Character.isDigit(ch)) {
				int index = ch - 'a';
				letters[index]++;
			}

		}

		// 2. Go over all words and
		// over each char in the word, decrease counter, if all
		for (String word : words) {
			int[] pizdetz = letters.clone();
			if (isComplete(word, pizdetz) == true) {
				if(holder.size() > 0) {
					String local = holder.stream().findFirst().get();
					if(word.length() < local.length()) {
						holder.clear();
						holder.add(word);
					}
				}
				holder.add(word);
			}
		}

		// 3. if local array contains all zeroes, set this word in to set
		// otherwise skip, take another word

		return (holder.size() > 0) ? holder.stream().findFirst().get() : "";
	}

	public static void main(String[] args) {
		ShortestCompletingWord748 runner = new ShortestCompletingWord748();

		String licensePlate = "1s3 PSt";
		String[] words = { "step","steps","stripe","stepple" };

		String result = runner.shortestCompletingWord(licensePlate, words);
		System.out.println(result);
	}

}
