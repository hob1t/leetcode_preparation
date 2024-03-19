package msit_5214;

public class EasyCountingBits {
	
    public int[] countBits(int n) {
    	int[] result = new int[n + 1];
    	
    	for(int i = 0; i <= n; i++) {
    		String s = Integer.toBinaryString(i);
    		result[i] = helper(s);
    	}
    	
        return result;   
    }
    
    public int helper(String s) {
    	int count = 0;
    	for(char c : s.toCharArray()) {
    		if(c == '1') {
    			count++;
    		}
    	}
    	return count;
    }
    

	public static void main(String[] args) {
		EasyCountingBits runner = new EasyCountingBits();
        int[] res = runner.countBits(5);
        System.out.println(res);
	}

}
