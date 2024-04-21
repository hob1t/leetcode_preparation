package msit_5214;

import java.util.HashMap;
import java.util.Map;


public class UniqueMorseCodeWords804 {
	String[] abc = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
    	int counter = 0;
    	Map<String, Integer> holder = new HashMap<>();
        for(String word : words) {
        	String res = morseWord(word);
        	if(holder.containsKey(res)) {
        		holder.merge(res, 1, Integer::sum);
        	} else {
        		holder.put(res, 1);
        	}
        }
    	
        for(String key : holder.keySet()) {
        	counter = Math.max(counter, holder.get(key));
        }
        
        
    	return counter;
    }
    
    private String morseWord(String word) {
    	StringBuilder sb = new StringBuilder();
    	for(char ch : word.toCharArray()) {
    		int index = ch - 'a';
    		sb.append(abc[index]);
    	}
    	
    	System.out.println(sb.toString());
    	return sb.toString();
    }
	
	
	public static void main(String[] args) {
		UniqueMorseCodeWords804 runner = new UniqueMorseCodeWords804();
		String[] words = {"gin","zen","gig","msg"};
        int result = runner.uniqueMorseRepresentations(words);
        System.out.println("Result:= " + result);
	}
}
