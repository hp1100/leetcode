/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow =  head;
        while (slow != null && slow.next != null) {
            ListNode fast = slow.next;
            while (fast != null && fast.val == slow.val) fast = fast.next;
            slow.next = fast;
            slow = fast;
        }
        return head;
    }
}
