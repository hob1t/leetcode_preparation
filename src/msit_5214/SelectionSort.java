package msit_5214;

public class SelectionSort {

	public static int[] selectionSort(int[] array) {

		int localMin = 0, tmp = 0;

		for (int inx = 0; inx < array.length; inx++) {
			localMin = inx;

			for (int jnx = inx + 1; jnx < array.length; jnx++) {
				if (array[localMin] > array[jnx]) {
					localMin = jnx;
				}
			}

			if (localMin != inx) {
				// swap a[min] and a[i]
				tmp = array[localMin];
				array[localMin] = array[inx];
				array[inx] = tmp;
			}
		}

		return array;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] input = { 64, 35, 12, 22, 11 };
		System.out.print("Before sorting ->\t");
		SelectionSort.printArray(input);
		input = SelectionSort.selectionSort(input);
		System.out.print("After sorting ->\t");
		SelectionSort.printArray(input);

	}
}
