// use hashmap - O(n)
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


// use two pointer when two arrays are sorted - O(nlgn)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{ //nums1[i] == nums2[j]
                res.add(nums1[i]);
                i++;j++;
            }
        }
        return listToArray(res);
    }
    
    private int[] listToArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}
