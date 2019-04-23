class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++)
        	preSum[i] = preSum[i - 1] + A[i - 1];
        int res = 0;
        for (int i = 0; i + L <= len; i++) {
        	int L_Sum = preSum[i + L] - preSum[i];
        	int M_Sum = Math.max(maxSumSubarray(preSum, 0, i, M), maxSumSubarray(preSum, i + L, len, M));
        	res = Math.max(res, L_Sum + M_Sum);
            //System.out.println(res + ":" + i + ":" + L_Sum + ":" + M_Sum);
        }
        return res;
    }

    private int maxSumSubarray(int[] Sum, int i, int j, int M) {
    	int res = 0;
    	for (int k = i; k + M <= j; k++) {
    		res = Math.max(res, Sum[k + M] - Sum[k]);
    	}
    	return res;
    }
}
