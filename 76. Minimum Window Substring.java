class Solution {
    
    class ValIdx {
        char ch;
        int idx;
        public ValIdx (char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
    
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, new LinkedList<>());
        }
        PriorityQueue<ValIdx> pq = new PriorityQueue<>((a, b) -> a.idx - b.idx);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.get(s.charAt(i)).offer(i);
        }
        int curMaxIdx = 0;
        for (char ch : t.toCharArray()) {
            Queue<Integer> q = map.get(ch);
            if (q.isEmpty()) return "";
            int curIdx = q.poll();
            curMaxIdx = Math.max(curIdx, curMaxIdx);
            pq.offer(new ValIdx(ch, curIdx));
        }
        int minLen = curMaxIdx - pq.peek().idx;
        int resIdx = curMaxIdx;
        while (true) {
            ValIdx vi = pq.poll();
            char c = vi.ch;
            if (map.get(c).isEmpty()) break;
            int nextIdx = map.get(c).poll();
            curMaxIdx = Math.max(curMaxIdx, nextIdx);
            pq.offer(new ValIdx(c, nextIdx));
            if (curMaxIdx - pq.peek().idx < minLen) {
                minLen = curMaxIdx - pq.peek().idx;
                resIdx = curMaxIdx;
            }
        }
        return s.substring(resIdx - minLen, resIdx + 1);
    }
}
