// Initial result array.
// Loop twice on the string S.
// First loop find shortest distant to character on left.
// Second loop find shortest distant to character on right.
    
public int[] shortestToChar(String S, char C) {
    int n = S.length();
    int[] res = new int[n];
    int pos = -n;
    for (int i = 0; i < n; ++i) {
        if (S.charAt(i) == C) pos = i;
        res[i] = i - pos;
    }
    for (int i = n - 1; i >= 0; --i) {
        if (S.charAt(i) == C)  pos = i;
        res[i] = Math.min(res[i], Math.abs(i - pos));
    }
    return res;
}

// 2018/06/21
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int left = -1, right = -1;
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0, j = S.length() - 1; i < S.length() && j >= 0; i++, j--) {
            if (S.charAt(i) == C) left = i;
            if (S.charAt(j) == C) right = j;
            if (left != -1) res[i] = Math.min(res[i], i - left);
            if (right != -1) res[j] = Math.min(res[j], Math.abs(right - j));
            
        }
        return res;
    }
}
