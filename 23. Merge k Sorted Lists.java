public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode head: lists){
            if(head != null)
                pq.offer(head);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            if(temp.next != null){
                pq.offer(temp.next);
            }
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}
