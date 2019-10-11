class Solution {
    
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], i * n + j);
            }
        }
        int start = 0;
        int end = n * n - 1;
        UF uf = new UF(n * n);
        int t = 0;
        for (; ;t++) {
            int cur = map.get(t);
            dfs(uf, cur / n, cur % n, grid, t, n);
            if (uf.find(start) == uf.find(end)) break;
        }
        return t;
    }
    
    private void dfs(UF uf, int x, int y, int[][] grid, int t, int n) {
        
        for (int[] d : directions) {
            int i = x + d[0];
            int j = y + d[1];
            if (i < 0 || i >= n || j < 0 || j >= n) continue;
            if (grid[x][y] < grid[i][j] && t < grid[i][j]) continue;
            int p = i * n + j, q = x * n + y;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            dfs(uf, i, j, grid, t, n);
        }

    }
}

class UF {
    int parent[];
    int size[];
    
    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n;i++) {
            parent[i] = i;
            size[i] = 1;
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
