class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0, prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            if (map.containsKey(prefix)) res += map.get(prefix);
            map.put(prefix,map.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}
