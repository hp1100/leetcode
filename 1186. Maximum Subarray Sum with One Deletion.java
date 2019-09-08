class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        // Maximum sum subarrays in forward and  
        // backward directions 
        int fw[] = new int[n]; 
        int bw[] = new int[n]; 
  
        // Initialize current max and max so far. 
        int cur_max = arr[0], max_so_far = arr[0]; 
  
        // calculating maximum sum subarrays in forward 
        // direction 
        fw[0] = arr[0]; 
  
        for (int i = 1; i < n; i++) { 
  
            cur_max = Math.max(arr[i], cur_max + arr[i]); 
            max_so_far = Math.max(max_so_far, cur_max); 
  
            // storing current maximum till ith, in 
            // forward array 
            fw[i] = cur_max; 
        } 
  
        // calculating maximum sum subarrays in backward 
        // direction 
        cur_max = max_so_far = bw[n - 1] = arr[n - 1]; 
          
        for (int i = n - 2; i >= 0; i--) { 
  
            cur_max = Math.max(arr[i], cur_max + arr[i]); 
            max_so_far = Math.max(max_so_far, cur_max); 
  
            // storing current maximum from ith, in 
            // backward array 
            bw[i] = cur_max; 
        } 
  
        /* Initializing final ans by max_so_far so that, 
        case when no element is removed to get max sum 
        subarray is also handled */
        int fans = max_so_far; 
  
        // choosing maximum ignoring ith element 
        for (int i = 1; i < n - 1; i++) 
            fans = Math.max(fans, fw[i - 1] + bw[i + 1]); 
  
        return fans; 
    }
}
