package msit_5214;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the 
 * values in the list's nodes (i.e., only nodes themselves may be changed.)
 * 
 */
public class SwapEachPairOfLL {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		// case one - create a dummy_head.
		ListNode dummy_head = new ListNode(0, head);
		// define two pointers
		ListNode prev = dummy_head;
		ListNode current = head;
		
		while(current != null && current.next != null) {
			// save pointers
			ListNode nxtPair = current.next.next;
			ListNode second = current.next;
			
			// reverse this pair
			second.next = current;
			current.next = nxtPair;
			prev.next = second;
			
			// update pointers
			prev = current;
			current = nxtPair;
		}
		
		
		return dummy_head.next;
        
    }

	public static void main(String[] args) {
	    SwapEachPairOfLL parent = new SwapEachPairOfLL(); 
	    ListNode node1 = parent.new ListNode(11);
	    ListNode node2 = parent.new ListNode(20);  
	    ListNode node3 = parent.new ListNode(30);  
	    node1.next = node2;  
	    node2.next = node3;  

	}

}
