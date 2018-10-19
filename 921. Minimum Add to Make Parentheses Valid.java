class Solution {
    public int minAddToMakeValid(String S) {
        int res = 0, count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) res++;
                else count--;
            }
        }
        return res + count;
    }
}
