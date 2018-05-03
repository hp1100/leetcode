class Solution {
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        StringBuilder suf = new StringBuilder("a");
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for(String s: S.split(" ")) {
            StringBuilder cur = new StringBuilder();
            char c = s.charAt(0);
            if(!vowels.contains(c)) 
                cur.append(s.substring(1)).append(c +"");
            else
                cur.append(s);
            cur.append("ma").append(suf).append(" ");
            suf.append("a");
            res.append(cur);
        }
        // remove the last blank space
        res.setLength(res.length() - 1);
        return res.toString();
    }
}
