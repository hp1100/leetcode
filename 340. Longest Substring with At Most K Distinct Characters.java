class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> letters = new HashMap<>();
        
        int res = 0, right = 0, left = 0;
        
        while (right < s.length()) {
            char right_char = s.charAt(right);
            if (letters.containsKey(right_char) || letters.size() < k) {
                letters.put(right_char, letters.getOrDefault(right_char, 0) + 1);
                right++;
                res = Math.max(res, right - left);
            } else {
                while (letters.get(s.charAt(left)) > 1) {
                    char left_char = s.charAt(left);
                    letters.put(left_char, letters.get(left_char) - 1);
                    left++;
                }
                letters.remove(s.charAt(left++));
            }
        }
        
        return res;
    }
}
