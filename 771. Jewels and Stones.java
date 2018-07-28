class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char j : J.toCharArray())
            set.add(j);
        for (char s : S.toCharArray())
            if (set.contains(s))
                count++;
        return count;
    }
}
