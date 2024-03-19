package msit_5214;

import java.util.ArrayList;
import java.util.List;


/**
 * We need to follow the rules:
 * 
 *  n open, n close
 *  close < open
 *
 *  {@link https://www.youtube.com/watch?v=s9fokUqJ76A}
 */
public class GenerateParentness {
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    
    
    void backtrack(List<String> array, String current, int open, int close, int max) {
    	// base case
    	if(current.length() == max * 2) { // should be even ( ) == 2
    		array.add(current);
    		return;
    	}
    	
    	if(open < max) { // we can continue to add open parenthnesses 
    		backtrack(array, current + "(", open + 1, close, max);
    	}
    	
    	if(close < open) { // we can add close ) to each open
    		backtrack(array, current + ")", open, close+1, max);
    	}
    }
    
    
    
    
    

	public static void main(String[] args) {
		GenerateParentness generateParent = new GenerateParentness();
		List<String> answer = generateParent.generateParenthesis(3);
		System.out.println(answer);

	}

}
