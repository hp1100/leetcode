//============================2017.12.14================================
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();
        if(nums.length == 1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i = 0; i<nums.length; i++){
            int a = nums[i];
            while(i+1 < nums.length && (nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
}



//============================2019.11.6================================
class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new LinkedList<>();
        
        int lo = 0, hi = 0;
        
        while (hi <= nums.length) {
            if (hi == lo || (hi < nums.length && nums[hi] - nums[hi - 1] == 1)) {
                hi++;
                continue;
            }
            
            if (hi - lo == 1) res.add(nums[lo] + "");
            if (hi - lo > 1) res.add(nums[lo] + "->" + nums[hi - 1]);
            lo = hi;
        }
        
            
        return res;
    }
}
