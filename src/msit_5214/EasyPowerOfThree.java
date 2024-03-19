package msit_5214;

public class EasyPowerOfThree {
    public boolean isPowerOfThree(int n) {
    	if(n < 3) {
    		return false;
    	}
    	
    	while((n % 3) == 0) {
    		n = n / 3;
    	}
    	
        return (n == 1);
    }

	public static void main(String[] args) {
		EasyPowerOfThree runner = new EasyPowerOfThree();
		System.out.println(runner.isPowerOfThree(6));
	}

}
