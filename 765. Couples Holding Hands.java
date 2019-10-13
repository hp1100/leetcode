class Solution {
    private class UF {
        private int[] parents;
        private int[] size;
        public int count;
        UF(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
            count = n;
        }
        
        private int find(int i) {
            if (parents[i] == i) {
                return i;
            }
            parents[i] = find(parents[i]);
            return parents[i];
        }
        
        public void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a == b) return;
            if (size[a] < size[b]) {
                parents[a] = b;
                size[b] += size[a];
            } else {
                parents[b] = a;
                size[a] += size[b];
            }
            count--;
        }
    }
    public int minSwapsCouples(int[] row) {
        int N = row.length/ 2;
        UF uf = new UF(N);
        for (int i = 0; i < N; i++) {
            int a = row[2*i];
            int b = row[2*i + 1];
            uf.union(a/2, b/2);
        }
        return N - uf.count;
    }
}
