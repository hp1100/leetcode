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
        // otherwise just use id[i] = j;
    }
}


==================================================================
    
     private class UnionFind {

        public int[] size;
        public int[] parent;

        UnionFind(int count) {
            size = new int[count];
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        int union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return size[pRoot];
            }
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
                return size[pRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                return size[qRoot];
            }

        }
    }
