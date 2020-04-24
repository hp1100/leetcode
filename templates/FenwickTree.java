class FenwickTree {
    private int[] tree;
    private int len;

    public FenwickTree(int n) {
        this.len = n;
        tree = new int[n + 1];
    }

    /**
     * 单点更新：将 index 这个位置 + delta
     *
     * @param i
     * @param delta
     */
    public void update(int i, int delta) {
        // 从下到上，最多到 size，可以等于 size
        while (i <= this.len) {
            tree[i] += delta;
            i += lowbit(i);
        }
    }


    // 区间查询：查询小于等于 tree[index] 的元素个数
    // 查询的语义是「前缀和」
    public int query(int i) {
        // 从右到左查询
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public int lowbit(int x) {
        return x & (-x);
    }
}
