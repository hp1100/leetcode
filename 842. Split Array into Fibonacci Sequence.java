// Time Complexity : O (10 ^ n)
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrack(S, res, 0);
        return res;
    }
    
    private boolean backtrack(String S, List<Integer> res, int idx) {
        if (idx == S.length() && res.size() >= 3) return true;
        
        for (int i = idx; i < S.length(); i++) {
            if (S.charAt(idx) == '0' && i > idx) break;
            
            long num = Long.parseLong(S.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE) break;
            
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) continue;
            
            if (res.size() < 2 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add((int)num);
                if (backtrack(S, res, i + 1))
                    return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
