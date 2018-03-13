public class ZigzagIterator {
    
    private Iterator<Integer> i, j, tmp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) { tmp = j; j = i; i = tmp; }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

// use Queue 
public class ZigzagIterator {
    
    Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(!v1.isEmpty()) queue.add(v1.iterator());
        if(!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> temp = queue.poll();
        int res = temp.next();
        if(temp.hasNext()) queue.offer(temp);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
