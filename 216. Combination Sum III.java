class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(k, n, 1, res, new ArrayList<>());
        return res;
    }
    
    private void backtrack(int k, int n, int m, List<List<Integer>> res, List<Integer> cur) {
        if (n < 0) return;
        if (k == 0) {
            if (n != 0) return;
            res.add(new ArrayList(cur));
            return;
        }
        
        for (int i = m; i <= 9; i++) {
            cur.add(i);
            backtrack(k - 1, n - i, i + 1, res, cur);
            cur.remove(cur.size() - 1)
        }
    }
}
