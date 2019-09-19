class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) return 0;
        // deadneds can be just added in vistied
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
        if (deadend.contains(start)) return -1;
        char[] slots = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            for (int size = q.size(); size > 0; size--) {
                String cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < 10; j += 8) { // 1 for right, 9 for left, twice
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(i, slots[(cur.charAt(i) - '0' + j) % 10]);
                        String next = sb.toString();
                        if (next.equals(target)) return res;
                        if (deadend.contains(next)) continue;
                        if (visited.add(next)) q.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
