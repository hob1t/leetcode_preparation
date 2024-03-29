package msit_5214;

import java.util.stream.IntStream;

/**
 * A web developer needs to know how to design a web page's size. So, given a
 * specific rectangular web page’s area, your job by now is to design a
 * rectangular web page, whose length L and width W satisfy the following
 * requirements:
 * 
 * The area of the rectangular web page you designed must equal to the given
 * target area. The width W should not be larger than the length L, which means
 * L >= W. The difference between length L and width W should be as small as
 * possible.
 * 
 * Return an array [L, W] where L and W are the length and width of the web page
 * you designed in sequence.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: area = 4 Output: [2,2] Explanation: The target area is 4, and all the
 * possible ways to construct it are [1,4], [2,2], [4,1]. But according to
 * requirement 2, [1,4] is illegal; according to requirement 3, [4,1] is not
 * optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * 
 * Example 2:
 * 
 * Input: area = 37 Output: [37,1]
 * 
 * Example 3:
 * 
 * Input: area = 122122 Output: [427,286]
 * 
 */
public class EasyConstructRectangle {

	public int[] constructRectangle(int area) {
		int[] result = new int[2];

		int sqr = (int) Math.sqrt(area);

		while (sqr > 0) {
			if (area % sqr == 0) {
				result[0] = sqr;
				result[1] = (area / sqr);
				sqr = -1;
			} else {
				sqr -= 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		EasyConstructRectangle runner = new EasyConstructRectangle();
		int[] result = runner.constructRectangle(122122);
		IntStream.of(result).forEach(System.out::println);
	}

}
