public class Solution {
    public int trap(int[] height) {
        int res = 0;
        for(int i = 1; i < height.length - 1; i++){
            int max_left = 0, max_right = 0;
            for(int j = i; j >= 0; j--)
                max_left = Math.max(max_left, height[j]);
            for(int j = i; j < height.length; j++)
                max_right = Math.max(max_right, height[j]);
            //int temp = Math.min(max_left, max_right) - height[i];
            //System.out.println(temp);
            res += Math.min(max_left, max_right) - height[i];
        }
        return res;
    }
}
