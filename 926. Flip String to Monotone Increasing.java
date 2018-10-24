class Solution {
    public int minFlipsMonoIncr(String S) {
        int count = 0, flip = 0;
        for (char c : S.toCharArray())
            if (c == '1') count++;
        int res = S.length() - count;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                res = Math.min(res, flip + S.length() - i - 1 - count);
            } else {
                flip++;
                count--;
                res = Math.min(res, flip + S.length() - i - 1 - count);
            }
        }
        return res;
    }
}
