package msit_5214;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * A self-dividing number is not allowed to contain the digit zero.
 * 
 * Given two integers left and right, return a list of all the self-dividing
 * numbers in the range [left, right].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: left = 1, right = 22 Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 * 11 % 1, 12 % 1, 12 % 2, 
 * 
 * Example 2:
 * 
 * Input: left = 47, right = 85 Output: [48,55,66,77]
 * 
 */
public class SelfDividingNumbers728 {

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<Integer>();
		Set<Integer> holder = new HashSet<>();
		// for i in range(1:22)
		// for j in range (1 : i)
		// if( i % j == 0)
		// list.add(i)
		
		for(int inx = left; inx <= right; inx++ ) {
			holder = isSelfDividing(inx, holder);
		}
		
		result.addAll(holder);
		return result;
	}
	
	private Set<Integer> isSelfDividing(int num, Set<Integer> list) {
		int localNum = num;
		int numLength = String.valueOf(num).toCharArray().length;
		
		while(localNum > 0) {
			int local = localNum % 10;
			if(local != 0 && num % local == 0 ) {
				--numLength;
			}
			localNum = localNum / 10;
		}
		
		if(numLength == 0) {
			list.add(num);
		}
		
		
		return list;
	}

	public static void main(String[] args) {
		SelfDividingNumbers728 runner = new SelfDividingNumbers728();
		int left = 47, right = 85;
		List<Integer> result = runner.selfDividingNumbers(left, right);
		result.stream().forEach( el -> {
			System.out.println(el);
		});
	}

}
