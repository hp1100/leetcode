class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        if(graph == null || graph.length == 0)  return res;
        
        int nodeCount = graph.length;
        int[] color = new int[nodeCount];
        
        for(int i = 0; i < nodeCount; i++) {
            if(dfs(i, color, graph))
                res.add(i);
        }
        
        return res;
    }
    
    private boolean dfs(int idx, int[] color, int[][] graph) {
        if(color[idx] != 0)
            return color[idx] == 1;
        
        color[idx] = 2;
        for(int i : graph[idx]) {
            if(!dfs(i, color, graph))
                return false;
        }
        color[idx] = 1;
        
        return true;
    }
}
