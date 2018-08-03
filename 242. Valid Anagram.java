class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for (char ch : s.toCharArray())
            alphabets[ch - 'a']++;
        for (char ch : t.toCharArray())
            if (--alphabets[ch - 'a'] < 0)
                return false;
        for (int alphabet : alphabets)
            if (alphabet != 0)
                return false;
        return true;
    }
}
