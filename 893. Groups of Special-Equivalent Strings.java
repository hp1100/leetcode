class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] alp1 = new int[26];
            int[] alp2 = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    alp1[s.charAt(i) - 'a']++;
                } else {
                    alp2[s.charAt(i) - 'a']++;
                }
            }
            set.add(Arrays.toString(alp1) + " " + Arrays.toString(alp2));
        }
        return set.size();
    }
}
