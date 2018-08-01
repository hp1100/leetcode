class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = helper(version1);
        List<Integer> v2 = helper(version2);
        int i = 0;
        while (v1.size() > i && v2.size() > i) {
            int compare = v1.get(i).compareTo(v2.get(i));
            if (compare != 0) return compare;
            i++;
        }
        if (v1.size() == i && v2.size() == i) return 0;
        return v1.size() > i ? 1 : -1;
    }
    
    private List<Integer> helper(String s) {
        List<Integer> res = new ArrayList<>();
        for (String ss : s.split("\\.")) 
            res.add(Integer.parseInt(ss));
        while (res.size() > 0 && res.get(res.size() - 1) == 0)
            res.remove(res.size() - 1);
        return res;
    }
}
