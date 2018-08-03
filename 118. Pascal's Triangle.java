class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++)
            add(i, res);
        return res;
    }
    
    private void add(int size, List<List<Integer>> res) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            //System.out.println(size + ":" + i);
            if (i == 0 || i == size - 1) {
                row.add(1);
            } else {
                row.add(res.get(size - 2).get(i - 1) + res.get(size - 2).get(i));
            }
        }
        res.add(row);
    }
}
