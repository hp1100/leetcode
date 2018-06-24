class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double ratio = 1;
        double res;
        ArrayList<double[]> qwr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double[] tmp = new double[2];
            tmp[0] = quality[i];
            tmp[1] = wage[i] * 1.0 / quality[i];
            qwr.add(tmp);
        }
        Collections.sort(qwr, (a, b) -> Double.compare(a[1], b[1]));
        PriorityQueue<Double> pq = new PriorityQueue((a, b) -> Double.compare((double)b, (double)a));
        int k = 0, sum = 0;
        while (k < K) {
            ratio = qwr.get(k)[1];
            sum += qwr.get(k)[0];
            pq.offer(qwr.get(k++)[0]);
        }
        res = sum * ratio;
        for(; k < n; k++) {
            ratio = qwr.get(k)[1];
            sum += qwr.get(k)[0];
            pq.offer(qwr.get(k)[0]);
            sum -= pq.poll();
            res = Math.min(res, sum * ratio);
        }
        return res;
    }
}
