// O(nlogk)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[][] diff = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            diff[i][0] = arr[i];
            diff[i][1] = Math.abs(arr[i] - x);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, 
            (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] d : diff)
            pq.offer(d);
        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = pq.poll()[0];
        Arrays.sort(res);
        List<Integer> list = new LinkedList<>();
        for(int i : res){
            System.out.print(i);
            list.add(i);
        }
        return list;
    }
}

//O(logn + 2k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find x first
        int idx = Arrays.binarySearch(arr, x);
        if(idx < 0)
            idx = -(idx + 1);
        // k ~ x ~ k
        int lo = Math.max(0, idx - k);
        int hi = Math.min(arr.length - 1, idx + k);
        // 2k -> k
        while(hi - lo > k - 1){
            if(arr[hi] - x >= x - arr[lo]){
                hi--;
            }else{
                lo++;
            }
        }
        
        return Arrays.stream(Arrays.copyOfRange(arr, lo, lo + k)).boxed().collect(Collectors.toList());
    }
}

// O(log(N-K) + K)
class Solution {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }
}

