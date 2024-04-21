package msit_5214;

import java.util.ArrayList;
/**
 * In a string s of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z", and "yy".
 * 
 * A group is identified by an interval [start, end], where start and end denote
 * the start and end indices (inclusive) of the group. In the above example,
 * "xxxx" has the interval [3,6].
 * 
 * A group is considered large if it has 3 or more characters.
 * 
 * Return the intervals of every large group sorted in increasing order by start
 * index.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abbxxxxzzy" Output: [[3,6]] Explanation: "xxxx" is the only large
 * group with start index 3 and end index 6.
 * 
 * Example 2:
 * 
 * Input: s = "abc" Output: [] Explanation: We have groups "a", "b", and "c",
 * none of which are large groups.
 * 
 * Example 3:
 * 
 * Input: s = "abcdddeeeeaabbbcd" Output: [[3,5],[6,9],[12,14]] Explanation: The
 * large groups are "ddd", "eeee", and "bbb".
 * 
 */
import java.util.List;


public class PositionsOfLargeGroups830 {
	
    public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();
        // two pointers
        int left = 0, right = 1, counter = 0;
        
        while(left < s.length() && right < s.length()) {
        	if( s.charAt(left) == s.charAt(right)) {
        		counter++;
        		right++;
        	} else {
        		if(counter >= 3) {
        			List<Integer> tmp = new ArrayList<>();
        			tmp.add(left);
        			tmp.add(right - 1);
        			result.add(tmp);
        			counter = 0;
        		}
        		left = right;
        	}
        }

    	return result;
    }
	

	public static void main(String[] args) {
		PositionsOfLargeGroups830 runner = new PositionsOfLargeGroups830();
		String s = "abcdddeeeeaabbbcd";
		List<List<Integer>> result = runner.largeGroupPositions(s);
        System.out.println(result);
	}
}
