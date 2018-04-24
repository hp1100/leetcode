class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new LinkedList<>();
        for(int i = 2; i < S.length() - 1; i++) {
            String left = S.substring(1, i);
            String right = S.substring(i, S.length() - 1);

            List<String> leftComb = CombinationOfString(left);
            List<String> rightComb = CombinationOfString(right);

            StringBuilder sb = new StringBuilder();
            if(leftComb.size() == 0 || rightComb.size() == 0) continue;
            for(String l : leftComb) {
                for(String r : rightComb) {
                    sb.append("(").append(l).append(", ").append(r).append(")");
                    res.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        return res;
    }
    
    private List<String> CombinationOfString(String s) {
        List<String> comb = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        if(len == 1) {
            comb.add(s);
            return comb;
        } else if(s.charAt(0) == '0') {
            if(s.charAt(len - 1) == '0') return comb;
            sb.append(0).append(".").append(s.substring(1));
            comb.add(sb.toString());
            return comb;
        }
        
        if(s.charAt(len - 1) != '0')
            for(int i = 1; i < len; i++) {
                sb.append(s.substring(0, i)).append(".").append(s.substring(i, len));
                comb.add(sb.toString());
                sb.setLength(0);
            }
        comb.add(s);
        
        return comb;
    }
}
