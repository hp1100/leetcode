class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 1;
        map.put(s.charAt(0), 0);
        for (int start = 0, end = 1; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                int next = map.get(s.charAt(end)) + 1;
                while (start < next) {
                    map.remove(s.charAt(start++));
                }
            }
            map.put(s.charAt(end), end);
            //System.out.println(start + "-" + end);
            res = Math.max(end - start + 1, res);
        }
        return res;
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 1;
        map.put(s.charAt(0), 0);
        for (int start = 0, end = 1; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) 
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            map.put(s.charAt(end), end);
            res = Math.max(end - start + 1, res);
        }
        return res;
    }
}
