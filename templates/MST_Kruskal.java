class Solution {
    public void costOfMst(int n, int[][] edges) { 
        // Given a weighted undirected connected graph with n vertices numbered from 0 to n-1,
        // an array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between nodes fromi and toi
        Arrays.sort(edges, (e1, e2)->Integer.compare(e1[2], e2[2]));
        return buildMST(n, edges);
    }
    
    private int buildMST(int n, int[][] edges){
        // Time complexity(ElgV)
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        return uf.count == 1? cost : Integer.MAX_VALUE;
    }
}

class UnionFind{
    final int[] parents;
    int count;
    
    public UnionFind(int n){
        this.parents = new int[n];
        reset();
    }
    
    public void reset(){
        for(int i =0;i<parents.length;i++){
            parents[i] = i;
        }
        count = parents.length;
    }
    
    public int find(int i){
        int parent = parents[i];
        if(parent == i){
            return i;
        }else{
            int root = find(parent);
            parents[i] = root;
            return root;
        }
    }
    
    public boolean union(int i, int j){
        int r1 = find(i);
        int r2 = find(j);
        if(r1 != r2){
            count--;
            parents[r1] = r2;
            return true;
        }else{
            return false;
        }
    }
    
}
