class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int preEnd = 0;
        for (int[] interval: intervals) {
            if (interval[0] < preEnd)
                return false;
            else
                preEnd = interval[1];
        } 
        return true;
    }
}
