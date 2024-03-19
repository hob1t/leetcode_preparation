package msit_5214;


/**
 * 
 * Given an array of strings wordsDict and two different strings that already
 * exist in the array word1 and word2, return the shortest distance between
 * these two words in the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1
 * = "coding", word2 = "practice" Output: 3
 * 
 * Example 2:
 * 
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1
 * = "makes", word2 = "coding" Output: 1
 *
 * 
 */
public class EasyShortestWordDistance {
	
	public int getShortestWordDistance(String[] wordsDict, String firstWord, String secondWord) {
		int firstIndex = getIndex(wordsDict, firstWord);
		int secondIndex = getIndex(wordsDict, secondWord);
		
		if(firstIndex >=0 && secondIndex >= 0) {
			return Math.abs(firstIndex - secondIndex);
		}
		
		return 0;
	}
	
	public int anotherShortestWordDistance(String[] wordsDict, String firstWord, String secondWord) {
		int firstIndex = -1, secondIndex = -1, min = Integer.MAX_VALUE;
		
		for(int inx = 0; inx < wordsDict.length; inx++) {
			if(wordsDict[inx].equals(firstWord)) {
			    firstIndex = inx;	
			}
			
			if(wordsDict[inx].equals(secondWord)) {
			    secondIndex = inx;	
			}
			
			if(firstIndex != -1 && secondIndex != -1) {
				min = Math.min(min, Math.abs(firstIndex - secondIndex));
			}	
		}
		
		return min;
	}
	
	public int getIndex(String[] wordsDict, String word) {
		for(int inx = 0; inx < wordsDict.length; inx++) {
			if(wordsDict[inx].equals(word)) {
				return inx;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		EasyShortestWordDistance runner = new EasyShortestWordDistance();
		String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
		String firstWord = "makes";
		String secondWord = "coding";
		
		int result = runner.anotherShortestWordDistance(wordDict, firstWord, secondWord);
        System.out.println("Result:= " + result);
	}
}
