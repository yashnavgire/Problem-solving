// Problem Link :- https://leetcode.com/problems/middle-of-the-linked-list/submissions/

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
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        
        if (head == null) {
            return head;
        }
        
        int len = 0;
        ListNode start = head;
        
        while (head != null) {
            head = head.next;
            len++;
        }
        
        len = len/2 + 1;
        
        head = start;
        
        // System.out.println(len);
        
        while (len != 1) {
            len--;
            head = head.next;
        }
        
        return head;
    }
}
