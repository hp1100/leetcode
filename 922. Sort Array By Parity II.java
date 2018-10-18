class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while (i < A.length && j < A.length) {
            if (A[i] % 2 != 0) {
                while (A[j] % 2 != 0) j += 2;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } 
            i += 2;
        }
        return A;
    }
}
