class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curFarthest = startFuel, jump = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int[] station : stations) {
            while (curFarthest < station[0]) {
                if (pq.isEmpty()) return -1;
                curFarthest += pq.poll();
                jump++;
            }
            pq.offer(station[1]);
        }
        while (curFarthest < target) {
            if (pq.isEmpty()) return -1;
            curFarthest += pq.poll();
            jump++;
        }
        return jump;
    }
}
