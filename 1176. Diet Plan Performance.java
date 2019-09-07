class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int res = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        if (sum > upper) res++;
        else if (sum < lower) res--;
        
        for (int i = k; i < calories.length; i++) {
            sum = sum - calories[i - k] + calories[i];
            if (sum > upper) res++;
            else if (sum < lower) res--;
        }
        return res;
    }
}
