class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;j++;
                continue;
            }
            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9')
                return false;
            int start = j;
            while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9')
                j++;
            i += Integer.parseInt(abbr.substring(start, j));
        }
        return i == word.length() && j == abbr.length();
    }
}
