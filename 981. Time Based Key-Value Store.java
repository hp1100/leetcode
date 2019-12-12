class TimeMap {
    
    Map<String, TreeMap<Integer, String>> timeMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = timeMap.get(key);
        
        Integer prev_largetestTime = timestamps.floorKey(timestamp);
        
        
        return prev_largetestTime == null ? "" : timestamps.get(prev_largetestTime);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
