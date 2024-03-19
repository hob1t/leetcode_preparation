package msit_5214;


/**
 * 
 * Implement a queue by a singly linked list L in Python or Java. 
 * Inspired by: https://java2blog.com/implement-queue-using-linked-list-in-java/
 * 
 * 
 * @author olegtikhonov
 *
 * @param <T> type
 */
public class QueueLL<T> {
	private Node<T> rear, front;
	private int size;
	
	public QueueLL() {}
	
	
	
	@SuppressWarnings("hiding")
	class Node<T> {
		T value;
		Node<T> next;
	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(T data) {
		Node<T> tmp = rear;
		rear = new Node<T>();
		rear.value = data;
		rear.next = null;
		
		if(isEmpty()) {
			front = rear;
		} else {
			tmp.next = rear;
		}
		
		size++;
	}
	
	public T dequeue() {
		T data = front.value;
		front = front.next;
		
		if(isEmpty()) {
			rear = null;
		} 
		
		size--;
		
		return data;
	}
	

	public void printQueueLL(String message) {
		Node<T> tmp = front;
		System.out.print(message);
		while(tmp != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// Test your code with ENQUEUE(4),  ENQUEUE(1), ENQUEUE(3),  DEQUEUE(), ENQUEUE(8), and DEQUEUE().
		QueueLL<Integer> queue = new QueueLL<>();
		
		queue.enqueue(4);
		queue.printQueueLL("Queue after inserting 1 element:->\t");

		queue.enqueue(1);
		queue.printQueueLL("Queue after inserting 1 element:->\t");
		
		queue.enqueue(3);
		queue.printQueueLL("Queue after inserting 1 element:->\t");
		
		queue.dequeue();
		queue.printQueueLL("Queue after removing 1 element:->\t");
		
		queue.enqueue(8);
		queue.printQueueLL("Queue after inserting 1 element:->\t");
		
		queue.dequeue();
		queue.printQueueLL("Queue after removing 1 element:->\t");
	}

}
