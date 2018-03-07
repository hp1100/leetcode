//1.The length of the repeating substring must be a divisor of the length of the input string
//2.Search for all possible divisor of str.length, starting for length/2
//3.If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
//4.If the repeated substring is equals to the input str return true

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        //for(int i = 1; i <= len/2; i++) {
        for(int i = len/2; i >= 1; i--) {
            if(len % i == 0) {
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < len/i; k++)
                    sb.append(subS);
                if(sb.toString().equals(s)) 
                    return true;
            }
        }
        return false;
    }
}
