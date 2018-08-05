// O (log(Math.min(A, B))
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { 
            return findMedianSortedArrays(B,A); // make sure : m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ 
                iMin = i + 1; 
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) {
                iMax = i - 1; 
            }
            else {
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // odd

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; // even
            }
        }
        return 0.0;
    }
}

// O(log(m + n))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2;
    }
    
    public double findKth(int[] A, int Astart, int[] B, int Bstart, int k) {
        if (Astart >= A.length) {
            return B[Bstart + k - 1];
        }
        if (Bstart >= B.length) {
            return A[Astart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[Astart], B[Bstart]);
        }
        int Amid = Integer.MAX_VALUE, Bmid = Integer.MAX_VALUE;
        if (Astart + k/2 -1 < A.length) {
            Amid = A[Astart + k/2 - 1];
        }
        if (Bstart + k/2 -1 < B.length) {
            Bmid = B[Bstart + k/2 - 1];
        }
        if (Amid < Bmid) {
            return findKth(A, Astart + k/2, B, Bstart, k - k/2);
        } else {
            return findKth(A, Astart, B, Bstart + k/2, k - k/2);
        }
        
        
    }
}
