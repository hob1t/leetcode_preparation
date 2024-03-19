## Leetcode tricks
Here i will gather all leetcode tricks I've met.

#### Trick #1 - when two strings have different lengths
Find a smallest String, by comparator (-1,0,1) and add 0s to that one.


```
String first = "345"
String second = "34"

String newStr = "034"
```

#### Trick #2 - when we are asking to find all missing number in array when range is 1 ... N

```
Given array :  [4, 3, 2, 7, 8, 2, 3, 1]
Changed array: [-4, -3, -2, -7, 8, 2, -3, -1]
And then, return indices of positive numbers, i.e. [5, 6]
```

#### 

Matt Upham suggests to write algorithm line by line like comments and them write real code underneath.

```
	public int arrayPairSum(int[] nums) {
		int sum = 0;
		// sort array
		Arrays.sort(nums);
		// go by 2 and sum minimum
		for(int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		// return sum
		return sum;
	}
```
