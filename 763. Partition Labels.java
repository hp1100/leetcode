class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int[] lastIdx = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIdx[S.charAt(i) - 'a'] = i;
        int start = 0, end = 0, pre = 0;
        while (start < S.length()) {
            pre = end = start;
            
            while (start <= end) {
                end = Math.max(lastIdx[S.charAt(start++) - 'a'], end);
            }
            res.add(end - pre + 1);
            
        }
        return res;
    }
}
