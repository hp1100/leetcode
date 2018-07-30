// Time complexity: O(3^n)
class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    
    private boolean check(String s, int idx, int val) {
        if (val < 0) return false;
        if (idx == s.length()) return val == 0;
        if (s.charAt(idx) == '(') {
            return check(s, idx + 1, val + 1);
        } else if (s.charAt(idx) == ')') {
            return check(s, idx + 1, val - 1);
        } else {
            return check(s, idx + 1, val + 1) || check(s, idx + 1, val - 1) || check(s, idx + 1, val);
        }
    }
}

// Time complexity: O(n)
class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                if (low > 0) low--;
                high--;
            } else {
                if (low > 0) low--;
                high++;
            }
            if (high < 0) return false;
        }
        
        return low == 0;
    }
    
}
