class Solution {
    public int[] prevPermOpt1(int[] A) {
        if (A == null || A.length <= 1) return A;
        
        int idx1 = 0;
        boolean smallest = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                smallest = false;
                idx1 = i;    
            }
        }

        if (smallest) return A;
        
        int idx2 = idx1 + 1;
        for (int i = idx1 + 2; i < A.length; i++)
            if (A[i] > A[idx2] && A[i] < A[idx1])
                idx2 = i;
        
        int tmp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = tmp;
                
        return A;
    }
}
