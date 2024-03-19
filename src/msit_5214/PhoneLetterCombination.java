package msit_5214;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter 
 * combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.
 * 
 *
 */
public class PhoneLetterCombination {
	Set<String> localStore = new HashSet<>();
	StringBuilder sb = new StringBuilder();
	Map<Integer, String> digitToChars = new HashMap<>();
	List<String> result = new ArrayList<>();

    public void printPairs(char[] array, int firstIndex, int secondIndex) {
    	if((secondIndex > array.length -1) || (firstIndex > array.length -1)) {
    		return;
    	} else {
    		printPairs(array, firstIndex, secondIndex+1);
    		String toCheck = new StringBuilder().append(array[firstIndex]).append(array[secondIndex]).toString();
    		if(array[firstIndex] != array[secondIndex] && !localStore.contains(toCheck)) {
    		    System.out.println(array[firstIndex] + " " +  array[secondIndex]);
    		    localStore.add(toCheck);
    		}
    		printPairs(array, firstIndex+1, secondIndex);
    	}
    }
    
    
    public List<String> letterCombinations(String digits) {
    	map(digitToChars);
        // switch which maps numbers to characters/strings
        // given character array generate all possible pairs
        // save these pairs into list and return
    	backtrack(0, "", digits);

    	return result;
    }
    
    
    void backtrack(int index, String currentString, String digits) {
    	if(currentString.length() == digits.length()) {
    		result.add(currentString);
    		return;
    	}
    	
    	for(char c : digitToChars.get(digits.toCharArray()[index] - '0').toCharArray()) {
    		backtrack(index + 1, currentString + c, digits);// begins with empty string and them concats chars
    	}
    }
    
    Map<Integer, String> map(Map<Integer, String> digitToChars) {
    	digitToChars.put(2, "abc");
    	digitToChars.put(3, "def");
    	digitToChars.put(4, "ghi");
    	digitToChars.put(5, "jkl");
    	digitToChars.put(6, "mno");
    	digitToChars.put(7, "qprs");
    	digitToChars.put(8, "tuv");
    	digitToChars.put(9, "wxyz");
    	
    	return digitToChars;
    }
    
    
	
	
	public static void main(String[] args) {
		String inout = "abcdef";
		PhoneLetterCombination phoneLetter = new PhoneLetterCombination();
		//phoneLetter.printPairs(inout.toCharArray(), 0, 1);
		
		List<String> res = phoneLetter.letterCombinations("58");
		System.out.println(res);
	}

}
