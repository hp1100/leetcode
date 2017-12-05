class MovingAverage {

    /** Initialize your data structure here. */
    
    Queue<Integer> queue = new LinkedList<>();
    int q_size = 0;
    double sum = 0;
    
    public MovingAverage(int size) {
        q_size = size;
    }
    
    public double next(int val) {
        double res = 0;
        if(queue.size() < q_size){
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }else{
            sum = sum + val - queue.poll();
            queue.offer(val);
            return sum / q_size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
