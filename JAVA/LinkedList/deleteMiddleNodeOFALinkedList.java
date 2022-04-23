/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        
        if (head.next == null) {
            return null;
        }
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = dummyHead;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            prev = prev.next;
            fast = fast.next.next;
        }
        
        prev.next = slow.next;
        
        return head;
    }
}
