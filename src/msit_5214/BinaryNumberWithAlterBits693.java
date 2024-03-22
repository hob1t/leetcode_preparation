package msit_5214;

public class BinaryNumberWithAlterBits693 {
	
    public boolean hasAlternatingBits(int n) {
    	
    	StringBuffer sb = new StringBuffer();
    	
    	while(n > 0) {
    		sb.append(n % 2);
    		n = n >> 1;	
    	}
    	
    	char[] arr = sb.toString().toCharArray();
    	
    	for(int i = 0; (i+1) < arr.length; i++) {
    		int first = arr[i] - '0';
    		int second = arr[i + 1] - '0';
    		
    		if((first & second) == 1) {
    			return false;
    		}
    	}

    	return true;
    }

	public static void main(String[] args) {
		BinaryNumberWithAlterBits693 runner = new BinaryNumberWithAlterBits693();
        boolean result = runner.hasAlternatingBits(7);
        System.out.println(result);
	}

}
