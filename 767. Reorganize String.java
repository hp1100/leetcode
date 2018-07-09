class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry: map.entrySet())
            pq.offer(entry);
        if (pq.peek().getValue() > (n - 1) / 2 + 1) return "";
        
        char[] res = new char[n];
        int idx = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char ch = entry.getKey();
            int times = entry.getValue();
            for (int i = 0; i < times; i++) {
                res[idx % n] = ch;
                idx += 2;
                if (res[idx % n] != 0) idx++;
            }
        }
        return String.valueOf(res);
    }
}
