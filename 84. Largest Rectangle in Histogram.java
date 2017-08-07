public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxA = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);
            }else{
                int top = stack.pop();
                //System.out.println(i + " : " + (stack.isEmpty() ? i : i - 1 - stack.peek()));
                maxA = Math.max(maxA, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxA;
    }
}
