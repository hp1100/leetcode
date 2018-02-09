class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        int[] res = nums.clone();
        
        if(a != 0){
            double vertex = - b / (2.0 * a);
            int idx = 0;
            // find first element which is greater or equal to vertex
            while(idx < nums.length){
                if(nums[idx] >= vertex)
                    break;
                else
                    idx++;
            }
            System.out.println(idx);
            // 
            int lo = idx - 1, hi = idx, cur = 0;
            while(lo >= 0 || hi < nums.length){
                if(lo < 0){
                    res[cur++] = nums[hi++];
                }else if(hi >= nums.length){
                    res[cur++] = nums[lo--];
                }else if(vertex - nums[lo] <= nums[hi] - vertex){
                    res[cur++] = nums[lo--];
                }else{
                    res[cur++] = nums[hi++];
                }
            }
        }
        
        if(a < 0 || (a == 0 && b < 0))
            res = reverseArray(res);
        // x -> y
        for(int i = 0; i < res.length; i++){
            res[i] = a * res[i] * res[i] + b * res[i] + c;
        }
        
        return res;
    }
    
    private int[] reverseArray(int[] arr){
        int[] res = new int[arr.length];
        int idx = 0;
        for(int i = arr.length - 1; i >= 0; i--)
            res[idx++] = arr[i];
        return res;
    }
}
