class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        boolean dup = false;
        Set<Character> set = new HashSet<>();
        int pre = -1;
        for (int i = 0; i < A.length(); i++) {
            
            if (set.contains(A.charAt(i))) dup = true;
            set.add(A.charAt(i));
            
            if (A.charAt(i) == B.charAt(i)) continue;
            if (pre == -2) return false;
            else if (pre == -1) pre = i;
            else {
                if (!((A.charAt(i) == B.charAt(pre)) && (A.charAt(pre) == B.charAt(i)))) 
                    return false;
                pre = -2;
            }
        }
        if(pre == -2) return true;
        return dup;
    }
}
