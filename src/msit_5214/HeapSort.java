package msit_5214;

import java.util.Random;

/**
 * The idea taken from:
 * 
 * https://www.javatpoint.com/heap-sort
 * 
 * 
 * @author olegtikhonov
 *
 */
public class HeapSort {

	public static int getLeftChild(int i) {
		return 2 * i + 1;
	}

	public static int getRightChild(int i) {
		return 2 * i + 2;
	}

	public static int[] swap(int[] array, int i, int largest) {
		int temp = array[i];
		array[i] = array[largest];
		array[largest] = temp;
		return array;
	}

	public static void heapify(int array[], int arraySize, int i) {
		int largest = i;
		int left = getLeftChild(i);
		int right = getRightChild(i);

		if (left < arraySize && array[left] > array[largest]) {
			largest = left;
		}

		if (right < arraySize && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != i) {
			// swap a[i] with a[largest]
			array = swap(array, i, largest);
			heapify(array, arraySize, largest);
		}
	}

	public static void heapSort(int array[], int arraySize) {
		for (int i = arraySize / 2 - 1; i >= 0; i--)
			heapify(array, arraySize, i);

		// One by one extract an element from heap
		for (int i = arraySize - 1; i >= 0; i--) {
			/* Move current root element to end */
			array = swap(array, 0, i);
			heapify(array, i, 0);
		}
	}

	public static void showArray(int[] array, int arraySize) {
		for (int inx = 0; inx < arraySize; inx++) {
			System.out.print(array[inx] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		for (int inx = 2; inx <= 50; inx*=2) {
			int[] array = new Random().ints(inx, -100, 100).toArray();
			int arraySize = array.length;
			System.out.println("==========================================================");
			System.out.println("Array size " + arraySize);
			System.out.println("Before sorting array elements are");
			showArray(array, arraySize);
			heapSort(array, arraySize);
			System.out.println("After sorting array elements are");
			showArray(array, arraySize);
		}	
	}
}
