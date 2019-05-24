class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone: stones)
            pq.offer(stone);
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x == y) continue;
            else pq.offer(y - x);
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int st : stones) { q.offer(st); }
        while (q.size() > 1) {
            q.offer(q.poll() - q.poll());
        }
        return q.peek();
    }
}
