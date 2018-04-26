class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int len = fronts.length, res = 2001;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < len; i++) {
            if(fronts[i] == backs[i]) set.add(fronts[i]);
        }
        for(int i = 0; i < len; i++) {
            if(!set.contains(fronts[i])) res = Math.min(res, fronts[i]);
            if(!set.contains(backs[i])) res = Math.min(res, backs[i]);
        }
        return res == 2001 ? 0 : res;
    }
}
