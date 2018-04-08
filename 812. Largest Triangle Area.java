class Solution {
    public double largestTriangleArea(int[][] points) {
        
        double max = 0;
        
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, calculateArea(new int[][]{points[i], points[j], points[k]}));
                }
            }
        }
        
        return max;
        
    }
    
    private double calculateArea(int[][] points) {
        return Math.abs(0.5 * (points[0][0] * (points[1][1] - points[2][1]) +
                               points[1][0] * (points[2][1] - points[0][1]) +
                               points[2][0] * (points[0][1] - points[1][1])));
    }
}
