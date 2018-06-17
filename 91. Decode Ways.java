// Stupid but work
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(Character.getNumericValue(s.charAt(0)) == 0) return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        int pre = Character.getNumericValue(s.charAt(0));
        for(int i = 1; i < n; i++) {
            int cur = Character.getNumericValue(s.charAt(i));
            if((pre == 0 || pre > 2) && cur == 0)
                return 0;
            else if(cur == 0)
                dp[i] = (i == 1 ? 1 : dp[i - 2]);
            else if(pre == 1)
                dp[i] = (i == 1 ? 2 : (dp[i - 1] + dp[i - 2]));
            else if(pre <= 2 && pre > 0 && cur <= 6 && cur > 0) 
                dp[i] = (i == 1 ? 2 : (dp[i - 1] + dp[i - 2]));
            else
                dp[i] = dp[i - 1];
            pre = cur;
        }
        return dp[n - 1];
    }
}
