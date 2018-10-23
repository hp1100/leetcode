class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        if (name.length() == 0) return true;
        if (name.charAt(0) != typed.charAt(0)) return false;
        int idx = 1;
        for (int i = 1; i < name.length(); i++, idx++) {
            if (name.charAt(i) != name.charAt(i - 1)) 
                while (idx < typed.length() && typed.charAt(idx) == typed.charAt(idx - 1)) idx++;    
            if (idx >= typed.length() || name.charAt(i) != typed.charAt(idx)) 
                return false;
        }
        return true;
    }
}
