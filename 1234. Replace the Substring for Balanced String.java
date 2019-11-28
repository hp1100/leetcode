class Solution {
    
    public int balancedString(String s) {
        int res = Integer.MAX_VALUE;
        int n = s.length();
        int i = 0;
        int[] count = new int[26];
        for (int j = 0; j < n; j++)
            count[s.charAt(j) - 'A']++;
        for (int j = 0; j < n; j++) {
            count[s.charAt(j) - 'A']--;
            while (i < n && count['Q'-'A'] <= n / 4 && count['W'-'A'] <= n / 4 && count['E'-'A'] <= n / 4 && count['R'-'A'] <= n / 4) {
                res = Math.min(res, j - i + 1);
                ++count[s.charAt(i++) - 'A'];
            }
        }
        return res;
    }
}
