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
