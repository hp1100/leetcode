/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        List<Interval> res = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval: intervals){
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }else{
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        //the last one
        res.add(new Interval(start, end));
        
        return res;
    }
}
