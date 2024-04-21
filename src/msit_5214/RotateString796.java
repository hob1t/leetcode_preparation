package msit_5214;

/**
 * Given two strings s and goal, return true if and only if s can become goal
 * after some number of shifts on s.
 * 
 * A shift on s consists of moving the leftmost character of s to the rightmost
 * position.
 * 
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcde", goal = "cdeab" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "abcde", goal = "abced" Output: false
 * 
 */
public class RotateString796 {
	
    public boolean rotateString(String s, String goal) {
    	for(int i = 0; i < s.length(); i++) {
			if(s.equals(goal)) {
    			return true;
    		} 
			s = rotateLeft(s);
    	}
    	
    	return false;
    }
    
    private String rotateLeft(String orig) {
    	return new String(orig.substring(1, orig.length()) + orig.charAt(0));
    }

	public static void main(String[] args) {
		RotateString796 runner = new RotateString796();
		String s = "abcde", goal = "abced";
		boolean result = runner.rotateString(s, goal);
        System.out.println("Result:= " + result);
	}
}
