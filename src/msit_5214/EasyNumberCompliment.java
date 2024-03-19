package msit_5214;

/**
 * The complement of an integer is the integer you get when you flip all the 0's
 * to 1's and all the 1's to 0's in its binary representation.
 * 
 * For example, The integer 5 is "101" in binary and its complement is "010"
 * which is the integer 2.
 * 
 * Given an integer num, return its complement.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 5 Output: 2 Explanation: The binary representation of 5 is 101
 * (no leading zero bits), and its complement is 010. So you need to output 2.
 * 
 * Example 2:
 * 
 * Input: num = 1 Output: 0 Explanation: The binary representation of 1 is 1 (no
 * leading zero bits), and its complement is 0. So you need to output 0.
 * 
 */
public class EasyNumberCompliment {
	public int findComplement(int num) {
		StringBuffer sb = new StringBuffer();

		while (num > 0) {
			int xor = num % 2;
			sb.append(xor);

			System.out.print(xor + " ");
			num = num >> 1;
		}

		char[] orig = sb.toString().toCharArray();
		for (int i = 0; i < orig.length; i++) {
			if (orig[i] == '1') {
				orig[i] = '0';
			} else {
				orig[i] = '1';
			}
		}

		int result = 0;

		for (int i = orig.length - 1; i >= 0; i--) {
			if (orig[i] == '1') {
				result += Math.pow(2, i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		EasyNumberCompliment runner = new EasyNumberCompliment();
		int num = runner.findComplement(1);
		System.out.println("Compliment " + num);
	}

}
