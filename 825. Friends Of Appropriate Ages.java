class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for(int x : ages) count[x]++;
        int ans = 0;
        for(int i = 1; i <= 120; i++) {
            if (i > 14)
                ans += count[i] * (count[i]-1 + count[i-1] - count[i/2 + 7]);
            count[i] += count[i-1];
        }
        return ans;
    }
}
