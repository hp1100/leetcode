// "Note that we do not have the operation where all 100 ml’s of soup B are used first. "
// It’s obvious that A is easier to be empty than B. And when N gets bigger, we have less chance to run out of B first.
// So as N increases, our result increases and it gets closer to 100 percent = 1.

// "Answers within 10^-6 of the true value will be accepted as correct."
// Now it’s obvious that when N is big enough, result is close enough to 1 and we just need to return 1.
// When I incresed the value of N, I find that:
// When N = 4800, the result = 0.999994994426
// When N = 4801, the result = 0.0.999995382315
// So if N>= 4800, just return 1 and it will be enough.


class Solution {
    double[][] dp = new double[200][200];
    public double soupServings(int N) {
        return N > 4800 ? 1 : f((N + 24) / 25, (N + 24) / 25);
    }
    
    private double f(int a, int b) {
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1;
        if(b <= 0) return 0;
        if(dp[a][b] > 0) return dp[a][b];
        dp[a][b] = 0.25 * (f(a - 4, b) + f(a - 3, b - 1) + f(a - 2, b - 2) + f(a - 1, b - 3));
        return dp[a][b];
    }
}
