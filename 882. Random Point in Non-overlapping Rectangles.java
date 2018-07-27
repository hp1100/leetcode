class Solution {
    
    TreeMap<Integer, Integer> map;
    int sum;
    int[][] rects;
    Random rand = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < rects.length; i++) {
            // number of points not area
            int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            sum += area;
            map.put(sum, i);
        }
    }
    
    public int[] pick() {
        Random rand = new Random();
        int i = map.get(map.ceilingKey(rand.nextInt(sum) + 1));
        int p_x = rects[i][0] + rand.nextInt(rects[i][2] - rects[i][0] + 1);
        int p_y = rects[i][1] + rand.nextInt(rects[i][3] - rects[i][1] + 1);
        return new int[]{p_x, p_y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
