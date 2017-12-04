class Solution {
    public boolean checkPossibility(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] <= nums[i+1]) continue;
            list.add(i);
        }
        if(list.size() > 1) return false;
        if(list.size() == 0) return true;
        int idx = list.get(0);
        if(idx == 0 || idx == nums.length - 2) return true;
        return nums[idx-1] <= nums[idx+1] || nums[idx] <= nums[idx+2];
    }
}
