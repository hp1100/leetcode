// pass all testcases, but still not correct!!!!
// because preMin can only store second smallest num, but the answer might be stored in third smallest num(PrePreMin)

//Wrong test case
// Your input
// ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","dec","dec","dec","getMinKey"]
// [[],["a"],["b"],["b"],["c"],["c"],["c"],["d"],["d"],["d"],["d"],["a"],["b"],["b"],[]]
// Output
// [null,null,null,null,null,null,null,null,null,null,null,null,null,null,"d"]
// Expected
// [null,null,null,null,null,null,null,null,null,null,null,null,null,null,"c"]
class AllOne {
    
    Map<String, Integer> counts;
    Map<Integer, Set<String>> lists;
    int min, max;
    int preMin;

    /** Initialize your data structure here. */
    public AllOne() {
        counts = new HashMap<>();
        lists = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        preMin = Integer.MAX_VALUE;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!counts.containsKey(key)) {
            counts.put(key, 1);
            lists.computeIfAbsent(1, v -> new HashSet<>());
            lists.get(1).add(key);
            preMin = min;
            min = Math.min(1, min);
            max = Math.max(1, max);
        } else {
            int count = counts.get(key);
            counts.put(key, count + 1);
            lists.get(count).remove(key);
            if (lists.get(count).size() == 0)
                lists.remove(count);
            lists.computeIfAbsent(count + 1, v -> new HashSet<>());
            lists.get(count + 1).add(key);
            if (!lists.containsKey(min)) {
                preMin = min;
                min = count + 1;
            }
            max = Math.max(count + 1, max);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!counts.containsKey(key)) return;
        int count = counts.get(key);
        if (count == 1) {
            counts.remove(key);
            lists.get(1).remove(key);
            if (!lists.containsKey(min)) min = preMin;
        } else {
            counts.put(key, count - 1);
            lists.get(count).remove(key);
            lists.computeIfAbsent(count - 1, v -> new HashSet<>());
            lists.get(count - 1).add(key);
            if (!lists.containsKey(max))
                max = count - 1;
            preMin = min;
            min = Math.min(count - 1, min);
        }
        
        if (lists.get(count).size() == 0)
            lists.remove(count);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return lists.containsKey(max) ? lists.get(max).iterator().next() : "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return lists.containsKey(min) ? lists.get(min).iterator().next() : lists.containsKey(preMin) ? lists.get(preMin).iterator().next() : getMaxKey();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
