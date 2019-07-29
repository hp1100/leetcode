class Solution {
    public String alphabetBoardPath(String target) {
        char[][] alphabet = new char[5][5];
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy"};
        Map<Character, int[]> pos = new HashMap<>();
        pos.put('z', new int[]{5, 0});
        for (int i = 0; i < 5; i++) 
            alphabet[i] = board[i].toCharArray();
        for (int i = 0; i < 5; i++) 
            for (int j = 0; j < 5; j++) 
                pos.put(alphabet[i][j], new int[]{i, j});
        int[] cur = new int[]{0, 0};
        String res = "";
        for (int i = 0; i < target.length(); i++) {
            int[] next = pos.get(target.charAt(i));
            if (cur[0] != 5 && next[0] == 5) { //'z'
                res += stepsToNext(cur, new int[]{4, 0});
                res += "D";
            } else {
                res += stepsToNext(cur, next);
            }
            res += "!";
            cur = next;
        }
        return res;
    }
    
    private String stepsToNext(int[] cur, int[] target) {
        StringBuilder sb = new StringBuilder();
        int distance_x = target[1] - cur[1];
        int distance_y = target[0] - cur[0];
        //System.out.println(distance_x + ":" + distance_y);
        while (distance_y > 0) {sb.append("D"); distance_y--;}
        while (distance_y < 0) {sb.append("U"); distance_y++;}
        while (distance_x > 0) {sb.append("R"); distance_x--;}
        while (distance_x < 0) {sb.append("L"); distance_x++;}
        //sb.append("!");
        return sb.toString();
    }
}
