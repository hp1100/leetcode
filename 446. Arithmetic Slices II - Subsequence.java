class Solution {
    
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.putIfAbsent(A[i], new LinkedList<>());
            map.get(A[i]).add(i);
        }
        int res = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i).size() >= 3) {
                int size = map.get(i).size();
                res += (1 << size) - 1 - size - size * (size-1) / 2; // 4 ^ n - C(n, 1) - C(n, 2)
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if (A[j] == A[i] || (long)A[j]-A[i] > Integer.MAX_VALUE || (long)A[j]-A[i] < Integer.MIN_VALUE)
                    continue;
                res += helper(A, map, A[j], A[j]-A[i], j);
            }
        }
        return res;
    }
    
    public int helper(int[] A, Map<Integer, List<Integer>> map, int elem, int diff, int index) {
        int res = 0;
        if ((long)elem + diff > Integer.MAX_VALUE || (long)elem + diff < Integer.MIN_VALUE || !map.containsKey(elem + diff))
            return res;
        for (int i : map.get(elem + diff)) {
            if (i > index)
                res += helper(A, map, elem + diff , diff, i) + 1;
        }
        return res;
    }
}
