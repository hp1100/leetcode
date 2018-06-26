class ExamRoom {
    
    private TreeMap<Integer, Integer> room;
    private int size;

    public ExamRoom(int N) {
        this.size = N;
        this.room = new TreeMap<>();
    }
    
    public int seat() {
        if (room.size() == 0) {
            room.put(0, 1);
            return 0;
        }
        int n = this.size;
        int pre = -1, maxLen = 0, res = 0;
        boolean firstTime = true;
        for (Map.Entry<Integer, Integer> entry: room.entrySet()) {
            int key = entry.getKey();
            //System.out.println()
            int len = key - pre;
            if (len % 2 == 1) len -= 1;
            if (len > maxLen) {
                res = (pre == -1 ?  0 : (pre + key) / 2);
                maxLen = len;
            }
            pre = key;
            //firstTime = false;
        }
        if (n - pre > maxLen) {
            res = n - 1;
        }
        room.put(res, 1);
        return res;
    }
    
    public void leave(int p) {
        room.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
