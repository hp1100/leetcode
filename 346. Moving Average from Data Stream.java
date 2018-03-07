class MovingAverage {
    
    public Queue<Integer> queue;
    public int size;
    public int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(queue.size() == size)
            sum -= queue.poll();
        queue.offer(val);
        sum += val;
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
