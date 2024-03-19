package msit_5214;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * nums = {5, 2, 7, 1, 4, 3, 6}
 */
public class UnityShuffleArray {
	public int[] shuffle(int[] nums) {
		// idea to use Rand function and last index
		// i.e. if lastIndex = nums.length, we will rand.nextInt(0, and lastIndex)
		for(int lastIndex = nums.length -1; lastIndex > 0; lastIndex--) {
			int randIndex = ThreadLocalRandom.current().nextInt(0, lastIndex);
			System.out.println(randIndex + ", " + lastIndex);
			
			int tmp = nums[lastIndex];
			nums[lastIndex] = nums[randIndex];
			nums[randIndex] = tmp;
		}
		
		return nums;
	}

	public static void main(String[] args) {
		UnityShuffleArray runner = new UnityShuffleArray();
		int[] nums = {5, 2, 7, 1, 4, 3, 6};
		int[] result = runner.shuffle(nums);
		IntStream.of(result).forEach(System.out::println);
	}
}
