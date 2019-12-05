class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}



class Solution {
    public int[][] kClosest(int[][] points, int K) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]); //maximum heap
        
//         for (int[] point: points) {
            
//             pq.offer(point);
//             if (pq.size() > K) pq.poll();
//         }
        
//         int[][] res = new int[pq.size()][2];
//         for (int i = 0; i < res.length; i++) {
//             int[] point = pq.poll();
//             res[i][0] = point[0];
//             res[i][1] = point[1];
//         }
        
//         return res;
        
        return Arrays.stream(points).sorted((a, b) -> a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]).limit(K).toArray(int[][]::new);
    }
}
