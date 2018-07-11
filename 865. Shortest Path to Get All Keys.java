class Solution {
    class State {
        int key, x, y;
        public State(int key, int x, int y) {
            this.key = key;
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length(), x = -1, y = -1, max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    x = i;
                    y = j;
                }
                if (ch >= 'a' && ch <= 'f')
                    max = Math.max(max, ch - 'a' + 1);
            }
        }
        State start = new State(0, x, y);
        Queue<State> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        int steps = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                State cur = queue.poll();
                if (cur.key == (1 << max) - 1)
                    return steps;
                for (int[] dir : dirs) {
                    int i = cur.x + dir[0];
                    int j = cur.y + dir[1];
                    int key = cur.key;
                    if (i < 0 || i >= m || j < 0 || j >= n) continue;
                    char c = grid[i].charAt(j);
                    if (c == '#') 
                        continue;
                    if (c >= 'a' && c <= 'f') 
                        key |= 1 << (c - 'a');
                    if (c >= 'A' && c <= 'F' && ((key >> (c - 'A')) & 1) == 0) 
                        continue;
                    if (!visited.contains(key + " " + i + " " + j)) {
                        visited.add(key + " " + i + " " + j);
                        queue.offer(new State(key, i, j));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
