class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        int oneStepBefore = cost[1], twoStepBefore = cost[0];
        for (int i = 2; i < cost.length; i++) {
            int curCost = Math.min(twoStepBefore, oneStepBefore) + cost[i];
            //System.out.println(curCost);
            twoStepBefore = oneStepBefore;
            oneStepBefore = curCost;
        }
        //System.out.println(twoStepBefore);
        //System.out.println(oneStepBefore);
        return Math.min(oneStepBefore, twoStepBefore);
    }
    //0 1 1 0
    //0 1 1 1
}
