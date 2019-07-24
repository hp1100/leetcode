class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d: dominoes) {
            int val = Math.max(d[0], d[1]) * 10 + Math.min(d[0], d[1]);
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        for (int c: count.values()) {
            res += c * (c - 1) / 2;
        }
        return res;
    }
}
