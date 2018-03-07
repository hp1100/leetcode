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
    
    // use hashSet
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else 
                set.remove(s.charAt(i));
        }
        return set.size() == 0 || set.size() == 1;
    }

}
