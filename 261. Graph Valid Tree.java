class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n - 1) return false;
        
        Map<Integer, Set<Integer>> map = initializeMap(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(0);
        visited.add(0);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer neighbor : map.get(cur)){
                if(visited.contains(neighbor)) continue;
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
        
        return (visited.size() == n);
    }
    
    private Map<Integer, Set<Integer>> initializeMap(int n, int[][] edges){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(i, new HashSet<>());
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
    
    
}
