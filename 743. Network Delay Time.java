class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time: times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        pq.offer(new int[]{0, K});
        
        boolean[] visited = new boolean[N + 1];
        int res = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1], curDist = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (N == 0) return res;
            if (map.containsKey(curNode)) {
                for (int next: map.get(curNode).keySet()) {
                    pq.offer(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        
        return -1;
    }
}
