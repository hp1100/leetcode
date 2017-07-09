public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) return 0;
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            int cur = prices[i] - prices[i - 1];
            if(cur > 0) res += cur;
        }
        return res;
    }
}
