package msit_5214;

/**
 * 
 * Example 1:
 * 
 * Input: digits = [1,2,3] Output: [1,2,4] Explanation: The array represents the
 * integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should
 * be [1,2,4].
 * 
 * Example 2:
 * 
 * Input: digits = [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents
 * the integer 4321. Incrementing by one gives 4321 + 1 = 4322. Thus, the result
 * should be [4,3,2,2].
 * 
 */
public class EasyPlusOne {

	public int[] plusOne(int[] digits) {
		int was_carry = 0;
		boolean isValid = true;
		int curInx = digits.length - 1;

		while (curInx >= 0 && isValid) {
			if ((digits[curInx] + 1 + was_carry) > 9) {
				digits[curInx] = ((digits[curInx] + 1 + was_carry)) % 10;
				was_carry = 1;
			} else {
				was_carry = 0;
				digits[curInx] = digits[curInx] + 1;
				isValid = false;
			}
			--curInx;
		}

		if (was_carry == 1) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = was_carry;
			for (int inx = 1; inx < newDigits.length; inx++) {
				newDigits[inx] = digits[inx - 1];
			}
			return newDigits;
		}

		return digits;

	}

	public static void main(String[] args) {
		EasyPlusOne easyPlusOne = new EasyPlusOne();
		int[] first = new int[] { 9 };
		int[] result = easyPlusOne.plusOne(first);
		System.out.println(result);

	}

}
