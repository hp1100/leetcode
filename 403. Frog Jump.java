class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) return true;
        
        Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int stone : stones) map.put(stone, new HashSet<>());
        map.get(0).add(1);
        
        for (int i = 0; i < stones.length - 1; i++) {
        	int stone = stones[i];
        	for (int step : map.get(stone)) {
        		int reach = step + stone;
        		if (reach == stones[stones.length - 1]) 
                    return true;
        		HashSet<Integer> set = map.get(reach);
        		if (set != null) {
        		    set.add(step);
        		    if (step - 1 > 0) set.add(step - 1);
        		    set.add(step + 1);
        		}
        	}
        }
        return false;
    }
}
