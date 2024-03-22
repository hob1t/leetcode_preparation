package msit_5214;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of integers nums. int add(int val) Appends the integer val to the
 * stream and returns the element representing the kth largest element in the
 * stream.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]],
 * [3], [5], [10], [9], [4]] Output [null, 4, 5, 5, 8, 8]
 * 
 * Explanation KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4 kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5 kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 * My value of the exe: High, interesting
 * 
 */
public class KthLargestElementInStream {
	private int k;
	private Queue<Integer> heap;
    // idea is to use a heap, i.e. min heap
    // of size k, where kth element will 
    // be at the top
    // when we use add, we add element,
    // then remove, to keep size of k
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>(k);
        
        IntStream.of(nums).forEach(el -> {
        	add(el);
        });
    }
    
    public int add(int val) {
    	heap.add(val);
    	
    	while(heap.size() > k) {
    		int el = heap.poll();
    		System.out.println("El:= " + el);
    	}
        return heap.peek();
    }

	public static void main(String[] args) {
		int k = 3; 
		int[] nums = {4, 5, 8, 2};
		KthLargestElementInStream runner = new KthLargestElementInStream(k, nums);
        int result = runner.add(3);
        System.out.println("Result:= " + result);
        result = runner.add(5);
        System.out.println("Result:= " + result);
        result = runner.add(10);
        System.out.println("Result:= " + result);
        result = runner.add(9);
        System.out.println("Result:= " + result);
        result = runner.add(4);
        System.out.println("Result:= " + result);
	}

}
