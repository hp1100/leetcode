class Solution {
    public int numPrimeArrangements(int n) {
        int cnt = countPrimes(n);
        //System.out.println(cnt);
        long ans = 1;
        for (int i = 1; i <= cnt; ++i) // (# of primes)!
            ans = ans * i % 1_000_000_007;
        for (int i = 1; i <= n - cnt; ++i) // (# of non-primes)!
            ans = ans * i % 1_000_000_007;
        return (int)(ans);
    }
    
    private int countPrimes(int n) {
        n = n + 1;
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
