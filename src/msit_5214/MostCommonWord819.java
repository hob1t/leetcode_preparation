package msit_5214;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string paragraph and a string array of the banned words banned,
 * return the most frequent word that is not banned. It is guaranteed there is
 * at least one word that is not banned, and that the answer is unique.
 * 
 * The words in paragraph are case-insensitive and the answer should be returned
 * in lowercase.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.",
 * banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times, but it is
 * a banned word. "ball" occurs twice (and no other word does), so it is the
 * most frequent non-banned word in the paragraph. Note that words in the
 * paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned.
 * 
 * Example 2:
 * 
 * Input: paragraph = "a.", banned = [] Output: "a"
 * 
 */
public class MostCommonWord819 {

	public String mostCommonWord(String paragraph, String[] banned) {
		// create HashSet from banned
		Set<String> banHolder = new HashSet<>(Arrays.asList(banned));
		String[] input = paragraph.replace(".", "").replace(",", "").toLowerCase().split(" ");
		// clear paragraph removing . , and revert to lower case
		// then split by ' '
		// create HashMap and save words and its counts that are not in set
		//
		Map<String, Integer> holder = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (String word : input) {
			if (!banHolder.contains(word)) {
				if (!holder.containsKey(word)) {
					holder.put(word, 1);
					if(input.length == 1) {
						max = 1;
					}
				} else {
					holder.merge(word, 1, Integer::sum);
					max = Math.max(max, holder.get(word));
				}
			}
		}

		for (String key : holder.keySet()) {
			if (holder.get(key) == max) {
				return key;
			}
		}

		return "";
	}

	public static void main(String[] args) {
		MostCommonWord819 runner = new MostCommonWord819();
		String paragraph = "a.";
		String[] banned = {};
        String result = runner.mostCommonWord(paragraph, banned);
        System.out.println("Result:= " + result);
	}
}
