class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int sum = 2;
        Queue<Integer> q = new LinkedList<>(Arrays.asList(0, 1, 1));
        for (int i = 3; i < n; i++) {
            q.offer(sum);
            sum += sum - q.poll();
        }
        return sum;
    }
}
