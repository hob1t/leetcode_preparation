package msit_5214;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


/**
 * Write a program to implement the open addressing linear probing algorithm in
 * JAVA or Python. Test your program with different sets of data and take
 * screenshots for each test.
 * 
 * 
 * inspired by:
 * https://www.geeksforgeeks.org/java-program-to-implement-hashtables-with-linear-probing/
 * 
 * Interface: put get keys values remove clear hashCode
 * 
 * Disclaimer: in this impl I do not take care of load factor.
 * 
 * @author olegtikhonov
 *
 */
public class LinearProbingHash<K, V> {
	private int initCapacity;
	private int currentCapacity;
	private float loadFactor;
	private int size;

	private K[] keys;
	private V[] values;

	private Class<K> kType;
	private Class<V> vType;

	public void clear() {
		size = 0;
		init();
	}

	@SuppressWarnings("unchecked")
	private void init() {
		keys = (K[]) Array.newInstance(kType, initCapacity);
		values = (V[]) Array.newInstance(vType, initCapacity);
	}

	public LinearProbingHash(Class<K> k, Class<V> v, int initCapacity, float loadFactor) {
		this.initCapacity = initCapacity;
		this.currentCapacity = initCapacity;
		this.loadFactor = loadFactor;
		this.kType = k;
		this.vType = v;
		init();
	}

	public void showHash() {
		System.out.println("linear probing hash table size:= " + size);
		for (int i = 0; i < keys.length; i++) {
			if(keys[i] != null) {
				System.out.print(keys[i] + ":" + values[i] + "\n");
			}
			
		}
		System.out.println("\n-------------------------------");
	}

	private int hash(K key) {
		return key.hashCode() % currentCapacity;
	}


	@SuppressWarnings("unchecked")
	public void put(K key, V val) {
		int tmp = hash(key);
		int i = tmp;

		do {
			float threshold = ((float) size) / currentCapacity;
			
			if(threshold >= loadFactor) {
				currentCapacity = currentCapacity * 2;
				System.out.println("New capacity " + currentCapacity + " " + threshold);
				K[] keysEnlaged = (K[]) Array.newInstance(kType, currentCapacity);
				V[] valuesEnlarged = (V[]) Array.newInstance(vType, currentCapacity);
				
				
				for(int inx = 0; inx < keys.length; inx++) {
					keysEnlaged[inx] = keys[inx];
					valuesEnlarged[inx] = values[inx];
				}
				System.out.println("After copying to larger array.");
				keys = keysEnlaged;
				values = valuesEnlarged;
				
			}
			
			if (keys[i] == null) {
				keys[i] = key;
				values[i] = val;
				size++;
				return;
			}

			if (keys[i].equals(key)) {
				values[i] = val;
				System.out.println("The same key " + key + " at index " + i);
				return;
			}

			i = (i + 1) % currentCapacity;
			
			System.out.println("Collision happened for key " + key + " location in array:= " + i + " size:= " + size + " threshold:= " + threshold);

		} while (i != tmp);
	}
	

	public V get(K key) {
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key)) {
				return (V) values[i];
			}
			i = (i + 1) % currentCapacity;
		}
		return null;
	}

	public String next() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	public static void main(String[] args) {
		
		
		for (int inx = 2; inx <= 35; inx*=2) {
			int[] array = new Random().ints(inx, 0, 100).toArray();
			LinearProbingHash<Integer, String> myHashTable = new LinearProbingHash<>(Integer.class, String.class, array.length * 2, 0.9f);
			Arrays.stream(array).forEach(item -> {
				myHashTable.put(item, myHashTable.next());
			});
			
			System.out.println("search key:= " + array[0] + " --> " + myHashTable.get(array[0]));
			myHashTable.showHash();
			
			
			
			myHashTable.clear();
		}
	}

}
