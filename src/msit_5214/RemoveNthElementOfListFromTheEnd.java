package msit_5214;

/**
 * 
 * Idea
 * get a size of the list. O(n)
 * 
 * Now, calculate the m, the length until removed element.
 * m = n - k;
 * 
 * while(i<m) {
 *     trav = cur.next;
 * }
 * 
 * we use two pointers, slow, fast.
 * at the begining, fast pointers goes n steps forward.
 * then two pointers go one by one, until fast pointer meets null.
 * at this point, slow pointers on element we would like to remove.    
 * 
 * But here is a trick, called a dummy node. It is added before head.
 * slow pointer initialized not from head, but from dummy node. As
 * result it stops one node before that we want to delete.
 * 
 * Then return dummy.next which pointers to the head.
 *   
 */
public class RemoveNthElementOfListFromTheEnd {
	
	
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
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	// 1. We create a dummy pointer
    	ListNode dummy_head = new ListNode(0, head);
    	ListNode slow = dummy_head;
    	ListNode fast = head;
    	
    	// 2. we initialize our fast pointer
    	while(n-- > 0 && fast != null) {
    		fast = fast.next;
    	}
    	
    	// 3. we shifting both pointers until fast reaches the end of the list
    	while(fast != null) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	// 4. we delete the required node
    	slow.next = slow.next.next;
    	
    	// 5. return the real head
		return dummy_head.next;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
