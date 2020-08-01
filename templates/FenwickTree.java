class FenwickTree {
    private int[] tree;
    private int len;

    public FenwickTree(int n) {
        this.len = n;
        tree = new int[n + 1];
    }
    
    // O(n) 建树：
    // 每一个节点的值是由所有与自己直接相连的儿子的值求和得到的。
    // 因此可以倒着考虑贡献，即每次确定完儿子的值后，用自己的值更新自己的直接父亲。
    public void init(int[] arr) {
        for (int i = 1; i <= len; i++) {
            tree[i] += arr[i - 1];
            int j = i + lowbit(i);
            if (j <= len) tree[j] += tree[i];
        }
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
