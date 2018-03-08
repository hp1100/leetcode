class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1) return true;
        if(isCapital(word.charAt(0)))
            return isAllCapitals(word.substring(1)) || isAllNotCapitals(word.substring(1));
        else
            return isAllNotCapitals(word.substring(1));
    }
    
    private boolean isCapital(Character c){
        if(c - 'A' >= 0 && 'Z' - c >= 0) return true;
        return false;
    }
    
    private boolean isAllCapitals(String s){
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) - 'A' < 0 || 'Z' - s.charAt(i) < 0)
                return false;
        return true;
    }
    
    private boolean isAllNotCapitals(String s){
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) - 'a' < 0 || 'z' - s.charAt(i) < 0)
                return false;
        return true;
    }
}

// 5-line
class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char c : word.toCharArray())
            if('Z' - c >= 0)
                count++;
        return count == 0 || count == word.length() || (count == 1 && 'Z' - word.charAt(0) >= 0); 
    }
}

// 1-line
class Solution {
    public boolean detectCapitalUse(String word) {
        return word.substring(1).equals(word.substring(1).toLowerCase())||word.equals(word.toUpperCase());
    }
}
