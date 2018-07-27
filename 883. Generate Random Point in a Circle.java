class Solution {
    
    double x, y, r;
    Random rand;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        rand = new Random();
    }
    
    public double[] randPoint() {
        double i = x - r + 2 * rand.nextDouble() * r;
        double j = y - r + 2 * rand.nextDouble() * r;
        while (!helper(i, j)) {
            i = x - r + 2 * rand.nextDouble() * r;
            j = y - r + 2 * rand.nextDouble() * r;
        }
        return new double[]{i, j};
    }
    
    private boolean helper(double i, double j) {
        return (i - x) * (i - x) + (j - y) * (j - y) <= r * r;
    }
}
