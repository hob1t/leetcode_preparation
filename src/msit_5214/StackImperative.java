package msit_5214;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class StackImperative {
	private Stack<Integer> stk;

	public StackImperative() {
		stk = new Stack<Integer>();
	}

	public Integer pop() {
		if (!stk.isEmpty()) {
			return stk.pop();
		}
		throw new IllegalArgumentException();
	}

	public void push(Integer num) {
		stk.push(num);
	}

	public boolean isEmpty() {
		return stk.isEmpty();
	}

	public int size() {
		return stk.size();
	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, 4);
		Integer sum = integers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Sum:= " + sum);		
	}
}
