class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (isIncreasing(x)) return false;
        
        if (isDecreasing(x, 2)) return false;
        
        int i = 2;
        while (x[i] > x[i - 2]) i++;
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) || (i == 3 && x[i] == x[i - 2])) {

            if (i == x.length - 1) return false;
            else if (x[i + 1] >= x[i - 1] - x[i - 3]) return true;
            else return !isDecreasing(x, i + 1);
        } else {
            return !isDecreasing(x, i + 1);
        }
        
    }
    
    private boolean isIncreasing(int[] x) {
        for (int i = 2; i < x.length; i++) {
            if (x[i] <= x[i - 2]) return false;
        }
        return true;
    }
    
    private boolean isDecreasing(int[] x, int start) {
        for (int i = start; i < x.length; i++) {
            if (x[i] >= x[i - 2]) return false;
        }
        return true;
    }
}
