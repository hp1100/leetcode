// TreeMap O(n^2)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        int res = 0;
        for (int[] pair: pairs) {
            int start = pair[0];
            int end = pair[1];
            int cur = 0;
            for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
                if (start > entry.getKey()) 
                    cur = Math.max(entry.getValue(), cur);
            }
            cur++; // add self
            res = Math.max(res, cur);
            treemap.put(end, cur);
        }
        return res;
    }
}

// O(nlgn)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
            sum++;
            int curEnd = pairs[i][1];
            while (i+1 < n && pairs[i+1][0] <= curEnd) i++;
        }
        return sum;
    }
}
