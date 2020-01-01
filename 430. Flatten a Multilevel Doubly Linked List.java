/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head != null)
            dfs(null, head);
        return head;
    }
    
    public Node dfs(Node parent, Node node) {
        node.prev = parent;
        
        while (node.child != null || node.next != null) {
            if (node.child != null) {
                Node last = dfs(node, node.child);
                last.next = node.next;
                if (node.next != null) {
                    node.next.prev = last;
                }
                node.next = node.child;
                node.child = null;
                node = last;
            }
            
            if (node.next != null)
                node = node.next;
        }
        
        return node;
    }
}


// ------------------------------------------------------------------------------------------------------

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    
    Node end = null;
    
    public Node flatten(Node head) {
        if (head == null)
            return end;
        
        end = flatten(head.next);
        head.next = flatten(head.child);
        if (head.next != null)
            head.next.prev = head;
        head.child = null;
        return head;
    }
}
