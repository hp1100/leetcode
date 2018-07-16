class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // red = 0, blue = 1, unvisited = -1
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) 
            if (colors[i] == -1 && !validColor(colors, 0, graph, i))
                return false;
        return true;
    }
    
    private boolean validColor(int[] colors, int color, int[][] graph, int node) {
        if (colors[node] != -1) return colors[node] == color;
        colors[node] = color;
        for (int next : graph[node])
            if (!validColor(colors, 1 - color, graph, next))
                return false;
        return true;
    }
}
