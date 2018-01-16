/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        
        if(root == null) return root;
        
        // use bfs to get all nodes
        List<UndirectedGraphNode> nodes = getAllNodes(root);
        
        // copy nodes in hashMap
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode node : nodes)
            map.put(node, new UndirectedGraphNode(node.label));
        
        // connect nodes
        for(UndirectedGraphNode node : nodes)
            for(UndirectedGraphNode neighbor : node.neighbors)
                map.get(node).neighbors.add(map.get(neighbor));
        
        return map.get(root);
    }
    
    private List<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node){
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors)
                if(!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
        }
        
        return new ArrayList<>(set);
    }
}
