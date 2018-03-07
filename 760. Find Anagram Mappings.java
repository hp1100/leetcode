class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
        int[] res = new int[len];
        
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.computeIfAbsent(B[i], k -> new Stack<>()).push(i);
        }
        
        for(int i = 0; i < len; i++) {
            res[i] = map.get(A[i]).pop();
        }
        
        return res;
    }
}
