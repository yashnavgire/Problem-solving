// Problem Link :- https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        
        while (start != null && start.next != null) {
            if (start.next.val == start.val) {
                start.next = start.next.next;
            }
            else
             start = start.next;
        }
        
        return head;
    }
}
