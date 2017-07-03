public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i, j;
        for(i = 0, j = 0; j < s.length(); j++){
            if(chars[j] == ' '){
                reverseWord(chars, i, j-1);
                i = j+1;
            }
        }
        if(i < j) reverseWord(chars, i , j-1);
        return String.valueOf(chars);
    }
    
    public void reverseWord(char[] chars, int i, int j){
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        //return chars;
    }
}
