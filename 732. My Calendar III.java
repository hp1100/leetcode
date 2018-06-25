class MyCalendarThree {
    
    private TreeMap<Integer, Integer> calendar;

    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int count = 0, max = 0;
        for (Map.Entry<Integer, Integer> entry: calendar.entrySet()) {
            int key = entry.getKey();
            //System.out.print(key + " ");
            count += entry.getValue();
            max = Math.max(max, count);
        }
        //System.out.println("----");
        return max;
    }
}
