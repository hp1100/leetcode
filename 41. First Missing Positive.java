class Solution {
    public int firstMissingPositive(int[] A) {
                
        int i = 0, n = A.length;
        while (i < n) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > n || A[A[i] - 1] == A[i]) {
                i++;
            } else {
                swap(A, i, A[i] - 1);
            }
        }
        
        i = 0;
        while (i < n && A[i] == i + 1) i++;
        return i + 1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
