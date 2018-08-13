class Solution {
    int div = 1000000007;
    
    public int countPalindromicSubsequences(String S) {    
        TreeSet[] characters = new TreeSet[4];
        int len = S.length();
        
        for (int i = 0; i < 4; i++) characters[i] = new TreeSet<Integer>();
        
        for (int i = 0; i < len; i++) {
            int c = S.charAt(i) - 'a';
            characters[c].add(i);
        }
        Integer[][] dp = new Integer[len + 1][len + 1];
        return memo(S, characters, dp, 0, len);
    }
    
    public int memo(String S,TreeSet<Integer>[] characters,Integer[][] dp,int start,int end){
        if (start >= end) return 0;
        if (dp[start][end] != null) return dp[start][end];
       
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            Integer new_start = characters[i].ceiling(start);
            Integer new_end = characters[i].lower(end);
            if (new_start == null || new_start >= end) continue;
            ans++;
            if (new_start != new_end) ans++;
            ans += memo(S, characters, dp, new_start + 1, new_end);

        }
        dp[start][end] = (int)(ans % div);
        return dp[start][end];
    }
}
