class Solution {
    public String rearrangeString(String S, int k) {
        int n = S.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray())  map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry: map.entrySet())   pq.offer(entry);
        
        char[] res = new char[n];
        int idx = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char ch = entry.getKey();
            int times = entry.getValue();
            for (int i = 0; i < times; i++) {
                res[idx % n] = ch;
                idx += k;
                if (res[idx % n] != 0) idx++;
            }
        }
        String ans = String.valueOf(res);
        return check(ans, k) ? ans : "";
    }
    
    private boolean check(String s, int k) { // check the result is valid
        int lo = 0, hi = 0;
        Set<Character> set = new HashSet<>();
        while(hi < k && hi < s.length()) {
            if (!set.add(s.charAt(hi++))) return false;
        }    
        while(hi < s.length()) {
            set.remove(s.charAt(lo++));
            if (!set.add(s.charAt(hi++))) return false;
        }
        return true;
    }
}
