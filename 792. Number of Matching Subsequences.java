public int numMatchingSubseq(String S, String[] words) {
    List<Integer[]>[] waiting = new List[128];
    for (int c = 0; c <= 'z'; c++)
        waiting[c] = new ArrayList();
    for (int i = 0; i < words.length; i++)
        waiting[words[i].charAt(0)].add(new Integer[]{i, 1});
    for (char c : S.toCharArray()) {
        List<Integer[]> advance = new ArrayList(waiting[c]);
        waiting[c].clear();
        for (Integer[] a : advance)
            waiting[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
    }
    return waiting[0].size();
}


class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer[]>> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < words.length; i++) {
            char head = words[i].charAt(0);
            List<Integer[]> temp = map.getOrDefault(head, new ArrayList<>());
            temp.add(new Integer[]{i, 1});
            map.put(head, temp);
        }
        
        for(char c : S.toCharArray()) {
            if(!map.containsKey(c)) continue;
            
            List<Integer[]> advance = map.get(c);
            map.remove(c);
            
            for(Integer[] a : advance) {
                if(a[1] < words[a[0]].length()) {
                    char head = words[a[0]].charAt(a[1]);
                    List<Integer[]> temp = map.getOrDefault(head, new ArrayList<>());
                    temp.add(new Integer[]{a[0], ++a[1]});
                    map.put(head, temp);
                }else{
                    count++;
                }
            }
        }
        
        return count;
    }
}
