class Solution {
        
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L, mod = (long) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; ++j)
                if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j]))
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
        }
        for (long v : dp.values()) res = (res + v) % mod;
        return (int) res;
    }
    
}
