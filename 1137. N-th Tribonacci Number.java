class Solution {
    public int tribonacci(int n) {
        int sum = 2;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(1);
        q.offer(1);
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        for (int i = 3; i < n; i++) {
            q.offer(sum);
            sum += sum - q.poll();
        }
        return sum;
    }
}
