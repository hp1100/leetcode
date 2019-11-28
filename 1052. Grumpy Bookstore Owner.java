class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int diff = 0;
        
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1)
                diff += customers[i];
            else
                sum += customers[i];
        }
        
        int max = diff;
        
        for (int i = X; i < customers.length; i++) {
            if (grumpy[i - X] == 1) diff -= customers[i - X];
            if (grumpy[i] == 1) diff += customers[i];
            max = Math.max(max, diff);
            if (grumpy[i] == 0) sum += customers[i];
        }
        
        return sum + max;
    }
}
