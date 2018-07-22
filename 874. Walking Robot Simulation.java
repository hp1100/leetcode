class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles)
            map.computeIfAbsent(obstacle[0], k -> new HashSet<>()).add(obstacle[1]);
        System.out.println(map);
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0, res = 0;
        boolean flag = true;
        for (int command : commands) {
            if (command == -1) {
                d = (d == 3) ? 0 : d + 1;
            } else if (command == -2) {
                d = (d == 0) ? 3 : d - 1;
            } else {
                int i = 0;
                // first step
                if (flag && i < command) {
                    x += direction[d][0];
                    y += direction[d][1];
                    flag = false;
                    i++;
                }
                while (i++ < command && (!map.containsKey(x) || !map.get(x).contains(y))) {
                    x += direction[d][0];
                    y += direction[d][1];
                }
                if (map.containsKey(x) && map.get(x).contains(y)) {
                    x -= direction[d][0];
                    y -= direction[d][1];
                }
                res = Math.max(x * x + y * y, res);
            }
        }
        return res;
    }
}
