class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // if (typed.length() < name.length()) return false;
        // if (name.length() == 0) return true;
        if (name.charAt(0) != typed.charAt(0)) return false;
        for (int i = 1, j = 1; i < name.length(); i++, j++) {
            if (name.charAt(i) != name.charAt(i - 1)) 
                while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) j++;    
            if (j >= typed.length() || name.charAt(i) != typed.charAt(j)) 
                return false;
        }
        return true;
    }
}
