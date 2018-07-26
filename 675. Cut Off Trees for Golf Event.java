class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = getTreesPos(forest);
        int steps = 0;
        int[] curPos = new int[2]; // default: (0, 0)
        while (!pq.isEmpty()) {
            int[] nextTree = pq.poll();
            int cost = bfs(curPos, nextTree, forest);
            if (cost == -1) return -1;
            steps += cost;
            curPos[0] = nextTree[0];
            curPos[1] = nextTree[1];
        }
        return steps;
    }
    
    private PriorityQueue<int[]> getTreesPos(List<List<Integer>> forest) {
        PriorityQueue<int[]> res = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    res.offer(new int[]{i, j, forest.get(i).get(j)}); // int[3] : {height, x, y}
                }
            }
        }
        return res;
    }
    
    private int bfs (int[] curPos, int[] des, List<List<Integer>> forest) {
        int res = 0;
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(curPos);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                if (visited[pos[0]][pos[1]] == true) continue;
                if (forest.get(pos[0]).get(pos[1]) == 0) continue;
                if (pos[0] == des[0] && pos[1] == des[1]) return res;
                visited[pos[0]][pos[1]] = true;
                if (pos[1] > 0) queue.offer(new int[]{pos[0], pos[1] - 1}); // up
                if (pos[0] > 0) queue.offer(new int[]{pos[0] - 1, pos[1]}); // left
                if (pos[1] < n - 1) queue.offer(new int[]{pos[0], pos[1] + 1}); // down
                if (pos[0] < m - 1) queue.offer(new int[]{pos[0] + 1, pos[1]}); // right
            }
            res++;
        }
        return -1;
    }
}
