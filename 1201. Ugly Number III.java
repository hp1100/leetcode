class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        int lo = 1, hi = 2000000000;
        
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            
            int sum = (int)(mid/a + mid/b + mid/c - mid/lcm(a,b) - mid/lcm(a,c) - mid/lcm(b,c) + mid/lcm(lcm(a,b), c));

            if (sum < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
    
    

    long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
