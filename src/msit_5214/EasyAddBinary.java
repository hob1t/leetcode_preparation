package msit_5214;

import java.util.Stack;

/**
 * 
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1" Output: "100"
 * 
 * Example 2:
 * 
 * Input: a = "1010", b = "1011" Output: "10101"
 *
 * 
 */
public class EasyAddBinary {
    public String addBinary(String a, String b) {
        // trick find a smallest String, for example b
        // add 0 at the beginning, if b was 1 and we need len to be 2
        // then 0 1
        //      1 1
        // when they are equals,
        // do operations
    	int maxLen = Math.max(a.length(), b.length());
    	a = addLeadingZero(a, maxLen);
    	b = addLeadingZero(b, maxLen);

    	int curInx = b.length() - 1;
    	StringBuffer sb = new StringBuffer();
    	Stack<Character> tmp = new Stack<>();
    	int was_carry = 0;
    	
    	while(curInx >= 0) {
        	if(a.charAt(curInx) == '0' && b.charAt(curInx) == '0') {
        		if(was_carry == 1) {
        			tmp.add('1');
        			was_carry = 0;
        		} else {
        			tmp.add('0');
        		}
        		
        	} else if (a.charAt(curInx) == '0' && b.charAt(curInx) == '1' ) {
        		if(was_carry == 1) {
        			tmp.add('0');
        		} else {
        			tmp.add('1');
        		}
        		
        	} else if (a.charAt(curInx) == '1' && b.charAt(curInx) == '0') {
        		if(was_carry == 1) {
        			tmp.add('0');
        		} else {
        			tmp.add('1');
        		}
        		
        	} else { // 1 1
        		// carry
        		if(was_carry == 1) {
        			tmp.add('1');
        		} else {
        			tmp.add('0');
        		}
        		
        		was_carry = 1;
        	}
        	--curInx;
    	}
    	
    	if(was_carry == 1) {
    		tmp.add('1');
    	}
    	
    	while(!tmp.isEmpty()) {
    		sb.append(tmp.pop());
    	}
    	
    	System.out.print("result:=" + sb.toString());
        return sb.toString();
    }
    
    public String addLeadingZero(String str, int len) {
    	StringBuffer sb = new StringBuffer();
    	int diff = len - str.length();
    	
    	while(diff-- > 0) {
    		sb.append('0');
    	}
    	
    	sb.append(str);
    	
    	return sb.toString();
    }

	public static void main(String[] args) {
		EasyAddBinary easyAddBinary = new EasyAddBinary();
		easyAddBinary.addBinary("1010", "1011");
	}
}
