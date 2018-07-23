class RandomizedSet {
    
    List<Integer> nums;
    Map<Integer, Integer> indexs; // key : val , value : index
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        indexs = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indexs.containsKey(val)) return false;
        nums.add(val);
        indexs.put(val, indexs.size());
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!indexs.containsKey(val)) return false;
        int idx = indexs.get(val);
        if (idx != indexs.size() - 1) {
            int last_val = nums.get(indexs.size() - 1);
            nums.set(idx, last_val);
            indexs.put(last_val, idx);
        }
        nums.remove(indexs.size() - 1);
        indexs.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(indexs.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
