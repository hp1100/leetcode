class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r0, c0});
        int idx = 0;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            
            if (r < 0 || r >= R || c < 0 || c >= C) continue;
            if (visited[r][c]) continue;
            
            res[idx++] = cell;
            visited[r][c] = true;
            q.offer(new int[]{r + 1, c});
            q.offer(new int[]{r - 1, c});
            q.offer(new int[]{r, c + 1});
            q.offer(new int[]{r, c - 1});
        }
        return res;
    }
}
