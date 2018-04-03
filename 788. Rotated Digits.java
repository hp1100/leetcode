class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for(int i = 1; i <= N; i++) {
            if(isX(i))
                res++;
        }
        return res;
    }
    
    private boolean isX(int num) {
        boolean same = true;
        while(num > 0) {
            int reminder = num % 10;
            if(reminder == 3 || reminder == 4 || reminder == 7) return false;
            else if(reminder == 2 || reminder == 5 || reminder == 6 || reminder == 9) same = false;
            num /= 10;
        }
        
        return !same;
    }
}
