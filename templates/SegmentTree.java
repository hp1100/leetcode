    class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes = new int[4 * (max)];
            n = max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }

        private void addUtil(int num, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }
            if (l == r) {
                nodes[node]++;
                return;
            }
            int mid = (l + r) / 2;
            addUtil(num, l, mid, 2 * node + 1);
            addUtil(num, mid + 1, r, 2 * node + 2);
            nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
        }

        // Essentialy it tells count of numbers < num.
        public int getCountLessThan(int num) {
            return getUtil(0, num, 0, n, 0);
        }

        private int getUtil(int ql, int qr, int l, int r, int node) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) {
                return nodes[node];
            }

            int mid = (l + r) / 2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    }

// =============================================Segment Tree query range Sum=========================================================

class SegmentTreeNode {
    int start;
    int end;
    int sum; // can be Max/Min
    SegmentTreeNode left = null;
    SegmentTreeNode right = null;
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
    public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }
}

// build tree time: T(n) = 2 * T(n/2) + C => O(n)
public SegmentTreeNode build(int start, int end, int[] nums) {
    if (start == end)
        return new SegmentTreeNode(start, end, nums[start]);

    int mid = (start + end) / 2;
    SegmentTreeNode left = build(start, mid, nums);
    SegmentTreeNode right = build(mid + 1, end, nums);
    return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
}

// update tree time: T(n) = T(n/2) + C => O(logn) 
public void update(SegmentTreeNode node, int index, int value) {
    if (node.start == index && node.end == index) {
        node.sum = value;
        return;
    }
    int mid = (node.start + node.end) / 2;
    if (index <= mid)
        update(node.left, index, value);
    else
        update(node.right, index, value);
    node.sum = node.left.sum + node.right.sum;
}

// query time: O(logn + k)
public int query(SegmentTreeNode node, int i, int j) {
    if (node.start == i && node.end == j) return node.sum;
    
    int mid = (node.start + node.end) / 2;
    
    if (j <= mid)
        return query(node.left, i, j);
    else if (i > mid)
        return query(node.right, i, j);
    else
        return query(node.left, i, mid) + query(node.right, mid + 1, j);
}

// =============================================Segment Tree query range Max====================================https://leetcode.com/playground/NqrioxPF

class Solution {
    // build tree time: T(n) = 2 * T(n/2) + C => O(n)
    public SegmentTreeNode build(int start, int end, int[] nums) {
        if (start == end)
            return new SegmentTreeNode(start, end, nums[start]);

        int mid = (start + end) / 2;
        SegmentTreeNode left = build(start, mid, nums);
        SegmentTreeNode right = build(mid + 1, end, nums);
        return new SegmentTreeNode(start, end, Math.max(left.max, right.max), left, right);
    }

    // update tree time: T(n) = T(n/2) + C => O(logn) 
    public void update(SegmentTreeNode node, int index, int value) {
        if (node.start == index && node.end == index) {
            node.max = value;
            return;
        }
        int mid = (node.start + node.end) / 2;
        if (index <= mid)
            update(node.left, index, value);
        else
            update(node.right, index, value);
        node.max = Math.max(node.left.max, node.right.max);
    }

    // query time: O(logn + k)
    public int query(SegmentTreeNode node, int i, int j) {
        if (node.start == i && node.end == j) return node.max;

        int mid = (node.start + node.end) / 2;

        if (j <= mid)
            return query(node.left, i, j);
        else if (i > mid)
            return query(node.right, i, j);
        else
            return Math.max(query(node.left, i, mid), query(node.right, mid + 1, j));
    }
}
