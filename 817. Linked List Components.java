/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        boolean flag = false;
        for(int g : G)
            set.add(g);
        while(head != null) {
            if(!set.contains(head.val)) {
                flag = false;
            } else if(!flag){ // new component
                flag = true;
                res++;
            }
            head = head.next;
        }
        return res;
    }
}
