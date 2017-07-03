/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        //find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //check ood 
        if(fast != null && fast.next == null) slow = slow.next;
        //reverse second half of linked list
        fast = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = fast;
            fast = slow;
            slow = next;
        }
        //compare
        slow = head;
        while(fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
