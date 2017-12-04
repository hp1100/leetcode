class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null && words1 == null) return true;
        if(words1 == null || words2 == null) return false;
        if(words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] p: pairs){
            if(!map.containsKey(p[0]))
                map.put(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }      
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i]) || map.getOrDefault(words1[i], new HashSet<>()).contains(words2[i])
              || map.getOrDefault(words2[i], new HashSet<>()).contains(words1[i])) 
                continue;
            return false;
        }
        return true;
    }
}
