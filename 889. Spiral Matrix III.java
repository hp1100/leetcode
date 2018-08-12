    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dirt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> res = new ArrayList<>();
        int len = 0, t = 0;
        res.add(new int[]{r0, c0});
        while (res.size() < R * C) {
            if (t == 0 || t == 2) len++;
            for (int i = 0; i < len; i++) {
                r0 += dirt[t][0];
                c0 += dirt[t][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C)
                    res.add(new int[]{r0, c0});
            }
            t = (t + 1) % 4;
        }
        return res.toArray(new int[R * C][2]);
    }
