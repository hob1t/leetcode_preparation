package msit_5214;


/**
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator. 
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be 
 * truncated to 8, and -2.7335 would be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 *
 */
public class DivideTwoIntegers {
	
	
	
    public int divide(int dividend, int divisor) {
    	// 1. check the sign of the numbers.
    	int sign = 0, result = 0;
    	if((dividend < 0) ^ (divisor < 0)) {
    		sign = -1;
    	}
    	
    	while(dividend > divisor) {
    		dividend = dividend - divisor;
    		result++;
    	}
    	
    	
		return (sign) >= 0 ? result : (0 - result);
        
    }

	public static void main(String[] args) {
		DivideTwoIntegers run = new DivideTwoIntegers();
		int dividend = 10, divisor = 3;
		int firstRunResult = run.divide(dividend, divisor);
        System.out.println(firstRunResult);
	}

}
