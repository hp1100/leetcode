class Solution {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        
        int n = N;
        int M = 0;
        
        while (n > 0) {
            int r = n % 10;
            if (!map.containsKey(r)) return false;
            M = M * 10 + map.get(r);
            n /= 10;
        }

        return M != N;
    }
}
