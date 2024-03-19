package msit_5214;

/**
 * 
 * Given an integer num, repeatedly add all its digits until the result has only
 * one digit, and return it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 38 Output: 2 Explanation: The process is 38 --> 3 + 8 --> 11 11
 * --> 1 + 1 --> 2 Since 2 has only one digit, return it.
 * 
 * Example 2:
 * 
 * Input: num = 0 Output: 0
 *
 */
public class EasyAddDigits {
	public boolean is_more_than_one_digit(int num) {
		return (num > 9);
	}

	public int addDigits(int num) {
		while(is_more_than_one_digit(num)) {
			int rem = num % 10;
			int tem = num / 10;
			System.out.println(rem + ", " + tem);
			num = tem + rem;
		}
		return num;
	}

	public static void main(String[] args) {
		EasyAddDigits runner = new EasyAddDigits();
		int result = runner.addDigits(0);
        System.out.println("result:= " + result);
	}
}
