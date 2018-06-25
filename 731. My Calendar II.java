class MyCalendarTwo {
    
    private TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: calendar.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                calendar.put(start, calendar.get(start) - 1);
                if (calendar.get(start) == 0)
                    calendar.remove(start);
                calendar.put(end, calendar.get(end) + 1);
                if (calendar.get(end) == 0)
                    calendar.remove(end);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
