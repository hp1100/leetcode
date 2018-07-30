class Solution {
  
    int start, end;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalidorme(s, i ,i); // odd
            extendPalidorme(s, i, i + 1); // even
            //System.out.println(start + ":" + end);
        }
        return s.substring(start, end + 1);
    }
    
    private void extendPalidorme(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > end - start + 1) {
            start = i + 1;
            end = j - 1;
        }

    }
}


// dp
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                  dp[i][j] = true;  
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : false;
                }
                
                if (dp[i][j] == true && j - i + 1 > res.length()) res = s.substring(i, j + 1);
            }
        }
        return res;
    }
}
