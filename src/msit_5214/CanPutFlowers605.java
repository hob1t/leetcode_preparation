package msit_5214;

/**
 * 
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return true if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule and
 * false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1 Output: true
 * 
 * Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
 * 
 * 
 */
public class CanPutFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 1 and 0 or 0 and 1
        int count = 0;
        for(int inx = 0; inx < flowerbed.length; inx++) {
            if(flowerbed[inx] == 0 && canBePlaned(inx, flowerbed)) {
                count++;
            }
        }
        return (n == count);
    }

    boolean canBePlaned(int index, int[] flowerbed) {
        if(index >= 0 && index < flowerbed.length) {
            if(flowerbed[index - 1] == 1 || flowerbed[index + 1] == 1) {
                return false;
            } 
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		CanPutFlowers605 runner = new CanPutFlowers605();
		int[] flowerbed = {1,0,0,0,1}; 
		int n = 2;
        System.out.println(runner.canPlaceFlowers(flowerbed, n));
	}

}
