package msit_5214;

import java.util.LinkedList;
import java.util.List;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * 
 * Implement the MyHashMap class:
 * 
 * MyHashMap() initializes the object with an empty map. void put(int key, int
 * value) inserts a (key, value) pair into the HashMap. If the key already
 * exists in the map, update the corresponding value. int get(int key) returns
 * the value to which the specified key is mapped, or -1 if this map contains no
 * mapping for the key. void remove(key) removes the key and its corresponding
 * value if the map contains the mapping for the key.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove",
 * "get"] [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]] Output [null,
 * null, null, 1, -1, null, 1, null, -1]
 * 
 * Explanation MyHashMap myHashMap = new MyHashMap(); myHashMap.put(1, 1); //
 * The map is now [[1,1]] myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1); // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3); // return -1 (i.e., not found), The map is now [[1,1],
 * [2,2]] myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update
 * the existing value) myHashMap.get(2); // return 1, The map is now [[1,1],
 * [2,1]] myHashMap.remove(2); // remove the mapping for 2, The map is now
 * [[1,1]] myHashMap.get(2); // return -1 (i.e., not found), The map is now
 * [[1,1]]
 * 
 */
public class DesignHashMap706 {
	// Idea, the same as HashSet, i.e. we have to create a map Node with Key, Value
	class MapNode<K, V> {
		private K key;
		private V value;
		
		public MapNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return String.format("MapNode [key=%s, value=%s]", key, value);
		}
	}
	
	private static final int MODE = 10;
	private List<MapNode<Integer, Integer>> [] table;
	
	
    @SuppressWarnings("unchecked")
	public DesignHashMap706() {
        table = new LinkedList[MODE];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        MapNode<Integer, Integer> node = new MapNode<>(key, value);
        // case 1: not exists
        if(table[index] == null) {
        	table[index] = new LinkedList<>();
        	table[index].add(node);
        } else { // node exists
        	table[index].remove(0);
        	table[index].add(node);
        }
    }
    
    private int hash(int key) {
    	return key % MODE;
    }
    
	public int get(int key) {
    	// case when is not exists
    	int index = hash(key);
    	if(table[index] != null) { // exists
    		for(MapNode<Integer, Integer> mn : table[index]) {
    			if(mn.getKey() == key) {
    				return mn.getValue();
    			}
    		}
    	}
        return Integer.MIN_VALUE;
    }
    

	public void remove(int key) {
    	int index = hash(key);
    	if(table[index] != null) { // exists
    		for(MapNode<Integer, Integer> mn : table[index]) {
    			if(mn.getKey() == key) {
    				table[index] = null;
    				return;
    			}
    		}
    	}
    }

	public static void main(String[] args) {
		DesignHashMap706 myHashMap = new DesignHashMap706();
		myHashMap.put(1, 1); // The map is now [[1,1]]
		myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
		int value = myHashMap.get(1);	
		System.out.println("Key:= " + 1 + ", Value:= " + value);
		value = myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
		System.out.println("Key:= " + 3 + ", Value:= " + value);
		myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
		value =  myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
		System.out.println("Key:= " + 2 + ", Value:= " + value);
		myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
		value =  myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
		System.out.println("Key:= " + 2 + ", Value:= " + value);
	}
}
