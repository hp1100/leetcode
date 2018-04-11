public class Solution {
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList();
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 || n == 0 || k < 1) return list;
        
        PriorityQueue<Data> heap = new PriorityQueue<Data>((a, b) -> (a.val - b.val));
        
        heap.offer(new Data(0, 0, nums1[0] + nums2[0]));
        
        while(!heap.isEmpty() && k > 0){
            Data d = heap.poll();
            
            int[] pair = {nums1[d.i], nums2[d.j]};
            list.add(pair);
            k--;
            
            //add the next column item
            if(d.j < n - 1){
                heap.offer(new Data(d.i, d.j + 1, nums1[d.i] + nums2[d.j + 1]));
            }
            // always store the next row (smallest) 
            if(d.j == 0 && d.i < m - 1){
                heap.offer(new Data(d.i + 1, 0, nums1[d.i + 1] + nums2[0]));
            }
        }
        return list;
    }
        
        class Data{
            int i; 
            int j;
            int val;
            public Data(int i, int j, int val){
                this.i = i;
                this.j = j;
                this.val = val;
            }
        }
}813. Largest Sum of Averages
