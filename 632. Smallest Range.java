public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        int max = nums.get(0).get(0);
        for(int i = 0; i < nums.size(); i++){
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        
        int range = Integer.MAX_VALUE;
        int start = -1;
        while(pq.size() == nums.size()){
            int[] t = pq.poll();
            if(max - t[0] < range){
                range = max - t[0];
                start = t[0];
            }
            if(t[2] < nums.get(t[1]).size() - 1){
                t[0] = nums.get(t[1]).get(++t[2]);
                max = Math.max(max, t[0]);
                pq.offer(t);
            }
        }
        return new int[]{start, start + range};
    }
}
