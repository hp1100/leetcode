class Solution {
    public int numSimilarGroups(String[] A) {
        if (A.length < 2) return A.length;
        if (A[0].equals(A[1])) return 1;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) continue;
            String str = A[i];
            A[i] = null;
            res++;
            dfs(A,str);
        }
        return res;
    }
    public void dfs(String[] A, String str) {
        for (int i=0; i<A.length; i++) {
            if (A[i] == null) continue;
            if (helper(str,A[i])) {// both string str and A[i] belong in same group
                String s = A[i];
                A[i] = null;
                dfs(A,s);
            }
        }
    }
    public boolean helper(String s,String t){
        int res = 0, i = 0;
        while (res <= 2 && i < s.length()) {
            if (s.charAt(i) != t.charAt(i)) res++;
            i++;
        }
        return res == 2;
    }
}
