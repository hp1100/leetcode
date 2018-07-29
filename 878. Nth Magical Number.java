class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        long lo = Math.min(A, B), hi = (long)Math.pow(10, 14), lcm = lcm(A, B);
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid / A + mid / B - mid / lcm < N)
                lo = mid + 1;
            else
                hi = mid;
        }
        return (int)(lo % (Math.pow(10, 9) + 7));
    }
    
    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
