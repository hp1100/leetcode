class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int[][] pos = new int[][]{{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
        StringBuilder sb = new StringBuilder();
        for (int[] row : board)
            for (int col: row)
                sb.append(col);
        if(sb.toString().equals(target)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(sb.toString());
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            for (int size = q.size(); size > 0; size--) {
                String cur = q.poll();
                char[] cur_char = cur.toCharArray();
                int zero_idx = 0;
                for (int i = 0; i < 6; i++)
                    if (cur_char[i] == '0')
                        zero_idx = i;
                for (int next : pos[zero_idx]) {
                    String next_pos = swap(cur_char, zero_idx, next);
                    if (visited.add(next_pos)) {
                        if (next_pos.equals(target)) return res;
                        q.offer(next_pos);
                    }
                }
            }

        }
        return -1;
    }
    
    private String swap(char[] ch, int i, int j) {
        char[] char_new = Arrays.copyOf(ch, 6);
        char temp = char_new[i];
        char_new[i] = char_new[j];
        char_new[j] = temp;
        return new String(char_new);
    }
}
