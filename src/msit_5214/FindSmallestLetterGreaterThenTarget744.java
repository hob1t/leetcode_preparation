package msit_5214;

/**
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: letters = ["c","f","j"], target = "a" Output: "c" Explanation: The
 * smallest character that is lexicographically greater than 'a' in letters is
 * 'c'.
 * 
 * Example 2:
 * 
 * Input: letters = ["c","f","j"], target = "c" Output: "f" Explanation: The
 * smallest character that is lexicographically greater than 'c' in letters is
 * 'f'.
 * 
 * Example 3:
 * 
 * Input: letters = ["x","x","y","y"], target = "z" Output: "x" Explanation:
 * There are no characters in letters that is lexicographically greater than 'z'
 * so we return letters[0].
 * 
 */
public class FindSmallestLetterGreaterThenTarget744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] holder = new int[26];
        for(int i = 0; i < letters.length; i++) {
            int index = letters[i] - 'a';
            holder[index] = 1;
        }

        int targetIndex = target - 'a';
        // [ 0 0 1 0 0 1 1 ]
        
        boolean isFound = false;
        while(!isFound && (targetIndex + 1) < holder.length) {
        	if(holder[targetIndex + 1] == 1) {
        		isFound = true;
        	}
        	targetIndex++;
        }
        
        if(isFound == false && targetIndex == 25) {
        	return letters[0];
        }
        
        return (char) (targetIndex + 'a');
    }

	public static void main(String[] args) {
		FindSmallestLetterGreaterThenTarget744 runner = new FindSmallestLetterGreaterThenTarget744();
		char[] letters = {'c','f','j', 'y'}; 
		char result = runner.nextGreatestLetter(letters, 'c');
        System.out.print("Char:= " + result);
	}
}
