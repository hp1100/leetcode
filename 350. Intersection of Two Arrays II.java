class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            r[i] = res.get(i);
        
        return r;
    }
}
