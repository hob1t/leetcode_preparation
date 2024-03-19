package msit_5214;


/**
 * Implement a stack using a singly linked list L in Python or Java. 
 * Inspired by: https://java2blog.com/implement-stack-using-linked-list-in-java/
 * 
 * @author olegtikhonov
 * 
 * Firstly define a node in the list, N: data, link to the next element.
 * Next, just create an element and link it to the next element.
 * 
 * 
 *
 */
public class StackLL<T> {
	
	private Node<T> head;
	
	@SuppressWarnings("hiding")
	class Node<T> {
		T value;
		Node<T> next;
	}
	
	public StackLL() {
		head = null;
	}
	
	public T pop() throws Exception {
		if(head == null) {
			throw new Exception("Stack is empty");
		}
		
		T value = head.value;
		head = head.next;
		return value;
	}
	
	public void push(T value) {
		Node<T> tmp = head;
		head = new Node<>();
		head.value = value;
		head.next = tmp;
	}
	
	public void printStackLL() {
		Node<T> tmp = head;
		while(tmp != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		// Test your code with PUSH(10), PUSH(30), POP(), PUSH(80), and POP
        StackLL<Integer> stackBasedOnLinkedList = new StackLL<>();
        stackBasedOnLinkedList.push(10);
        stackBasedOnLinkedList.printStackLL();
        
        stackBasedOnLinkedList.push(30);
        stackBasedOnLinkedList.printStackLL();
        
        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.printStackLL();
        
        stackBasedOnLinkedList.push(80);
        stackBasedOnLinkedList.printStackLL();
        
        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.printStackLL();
	}
}
