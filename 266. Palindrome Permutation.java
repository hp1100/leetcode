class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        int count = 0;
        for(char c: map.keySet())
            if(map.get(c) % 2 == 1)
                count++;
        return count <= 1;
    }
}
