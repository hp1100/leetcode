class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int res = 0;
        int len = 2;
        for (int i = 2; i < n; i++) {
            
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                len++;
                //System.out.println(len);
            }else {
                res += (len - 1) * (len - 2) / 2;
                len = 2;
                //i--;
            }
        }
        res += (len - 1) * (len - 2) / 2;
        return res;
    }
}
