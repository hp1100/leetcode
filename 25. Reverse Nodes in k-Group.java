/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        
        while(head != null){
            if(!hasNextK(head, k)) break;
            head = reverseNextK(head, k);
        }
        
        return dummy.next;
    }
    
    
    // head -> n1 -> n2 -> ... -> nk -> 1212
    private ListNode reverseNextK(ListNode head, int k){
        ListNode cur = head.next;
        ListNode then = cur.next;
        
        
        // reverse
        for(int i = 1; i < k; i++){
            if(cur.next == null) return null;
            cur.next = then.next;
            then.next = head.next;
            head.next = then;
            then = cur.next;
            //if(then == null) return null;
        }
        
        // return the end
        for(int i = 0; i < k; i++)
            head = head.next;
        
        return head;
    }
    
    private boolean hasNextK(ListNode head, int k){
        for(int i = 0; i < k; i++){
            if(head.next == null)
                return false;
            head = head.next;
        }
        return true;
    }
}
