// Problem Link :- https://leetcode.com/problems/reverse-linked-list/submissions/

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode start = head;
        ListNode prev = head;
        ListNode curr = null;
        ListNode inc = null;
        
        head = head.next;
        
        while (head != null) {
            curr = head;
            inc = head.next;
            curr.next = prev;
            prev = curr;
            head = inc;
        }
        
        start.next = null;
        
        return prev;
    }
}
