class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            map.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.offer(i);
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res.add(course);
            if (!map.containsKey(course)) continue;
            for (int next : map.get(course))
                if (--indegree[next] == 0)
                    queue.offer(next);
        }
        
        if (res.size() != numCourses) return new int[0];
        
        int[] ans = new int[res.size()];
        
        for (int i = 0; i < ans.length; i++)
            ans[i] = res.get(i);
        
        return ans;
    }
}
