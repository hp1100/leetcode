class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        dfs(res, s, "", 0, 4);
        return res;
    }
    
    public void dfs(List<String> res, String s, String cur, int idx, int point) {
        int num = 0;
        if (point == 0) {
            if (idx == s.length())
                res.add(cur.substring(0, cur.length() - 1));
            return;
        }
        if (idx < s.length() && s.charAt(idx) == '0') {
            dfs(res, s, cur + "0.", idx + 1, point - 1);
        } else {
            for (int i = idx; i < idx + 3 && i < s.length(); i++) {
                num = num * 10 + Character.getNumericValue(s.charAt(i));
                if (num > 255) continue;
                dfs(res, s, cur + num + ".", i + 1, point - 1);
            }
        }
    }
}
