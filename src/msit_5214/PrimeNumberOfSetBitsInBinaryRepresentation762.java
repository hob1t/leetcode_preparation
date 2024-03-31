package msit_5214;

/**
 * Given two integers left and right, return the count of numbers in the
 * inclusive range [left, right] having a prime number of set bits in their
 * binary representation.
 * 
 * Recall that the number of set bits an integer has is the number of 1's
 * present when written in binary.
 * 
 * For example, 21 written in binary is 10101, which has 3 set bits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: left = 6, right = 10 Output: 4 Explanation: 6 -> 110 (2 set bits, 2 is
 * prime) 7 -> 111 (3 set bits, 3 is prime) 8 -> 1000 (1 set bit, 1 is not
 * prime) 9 -> 1001 (2 set bits, 2 is prime) 10 -> 1010 (2 set bits, 2 is prime)
 * 4 numbers have a prime number of set bits.
 * 
 * Example 2:
 * 
 * Input: left = 10, right = 15 Output: 5 Explanation: 10 -> 1010 (2 set bits, 2
 * is prime) 11 -> 1011 (3 set bits, 3 is prime) 12 -> 1100 (2 set bits, 2 is
 * prime) 13 -> 1101 (3 set bits, 3 is prime) 14 -> 1110 (3 set bits, 3 is
 * prime) 15 -> 1111 (4 set bits, 4 is not prime) 5 numbers have a prime number
 * of set bits.
 * 
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation762 {

	public int countPrimeSetBits(int left, int right) {
        int counter = 0;
		// convert int to binary, then calculate ones, then check is it is prime
		for(int inx = left; inx <= right; inx++) {
			String asStr = intToBinary(inx);
			int numOfBits = numOfBits(asStr);
			if(isPrime(numOfBits)) {
				counter++;
			}	
		}
		
		return counter;
	}
	
	private boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;

		if (n == 2 || n == 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i <= Math.sqrt(n); i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
	
	private String intToBinary(int num) {
		return Integer.toBinaryString(num);
	}
	
	private int numOfBits(String asNum) {
		int counter = 0;
		for(char ch : asNum.toCharArray()) {
			if(ch == '1') {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		PrimeNumberOfSetBitsInBinaryRepresentation762 runner = new PrimeNumberOfSetBitsInBinaryRepresentation762();
        int left = 6, right = 10;
        int result = runner.countPrimeSetBits(left, right);
        System.out.println("Result:= " + result);
	}
}
