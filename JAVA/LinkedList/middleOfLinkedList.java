/** This is the ListNode class definition

class ListNode {
	int data;
	ListNode next;

	ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}
**/

class Solution {
	int getMiddleElementOfLinkedList (ListNode head) {
		if (head == null) {
			return -1;
		}
	    ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}
}
