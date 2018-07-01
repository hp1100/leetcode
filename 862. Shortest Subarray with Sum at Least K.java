class Solution {
    public int shortestSubarray(int[] A, int K) {
        if (A.length == 0) return -1;
        TreeMap<Long, Integer> tree = new TreeMap<>();
        long total = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            Long num = tree.floorKey(total-K);
            if (total >= K) {
                if (i+1 < minLen) {
                    minLen = i+1;
                }
            }
            while (num != null) {
                if (i-tree.get(num) < minLen) {
                    minLen = i-tree.get(num);
                }
                tree.remove(num);
                num = tree.lowerKey(num);
            }
            tree.put(total, i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
