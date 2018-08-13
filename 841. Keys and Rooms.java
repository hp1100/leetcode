class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> opened = new HashSet<>();
        opened.add(0);
        Queue<Integer> keys = new LinkedList<>();
        keys.add(0);
        while (!keys.isEmpty()) {
            int cur = keys.poll();
            for (int new_key : rooms.get(cur)) 
                if (opened.add(new_key)) 
                    keys.add(new_key);
        }
        return opened.size() == rooms.size();
    }
}
