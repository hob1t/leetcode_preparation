package msit_5214;

public class EasyHummingBits {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        
        while(result > 0) {
        	count += result & 1;
        	result = result >> 1;
        }
        return count;
    }

	public static void main(String[] args) {
		EasyHummingBits runner = new EasyHummingBits();
		System.out.println("diff sum:= " + runner.hammingDistance(1, 4));
	}
}
