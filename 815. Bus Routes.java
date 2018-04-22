class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
		if (S == T) return 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < routes.length; ++i) {
			for (int j : routes[i]) {
				if (!map.containsKey(j)) map.put(j, new HashSet<Integer>());
				map.get(j).add(i);
			}
		}
		for (int next : map.get(S)) {
			visited.add(next);
			queue.add(next);
		}
		int res = 1;
		while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
				int cur = queue.poll();
				for (int c : routes[cur]) {
					if (c == T) return res;
					for (int next : map.get(c)) {
						if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
					}
				}
			}
			res++;
		}
		return -1;
    }
}
