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

//===================================================================================================================

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

// update tree time: T(n) = T(n/2) + C => O(lgn) 
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
    
    
}
