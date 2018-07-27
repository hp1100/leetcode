class Solution {
    
    int sum = 0;
    TreeMap<Integer, Integer> map;

    public Solution(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int key = map.ceilingKey(rand.nextInt(sum) + 1); // can not be rand.nextInt(size + 1)
        return map.get(key);
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
