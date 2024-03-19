package msit_5214;

/**
 * Given an integer num, return a string of its base 7 representation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 100 Output: "202"
 * 
 * Example 2:
 * 
 * Input: num = -7 Output: "-10"
 * 
 */
public class EasyModeSeven {

	public String convertToBase7(int num) {
		StringBuffer holder = new StringBuffer();
		int mode = 0;
		boolean isNegative = false;
		
		
		if(num < 0) {
			num = ~(num) + 1;
			isNegative = true;
		}
		
		while(num > 0) {
			mode = num % 7;
			holder.append(mode);
			
			num = num / 7;
		}
		
		if(isNegative) {
			holder.append('-');
		}

		return holder.reverse().toString();
	}

	public static void main(String[] args) {
		EasyModeSeven runner = new EasyModeSeven();
		System.out.println("Result:= " + runner.convertToBase7(100));
	}
}
