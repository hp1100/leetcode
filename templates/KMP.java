    private boolean match(String s, String p) {
        int m = s.length(), n = p.length();
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        int[] dp = new int[m];
        int[] next = getNext(p);

        int j = 0;
        for (int i = 0; i < m && j < n; i++) {
            while (j > 0 && a[i] != b[j]) j = next[j - 1];
            if (a[i] == b[j]) j++;
            dp[i] = j;
        }

        return j == n;
    }

    private int[] getNext(String p) {
        char[] chs = p.toCharArray();
        int n = p.length();
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && chs[i] != chs[j]) j = next[j - 1];
            if (chs[i] == chs[j]) j++;
            next[i] = j;
        }
        return next;
    }
