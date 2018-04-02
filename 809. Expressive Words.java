class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word : words) {
            //System.out.println(word);
            int i = 0, j = 0;
            for(; j < S.length(); j++) {
                if(i < word.length() && word.charAt(i) == S.charAt(j))
                    i++;
                else if(j > 0 && S.charAt(j) == S.charAt(j - 1) && j < S.length() - 1 && S.charAt(j) == S.charAt(j + 1)) 
                    // last, this and next
                    j++;
                else if(!(j > 1 && S.charAt(j) == S.charAt(j - 1) && S.charAt(j) == S.charAt(j - 2))) // this and last 2 
                    break;
            }
            if(i == word.length() && j == S.length()) // both pointers reach the end
                res++;
        }
        return res;
    }
}
