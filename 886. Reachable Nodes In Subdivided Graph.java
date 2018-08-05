class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        HashMap<Integer, HashMap<Integer, Integer>> e = new HashMap<>();
        for (int i = 0; i < N; ++i) 
            e.put(i, new HashMap<>());
        for (int[] v : edges) {
            e.get(v[0]).put(v[1], v[2]);
            e.get(v[1]).put(v[0], v[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[] {M, 0});
        HashMap<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            int moves = pq.peek()[0], i = pq.peek()[1];
            pq.poll();
            if (!seen.containsKey(i)) {
                seen.put(i,moves);
                for (int j : e.get(i).keySet()) {
                    int moves2 = moves - e.get(i).get(j) - 1;
                    if (!seen.containsKey(j) && moves2 >= 0)
                        pq.offer(new int[] { moves2, j});
                }
            }
        }
        int res = seen.size();
        for (int[] v : edges) {
            int a = seen.getOrDefault(v[0],0);
            int b = seen.getOrDefault(v[1],0);
            res += Math.min(a + b, v[2]);
        }
        return res;
    }
}
