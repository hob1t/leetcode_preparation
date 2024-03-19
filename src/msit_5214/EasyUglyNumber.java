package msit_5214;


import java.util.HashSet;
import java.util.Set;

public class EasyUglyNumber {

	
    public boolean isUgly(int n) {
    	if(n <= 0) {
    		return false;
    	}
    	Set<Integer> holder = new HashSet<>();
    	holder.add(2);
    	holder.add(3);
    	holder.add(5);
    	
    	for(int num : holder) {
    		while(n % num == 0) {
    			n = n / num;
    		}
    	}

    	return (n == 1);
    }

	public static void main(String[] args) {
		EasyUglyNumber runner = new EasyUglyNumber();
		System.out.println(runner.isUgly(20));
	}

}
