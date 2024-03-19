package msit_5214;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of strings words, return true if it forms a valid word square.
 * 
 * A sequence of strings forms a valid word square if the kth row and column
 * read the same string, where 0 <= k < max(numRows, numColumns).
 *
 */
public class EasyValidWordSquare {
	
	public boolean validWordSquare(List<String> words) {
		// it is a matrix with nxn. Make equal lens of words
		// create char[][] matrix
		// then go through i = j, take such a String and check if it a polindrome
		// they should be polindrome
		words = fixWords(words);
		
		int i = 0, j = 0;
		char[][] arr = new char[words.get(0).length()][words.get(0).length()];
		
		for(String word : words) {
			j = 0;
			char[] aWord = word.toCharArray();
			for(int inx = 0; inx < aWord.length; inx++) {
			    arr[i][j++] = aWord[inx];
			}
			i++;
		}
		
		// now create char[] and check if polindrome
		i = 0; j = 0;
		for(int inx = 0; inx < arr[0].length; inx++) {
			char[] toBecheck = new char[inx+1];
			for(i = inx; i >= 0; i--) {
				toBecheck[j] = arr[i][i];
			}
			if(isPalindrome(toBecheck)) {
				System.out.println(String.valueOf(toBecheck) + " is polindrome");
			}
		}
		
		
		return false;
	}
	
	boolean isPalindrome(char[] array) {
		if(array.length == 1) {
			return true;
		}
		int left = 0, right = array.length - 1;
		
		while(left <= right) {
			if(array[left] != array[right]) {
				return false;
			}
			right--;
			left++;
		}
		return true;
	}
	
	List<String> fixWords(List<String> words) {
		int max = 0;

		for(String word : words) {
			max = Math.max(max, word.length());
		}
		
		int index = 0;
		
		for(String word : words) {
			if(word.length() < max) {
				int diff = max - word.length();
				StringBuffer sb = new StringBuffer();
				sb.append(word);
				
				for(int i = 0; i < diff; i++) {
					sb.append('0');
				}
				index = words.indexOf(word);
				words.set(index, sb.toString());
			}
		}
		
		return words;
	}

	public static void main(String[] args) {
		EasyValidWordSquare runner = new EasyValidWordSquare();
		List<String> words = new ArrayList<>();//{,,,};
		words.add("abcd");
		words.add("bnrt");
		words.add("crm");
		words.add("dt");
		runner.validWordSquare(words);

	}

}
