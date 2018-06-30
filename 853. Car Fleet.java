// Time complexity: O(nlgn) Space: O(n)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) return 0;
        int n = position.length;
        int[][] distance_speed = new int[n][2];
        for (int i = 0; i < n; i++) {
            distance_speed[i][0] = position[i];
            distance_speed[i][1] = speed[i];
        }
        Arrays.sort(distance_speed, (a, b) -> b[0] - a[0]);
        
        int res = 1;
        double pre_arrive_time = (target - distance_speed[0][0]) * 1.0 / distance_speed[0][1];
        for (int i = 1; i < n; i++) {
            double cur_arrive_time = (target - distance_speed[i][0]) * 1.0 / distance_speed[i][1];
            //System.out.println(cur_arrive_time + " > ? " + pre_arrive_time);
            if (cur_arrive_time > pre_arrive_time) {
                res++;
                pre_arrive_time = cur_arrive_time;
            }
        }
        return res;
    }
}
