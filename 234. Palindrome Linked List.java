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
        //find the middle point
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse second half linked list
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while(cur != null){
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        //check first half and second half
        while(slow.next){
            if(slow.next.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
