class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            //if (!map.containsKey(start))
                map.put(start, i);
        }
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            Integer right = map.ceilingKey(end);
            res[i] = right == null ? -1 : map.get(right);
        }
        return res;
    }
}
