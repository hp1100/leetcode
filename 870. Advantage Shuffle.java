class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) 
            pq.offer(new int[]{B[i], i});
        int[] res = new int[n];
        int lo = 0, hi = n - 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res[cur[1]] = A[hi] > cur[0] ? A[hi--] : A[lo++];
        }
        return res;
    }
}
