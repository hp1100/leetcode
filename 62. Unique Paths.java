public class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2; // total movements
        int k = m - 1; // numbers of steps that need to move down
        double res = 1;
        // here we calculate the total possible path number 
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for(int i = 1; i <= k; i++){
            res = res * (N - i + 1) / i;
        }
        return Integer.valueOf(new java.text.DecimalFormat("0").format(res));
    }
}
