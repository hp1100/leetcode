class Solution {
    
    Random r = new Random();
    int sum = 0;
    int[] areas;
    int[][] rects;

    public Solution(int[][] rects) {
        this.rects = rects;
        int n = rects.length;
        areas = new int[n];
        for (int i = 0; i < n; i++) {
            int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            sum += area;
            areas[i] = sum;
        }
    }
    
    public int[] pick() {
        int num = r.nextInt(sum) + 1;
        int idx = binarySearchRect(num);
        //System.out.println(num +":"+idx);
        int x = rects[idx][0] + r.nextInt(rects[idx][2] - rects[idx][0] + 1);
        int y = rects[idx][1] + r.nextInt(rects[idx][3] - rects[idx][1] + 1);
        return new int[]{x, y};
    }
    
    private int binarySearchRect(int num) {
        int lo = 0, hi = areas.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (areas[mid] < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
