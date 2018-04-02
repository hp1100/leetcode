class Solution {

    // union-find
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        Map<String, String> map = new HashMap<>();
        for(String[] pair : pairs) {
            String p1 = find(map, pair[0]), p2 = find(map, pair[1]);
            map.put(p1, p2);
        }
        
        for(int i = 0; i < words1.length; i++) 
            if(!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i])))
                return false;
        
        return true;
    }
    
    private String find(Map<String, String> map, String str) {
        if(!map.containsKey(str))
            map.put(str, str);
        return str.equals(map.get(str)) ? str : find(map, map.get(str));
    }
}
