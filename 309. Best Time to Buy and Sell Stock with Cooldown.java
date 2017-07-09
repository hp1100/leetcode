public class Solution {
    public int maxProfit(int[] prices) {
        //buy[i] = max(buy[i-1], sell[i-2] - prices[i])
        //sell[i] = max(sell[i-1], buy[i-1] + prices[i])
        if(prices == null || prices.length == 0 || prices.length == 1) return 0;
        if(prices.length == 2) return Math.max(0, prices[1] - prices[0]);
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = 0 - prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for(int i = 2; i < len; i++){
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }
        return Math.max(0, sell[len - 1]);
    }
}
