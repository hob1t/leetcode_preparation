package msit_5214;

/**
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a
 * type of stone you have. You want to know how many of the stones you have are
 * also jewels.
 * 
 * Letters are case sensitive, so "a" is considered a different type of stone
 * from "A".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: jewels = "aA", stones = "aAAbbbb" Output: 3
 * 
 * Example 2:
 * 
 * Input: jewels = "z", stones = "ZZ" Output: 0
 * 
 */
public class JewelsAndStones771 {
	
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
    	// jewels 
        // take a char in jewels and count how many in stones
        // return count
        // go over jewels
        for(char jewel : jewels.toCharArray()) {
        	for(char stone : stones.toCharArray()) {
        		if(jewel == stone) {
        			count++;
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		JewelsAndStones771 runner = new JewelsAndStones771();
		String jewels = "aA", stones = "aAAbbbb";
		int result = runner.numJewelsInStones(jewels, stones);
        System.out.println("Result:= " + result);
	}

}
