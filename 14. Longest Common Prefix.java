class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String first = strs[0];
        //if(strs.length == 1) return first;
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() == i || strs[j].charAt(i) != c)
                    return prefix.toString();
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}
