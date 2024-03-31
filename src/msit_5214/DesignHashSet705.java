package msit_5214;

import java.util.LinkedList;
import java.util.List;

/**
 * Design a HashSet without using any built-in hash table libraries.
 * 
 * Implement MyHashSet class:
 * 
 * void add(key) Inserts the value key into the HashSet. bool contains(key)
 * Returns whether the value key exists in the HashSet or not. void remove(key)
 * Removes the value key in the HashSet. If key does not exist in the HashSet,
 * do nothing.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["MyHashSet", "add", "add", "contains", "contains", "add", "contains",
 * "remove", "contains"] [[], [1], [2], [1], [3], [2], [2], [2], [2]] Output
 * [null, null, null, true, false, null, true, null, false]
 * 
 * Explanation MyHashSet myHashSet = new MyHashSet(); myHashSet.add(1); // set =
 * [1] myHashSet.add(2); // set = [1, 2] myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found) myHashSet.add(2); // set
 * = [1, 2] myHashSet.contains(2); // return True myHashSet.remove(2); // set =
 * [1] myHashSet.contains(2); // return False, (already removed)
 */
public class DesignHashSet705 {
	// use % and LinkedList for collisions
	private int MODE_SIZE = 10;
	List<Integer>[] buckets;

	
	@SuppressWarnings("unchecked")
	public DesignHashSet705() {
		buckets = new LinkedList[MODE_SIZE];
	}

	public void add(int key) {
		int keyIn = key % MODE_SIZE;
		if (buckets[keyIn] == null) {
			buckets[keyIn] = new LinkedList<>();
			buckets[keyIn].add(key);
		} else if (buckets[keyIn].indexOf(key) == -1) {
			System.out.println(buckets[keyIn].indexOf(key));
			buckets[keyIn].add(key);
		}
	}

	public void remove(int key) {
		int keyIn = key % MODE_SIZE;
		if (buckets[keyIn].indexOf(key) != -1) {
			buckets[keyIn].remove(buckets[keyIn].indexOf(key));
		}
	}

	public boolean contains(int key) {
		int keyIn = key % MODE_SIZE;
		if (buckets[keyIn] != null && buckets[keyIn].indexOf(key) != -1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DesignHashSet705 myHashSet = new DesignHashSet705();
		myHashSet.add(1);      // set = [1]
		myHashSet.add(2);      // set = [1, 2]
		myHashSet.contains(1); // return True
		myHashSet.contains(3); // return False, (not found)
		myHashSet.add(2);      // set = [1, 2]
		myHashSet.contains(2); // return True
		myHashSet.remove(2);   // set = [1]
		myHashSet.contains(2); // return False, (already removed)
	}
}
