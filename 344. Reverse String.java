public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = s.length()-1; i < j; i++, j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }
}
