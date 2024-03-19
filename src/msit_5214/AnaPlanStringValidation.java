package msit_5214;

import java.util.Stack;

/**
 * Example 1:
 * 
 * 
 * 
 * Input: s = "()" Output: true
 * 
 * Example 2:
 * 
 * 
 * 
 * Input: s = "()[]{}" Output: true
 * 
 * Example 3:
 * 
 * 
 * 
 * Input: s = "(]" Output: false
 * 
 * Example 4:
 * 
 * 
 * 
 * Input: s = "([)]" Output: false
 * 
 * Example 5:
 * 
 * 
 * 
 * Input: s = "{[]}" Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * 
 * s consists of parentheses only '()[]{}'.
 */
public class AnaPlanStringValidation {
	
	public boolean isValid(String input) {
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] inputAsChars = input.toCharArray();
		
		for(char ch : inputAsChars) {
			// check if it is opens 
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}
			// if ii does not opens
			// case 1: close parent. the same kind
			// case 2: is not the same kind
			else {
				// ch - close
				char open = stack.peek();
				if(checkIfParTheSameKind(open, ch) && !stack.empty()) {
					stack.pop();
				}
			}
		}
		
		
		return stack.empty();
	}
	
	boolean checkIfParTheSameKind(char open, char close) {
		if(open == '(' && close == ')') {
			return true;
		} else if(open == '[' && close == ']') {
			return true;
		} else if(open == '{' && close == '}') {
			return true;
		} else {
			return false;
		}
	}
	

	public static void main(String[] args) {
		AnaPlanStringValidation runner = new AnaPlanStringValidation();
		String input = "(]";
		boolean result = runner.isValid(input);
        System.out.println("Result " + result);
	}

}
