public class Solution {
    public char findTheDifference(String s, String t) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int res = 0;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        for(int i = 0; i < cs.length; i++){
            res = res ^ cs[i] ^ ct[i];
        }
        
        res ^= ct[ct.length-1];
        
        return a[res - 'a'];
    }
}

// another solution
class Solution {
    public char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];
        for(char c: s.toCharArray())
            alphabet[c - 'a']--;
        for(char c: t.toCharArray())
            alphabet[c - 'a']++;
        int tmp = 0;
        for(int i = 0; i < 26; i++){
            if(alphabet[i] == 1){
                tmp = i;
                break;
            }
        }
        return (char)('a' + tmp);
    }
}
