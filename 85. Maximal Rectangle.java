public class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[] left = new int[n], right = new int[n], height = new int[n];
//         int maxA = 0;
//         for(int i = 0; i < m; i++){
//             // compute height
//             for(int j = 0; j < n; j++){
//                 if(matrix[i][j] == '1') hegiht[j]++;
//                 else height[j] = 0;
//             }
//             // compute left (left -> right)
//             for(int j = 0; j < n; j++){
                
//             }
//             // compute right (right -> left)
//             for(int j = n - 1; j >= 0; j--){
                
//             }
//             // compute the area of rectangle (can do this from either side)
//             // area = [right(i,j) - left(i,j)]*height(i,j)
//             for(int j = 0; j < n; j++){
//                 maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
//             }
//         }
//         return maxA;
//     }
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxA = 0;
        for(int i = 0; i < m; i++){
            // change problem to Largest Rectangle In Histogram
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            //
            Stack<Integer> stack = new Stack<>();
            
            for(int j = 0; j <= n; j++){
                int h = (j == n ? 0 : heights[j]);
                
                if(stack.isEmpty() || h >= heights[stack.peek()]){
                    stack.push(j);
                }else{
                    int tp = stack.pop();
                    maxA = Math.max(maxA, heights[tp] * (stack.isEmpty() ? j : j - 1 - stack.peek()));
                    j--;
                }
            }
        }
        return maxA;
    }
}
