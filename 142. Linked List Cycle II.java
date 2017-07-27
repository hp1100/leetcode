/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        
        while(slow != null && fast != null){
            slow = slow.next;
            if(fast.next == null) return null;
            fast = fast.next.next;
            if(fast == slow){
                isCycle = true;
                break;
            }
        }
        
        if(!isCycle) return null;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
