package msit_5214;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.*;


public class TopKFrequentElements {
    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public int getKey() {
        	return this.key;
        }
        
        public int getValue() {
        	return this.value;
        }
    }


    public int[] topKFrequent(int[] nums, int k) {
    	int[] result = new int[k];
        // What I think ...
        // For the start, we will use a HashMap
        // key + counter
        // Then we build a PriorityQueue as a max heap
        // Head will contain a Object called Pair 
        // Pair
        // key:value
        //When we insert the data into the heap, we will use value
        // when retrieve - we show a key.

        Map<Integer, Integer> holder = new HashMap<>();

        // O(n) went once and calculate frequences
        IntStream.of(nums).forEach( item -> {
			holder.merge(item, 1, Integer::sum);
		});

        // need to test 
        PriorityQueue<Pair> pQueue = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());
        
        // O(n)
        holder.forEach((K, V) -> {
			System.out.println("key:=" + K + ", value:=" + V);
			pQueue.add(new Pair(K, V));
		});

        // now go over Heap and push/remove K elements
        for(int i = 0; i < k; i++) {
        	result[i] = pQueue.poll().getKey();
        }
        
        
        
        
        return result;
        
    }

	public static void main(String[] args) {
		TopKFrequentElements test = new TopKFrequentElements();
		//[1,1,1,2,2,3], k = 2
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		
		int[] res = test.topKFrequent(nums, k);
		IntStream.of(res).forEach(item -> System.out.println(item));
	}

}
