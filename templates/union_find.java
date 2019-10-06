class UnionFind {
    private int[] id;
    private int[] sz;
    
    public UnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
            id[i] = i;
        }
    }
    
    public int find(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; //path compression
            i = id[i];
        }
        return i;
    }
    
    public void union(int p , int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { // weighting
            id[i] = j; 
            sz[j] += sz[i]; 
        } else { 
            id[j] = i; 
            sz[i] += sz[j]; 
        } 
    }
}
