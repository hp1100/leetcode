// dp O(n^2)
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] f = new boolean[len];
        
        f[0] = true;
        
        for(int j = 1; j < len; j++) {
            f[j] = false;
            
            // previous stone i before j
            // last jump from i to j
            for(int i = 0; i < j; i++) {
                if(f[i] && i + nums[i] >= j) {
                    f[j] = true;
                    break;
                }
            }
        }
        
        return f[len - 1];
    }
}

// Greedy O(n)
class Solution {
  public boolean canJump(int[] nums) {
    int leftMostGoodPosition = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= leftMostGoodPosition) {
        leftMostGoodPosition = i;
      }
    }
    
    return leftMostGoodPosition == 0;
  }
}
