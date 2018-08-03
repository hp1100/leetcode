class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : magazine.toCharArray())
            alphabet[c - 'a']++;
        for (char c : ransomNote.toCharArray())
            if (--alphabet[c - 'a'] < 0)
                return false;
        return true;
    }
}
