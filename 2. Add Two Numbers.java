/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + flag;
            flag = val >= 10 ? 1 : 0;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int val = l1.val + flag;
            flag = val >= 10 ? 1 : 0;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int val = l2.val + flag;
            flag = val >= 10 ? 1 : 0;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        if(flag == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
