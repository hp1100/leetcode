public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.offer(entry);
        }
        
        List<Integer> res = new LinkedList<>();
        while(res.size() < k){
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}
