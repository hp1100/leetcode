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

// 2018/8/4 two for loop (head -> tail) + (tail -> head)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] waters = new int[n];
        for (int i = 0, heightest = 0; i < n; i++) {
            if (height[i] <= heightest) {
                waters[i] = heightest - height[i];
            } else {
                heightest = height[i];
            }
        }
        int sum = 0;
        for (int i = n - 1, heightest = 0; i >= 0; i--) {
            if (height[i] <= heightest) {
                waters[i] = Math.min(waters[i], heightest - height[i]);
            } else {
                heightest = height[i];
                waters[i] = 0;
            }
            sum += waters[i];
        }
        return sum;
    }
}
