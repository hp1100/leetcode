class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return helper(blocked, source, target) && helper(blocked, target, source);
    }
    
    private boolean helper(int[][] blocked, int[] source, int[] target) {
        if (blocked == null || blocked.length == 0 || blocked[0].length == 0) return true;
        Set<String> blocked_set = new HashSet<>();
        for (int[] b : blocked) blocked_set.add(b[0] + ":" + b[1]);
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        int m = 1000000, n = 1000000;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (Arrays.equals(cur, target)) return true;
            String str = cur[0] + ":" + cur[1];
            if (blocked_set.contains(str) || visited.contains(str)) continue;
            int x = cur[0], y = cur[1];
            if (x >= 0 && x < m - 1) q.add(new int[]{x + 1, y});
            if (x > 0 && x < m) q.add(new int[]{x - 1, y});
            if (y >= 0 && y < n - 1) q.add(new int[]{x, y + 1});
            if (y > 0 && y < m) q.add(new int[]{x, y - 1});
            visited.add(str);
            if (visited.size() > 20000) return true;
        }
        return false;
    }
}
