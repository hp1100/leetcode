class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        
        for (int i = 1; i <= N; i++) {
            if (color[i] != 0) continue;
            color[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int p : adj.get(cur)) {
                    if (color[p] == color[cur]) return false;
                    if (color[p] != 0) continue;
                    queue.offer(p);
                    color[p] = color[cur] == 1 ? 2 : 1;
                }
            }
        }
        return true;
    }
}
