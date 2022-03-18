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
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode start = new ListNode(0);
        ListNode begin = start;
        
        while (head != null) {
            if (head.val == 0) {
                ListNode node = new ListNode(sum);
                start.next = node;
                start = start.next;
                sum = 0;
            }
            else {
                sum += head.val;
            }
            
            head = head.next;
        }
        
        return begin.next.next; 
    }
}
