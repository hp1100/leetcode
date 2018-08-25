class Solution {
    
    int diff = Integer.MAX_VALUE;
    String result = "";
    
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) 
            if (i != 2) 
                set.add(time.charAt(i) - '0');
        if (set.size() == 1) return time;
        
        List<Integer> digits = new ArrayList<>(set);
        int minute = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        
        dfs(digits, "", 0, minute);
        
        return result;
    }
    
    private void dfs(List<Integer> digits, String cur, int pos, int target) {
        if (pos == 4) {
            int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
            if (m == target) return;
            int d = m - target > 0 ? m - target : 1440 + m - target;
            if (d < diff) {
                diff = d;
                result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2) continue;
            if (pos == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23) continue;
            if (pos == 2 && digits.get(i) > 5) continue;
            if (pos == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59) continue;
            dfs(digits, cur + digits.get(i), pos + 1, target);
        }
    }
}
