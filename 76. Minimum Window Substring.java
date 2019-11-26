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


//=============================2019/11/26===============================
    
    
    class Solution {
    
    public String minWindow(String s, String t) {
        int[] s_a = new int[128];
        int[] t_a = new int[128];
        
        for (int i = 0; i < t.length(); i++) {
            t_a[t.charAt(i)]++;
        }
        
        int right = 0, left = 0;
        boolean exist = false;
        int[] idxs = new int[2];
        idxs[1] = s.length();
        
        while (right < s.length()) {
            s_a[s.charAt(right++)]++;

            while (left < right && cover(s_a, t_a)) {
                exist = true;
                if (right - left < idxs[1] - idxs[0]) {
                    idxs[0] = left;
                    idxs[1] = right;
                }
                s_a[s.charAt(left++)]--;
            }
            
        }
        return exist ? s.substring(idxs[0], idxs[1]) : "";
    }
    
    private boolean cover(int[] s, int[] t) {
        for (int i = 0; i < 128; i++) 
            if (s[i] < t[i])
                return false;
        return true;
    }
}
