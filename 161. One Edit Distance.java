public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){ // same length, only this charcter is different
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else if(s.length() < t.length()){ // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                }else{ // s is longer than t, so the only possibility is deleting one char from s
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
