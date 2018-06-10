class Solution {
    public int maxDistToClosest(int[] seats) {
        int pre = -1, res = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) continue;
            
            if(pre == -1) res = i;
            else res = Math.max((i - pre) / 2, res); // the length between two elements is : j-i-1(j > i), for odd, use: j - i
            pre = i;
        }
        res = Math.max(res, seats.length - pre - 1);
        return res;
    }
}
