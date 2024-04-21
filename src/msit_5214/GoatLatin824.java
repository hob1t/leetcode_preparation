package msit_5214;

import java.util.StringJoiner;

/**
 * You are given a string sentence that consist of words separated by spaces.
 * Each word consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.) The rules of Goat Latin are as follows:
 * 
 * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to
 * the end of the word. For example, the word "apple" becomes "applema". If a
 * word begins with a consonant (i.e., not a vowel), remove the first letter and
 * append it to the end, then add "ma". For example, the word "goat" becomes
 * "oatgma". Add one letter 'a' to the end of each word per its word index in
 * the sentence, starting with 1. For example, the first word gets "a" added to
 * the end, the second word gets "aa" added to the end, and so on.
 * 
 * Return the final sentence representing the conversion from sentence to Goat
 * Latin.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: sentence = "I speak Goat Latin" Output: "Imaa peaksmaaa oatGmaaaa
 * atinLmaaaaa"
 * 
 * Example 2:
 * 
 * Input: sentence = "The quick brown fox jumped over the lazy dog" Output:
 * "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
 * hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 * 14-Apr-2024. Good news: finally found a job. After three months of interviewing. 
 * Will continue to solve LC problems, once a day, hopefully.
 * 
 */
public class GoatLatin824 {
	
	private String appendMa(String orig) {
		StringBuilder sb = new StringBuilder(orig);
		sb.append("ma");
		return sb.toString();
	}
	
	private String appendA(String orig, int counter) {
		StringBuilder sb = new StringBuilder(orig);
		
		while(counter-- > 0) {
			sb.append("a");
		}
		
		
		return sb.toString();
	}
	
	private String removeFirstAndAppendAtEnd(String orig) {
		StringBuilder sb = new StringBuilder();
		char first = orig.charAt(0);
		String subOrig = orig.substring(1);
		sb.append(subOrig);
		sb.append(first);
		
		return sb.toString();
	}
	
    public String toGoatLatin(String sentence) {
        // idea:
    	// a | e | i | 0 | u -> "word".aapend("ma")
    	// !vowel            -> "word" -> "ord".append("w").append("ma")
    	// add countable a at the end
    	String[] sequence = sentence.split(" ");
    	StringJoiner sj = new StringJoiner(" ");
    	int aCounter = 0;
    	for(String word : sequence) {
    		char ch = Character.toLowerCase(word.charAt(0)); // first char
    		if(ch == 'a' | ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
    			sj.add(appendA(appendMa(word), ++aCounter));
    		} else {
    			sj.add(appendA( appendMa( removeFirstAndAppendAtEnd(word)), ++aCounter));
    		}
    	}
    	
    	
    	
    	
    	return sj.toString();
    }
	

	public static void main(String[] args) {
		GoatLatin824 runner = new GoatLatin824();
		String sentence = "I speak Goat Latin";
		String result = runner.toGoatLatin(sentence);
		System.out.println(result);

		
		// Imaa peaksmaaa oatGmaaaa atinLmaaaaa
		// Imaa peaksmaaa oatGmaaaa atinLmaaaaa
	}

}
