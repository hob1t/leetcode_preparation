package msit_5214;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Inspired by https://www.javatpoint.com/doubly-linked-list-program-in-java
 * 
 * void addFront(Item item) add item to the front void addBack(Item item) add
 * item to the back Item deleteFront() remove from the front Item deleteBack()
 * remove from the back void delete(Item item) remove item from the list void
 * add(int i, Item item) add item as the ith in the list Item delete(int i)
 * remove the ith item from the list boolean contains(Item item) is key in the
 * list? boolean isEmpty() is the list empty? int size() number of items in the
 * list
 * 
 * 
 * @author olegtikhonov
 * @param <T>
 *
 */
public class DoublyLinkedList<T> {

	private Node<T> head = null, tail = null;
	private int size = 0;

	@SuppressWarnings("hiding")
	class Node<T> {
		T value;
		Node<T> prev;
		Node<T> next;

		public Node(T data) {
			this.value = data;
		}
	}

	public void addFront(T data) {
		Node<T> tmp = new Node<>(data);

		if (head == null) {
			head = tmp;
			tail = tmp;
			head.prev = null;
			tail.next = null;
		} else {
			head.prev = tmp;
			tmp.next = head;
			tmp.prev = null;
			head = tmp;
		}
		size++;
	}

	public void addBack(T data) {
		Node<T> tmp = new Node<>(data);
		if (head == null) {
			head = tmp;
			tail = tmp;
			head.prev = null;
			tail.next = null;
		} else {
			tail.next = tmp;
			tmp.prev = tail;
			tail = tmp;
			tail.next = null;
		}
		size++;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void printDoublyLinkedList() {
		Node<T> tmp = head;
		if (isEmpty()) {
			System.out.println("Doubly linked list is empty");
		}
		while (tmp != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public void deleteFront() {
		head = head.next;
		size--;
	}

	public int size() {
		return size;
	}

	public void deleteBack() {
		tail = tail.prev;
		tail.next = null;
		size--;
	}

	public static void main(String[] args) {

		for (int inx = 2; inx <= 50; inx *= 2) {
			int[] array = new Random().ints(inx, -100, 100).toArray();
			DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

			System.out.println("adding front ...");
			IntStream.of(array).forEach(item -> {
				dll.addFront(item);
			});

			dll.printDoublyLinkedList();
			dll.deleteFront();
			System.out.println("deleting front ...");
			dll.printDoublyLinkedList();

			System.out.println("adding back ...");

			DoublyLinkedList<Integer> dllAddBack = new DoublyLinkedList<>();
			IntStream.of(array).forEach(item -> {
				dllAddBack.addBack(item);
			});

			dllAddBack.printDoublyLinkedList();
			System.out.println("Size " + dllAddBack.size());

			dllAddBack.deleteBack();
			System.out.println("deleting back ...");
			dllAddBack.printDoublyLinkedList();
			System.out.println("Size " + dllAddBack.size());

		}
	}
}
