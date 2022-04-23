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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        if (head.next == null) {
            return head;
        }
        
        if (k == 0) {
            return head;
        }
        
        int len = 0;
        ListNode start = head;
        ListNode begin = head;
        ListNode ans = null;
        ListNode tail = new ListNode(-1);
        tail.next = head;
        
        while (start != null) {
            len++;
            start = start.next;
            tail = tail.next;
        }
        System.out.println(len);
        
        tail.next = head;
        
        k = k % len;
        int end = len - k;
        
        while (end != 0 && tail != null) {
            tail = tail.next;
            end--;
        }
        
        ans = tail.next;
        tail.next = null;
        
        return ans;
        
    }
}
