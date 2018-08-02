class HitCounter {
    
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
        return queue.size();
    }
}

//Follow up:
//What if the number of hits per second could be very large? Does your design scale?

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */


class HitCounter {
    Queue<Tuple> queue;
    int total;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
        total = 0;        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (!queue.isEmpty() && queue.peek().time == timestamp) {
            queue.peek().hits ++;
        } else {
            queue.add(new Tuple(timestamp, 1));
        }
        total ++;        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek().time <= timestamp - 300) {
            total -= queue.poll().hits;
        }
        return total;        
    }
    
    class Tuple{
        int time; 
        int hits;
        public Tuple(int time, int hits) {
            this.time = time;
            this.hits = hits;
        }
    }
}
