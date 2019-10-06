// Time complexity: O(n*sqrt(Max val of A[i]))
class Solution {
    public int largestComponentSize(int[] A) {
        int n = A.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> map = new HashMap<>();// key is the factor, val is the node index
        for (int i = 0; i < n; i++){
            int a = A[i];
            for (int j = 2; j * j <= a; j++){
                if (a % j == 0){
                    if (!map.containsKey(j)){//this means that no index has claimed the factor yet
                        map.put(j, i);
                    }else{//this means that one index already claimed, so union that one with current
                        uf.union(i, map.get(j));
                    }
                    if (!map.containsKey(a/j)){
                        map.put(a/j, i);
                    }else{
                        uf.union(i, map.get(a/j));
                    }
                }
            }
            if (!map.containsKey(a)){//a could be factor too. Don't miss this
                map.put(a, i);
            }else{
                uf.union(i, map.get(a));
            }
        }
        return uf.count();
    }
}

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
        if (sz[i] < sz[j]) { 
            id[i] = j; 
            sz[j] += sz[i]; 
        } else { 
            id[j] = i; 
            sz[i] += sz[j]; 
        } 
    }
    
    public int count() {
        int max = 0;
        for (int s : sz) {
            //System.out.print(s + " "); 
            max = Math.max(max, s);
        }
        return max;
    }
}
