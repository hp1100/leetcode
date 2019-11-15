class Solution {
    
    int M;
    Map<Integer, Integer> map;
    Random random;

    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        for (int b: blacklist)
            map.put(b, -1);
        M = N - map.size();
        for (int b: blacklist) {
            if (b >= M) continue;
            while (map.containsKey(N - 1))
                N--;
            map.put(b, --N);
        }
    }
    
    public int pick() {
        int r = random.nextInt(M);
        return map.containsKey(r) ? map.get(r) : r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
