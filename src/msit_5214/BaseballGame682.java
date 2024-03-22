package msit_5214;

import java.util.Stack;

/**
 * 
 * You are keeping the scores for a baseball game with strange rules. At the
 * beginning of the game, you start with an empty record.
 * 
 * You are given a list of strings operations, where operations[i] is the ith
 * operation you must apply to the record and is one of the following:
 * 
 * An integer x. Record a new score of x. '+'. Record a new score that is the
 * sum of the previous two scores. 'D'. Record a new score that is the double of
 * the previous score. 'C'. Invalidate the previous score, removing it from the
 * record.
 * 
 * Return the sum of all the scores on the record after applying all the
 * operations.
 * 
 * The test cases are generated such that the answer and all intermediate
 * calculations fit in a 32-bit integer and that all operations are valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ops = ["5","2","C","D","+"] Output: 30 Explanation: "5" - Add 5 to the
 * record, record is now [5]. "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5]. "D" - Add
 * 2 * 5 = 10 to the record, record is now [5, 10]. "+" - Add 5 + 10 = 15 to the
 * record, record is now [5, 10, 15]. The total sum is 5 + 10 + 15 = 30.
 * 
 * Example 2:
 * 
 * Input: ops = ["5","-2","4","C","D","9","+","+"] Output: 27 Explanation: "5" -
 * Add 5 to the record, record is now [5]. "-2" - Add -2 to the record, record
 * is now [5, -2]. "4" - Add 4 to the record, record is now [5, -2, 4]. "C" -
 * Invalidate and remove the previous score, record is now [5, -2]. "D" - Add 2
 * * -2 = -4 to the record, record is now [5, -2, -4]. "9" - Add 9 to the
 * record, record is now [5, -2, -4, 9]. "+" - Add -4 + 9 = 5 to the record,
 * record is now [5, -2, -4, 9, 5]. "+" - Add 9 + 5 = 14 to the record, record
 * is now [5, -2, -4, 9, 5, 14]. The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
 * 
 * Example 3:
 * 
 * Input: ops = ["1","C"] Output: 0 Explanation: "1" - Add 1 to the record,
 * record is now [1]. "C" - Invalidate and remove the previous score, record is
 * now []. Since the record is empty, the total sum is 0.
 * 
 */
public class BaseballGame682 {
    public int calPoints(String[] operations) {
        Stack<Integer> records = new Stack<>();
        int result = 0;
    	
        // if digit - add a number to the record, i.e. results.peek() if not null, num + peek() and then push into the stack
        // if C - invalidate, if stack is not empty, stack pop
        // if D - stack.peek() * 2, then stack.push()
        // if '+' - last = stack.pop(), first = stack.pop() if not empty, sum = last + first; then stack.push(first); stack.push(last); 
        // stack.push(sum);
        // if stack is empty - return 0;
        
        
        for(String elmnt : operations) {
        	Character el = elmnt.charAt(0);
        	System.out.println("Char:= " + el);
        	
        	if(Character.isDigit(el)) {
        		records.push(Integer.valueOf(elmnt));
        	} else if(el == 'C' && !records.isEmpty()) {
        		records.pop();
        	} else if(el == 'D' && !records.isEmpty()) {
        		int doubled = records.peek();
        		records.push(2 * doubled);
        	} else if(el == '+' && !records.isEmpty()) {
        		int last = records.pop();
        		if(!records.isEmpty()) {
        			int sum = records.peek() + last;
        			records.push(last);
        			records.push(sum);
        		}
        	} else if(el == '-') {
        		records.push(Integer.valueOf(elmnt));
        	}
        }
        
        if(records.isEmpty()) {
        	return 0;
        } else {
        	while(!records.isEmpty()) {
        		result += records.pop();
        	}
        }
        
        return result;
    }
    
    
    

	public static void main(String[] args) {
		BaseballGame682 runner = new BaseballGame682();
		String[] operations = {"1","C"};
		int result = runner.calPoints(operations);
		System.out.println("Result:= " + result);
	}
}
