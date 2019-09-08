class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int dist: distance)
            sum += dist;
        int clockwiseDist = 0;
        int len = distance.length;
        if (destination < start) destination += len;
        for (int i = start; i < destination; i++)
            clockwiseDist += distance[i % len];
        return Math.min(clockwiseDist, sum - clockwiseDist);
    }
}
