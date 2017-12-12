class Solution {
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        for(char c: s.toCharArray())
            alphabet[c - 'a']++;
        for(int i = 0; i < s.length(); i++)
            if(alphabet[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
