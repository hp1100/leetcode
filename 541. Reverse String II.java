public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i+=k*2){
            reverse(chars, i, i+k-1);
        }
        return String.valueOf(chars);
    }
    
    public void reverse(char[] chars, int i, int j){
        if(j > chars.length - 1) j = chars.length - 1;
        for(; i < j; i++, j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
