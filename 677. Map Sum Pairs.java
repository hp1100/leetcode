class MapSum {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        int val;
        
        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
            val = 0;
        }
        
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.val = val;
        node.isEnd = true;
    }
    
    public int sum(String prefix) {
        int res = 0;
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) return res;
            node = node.children.get(ch);
        }
        // bfs
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TrieNode cur = queue.poll();
            if (cur.isEnd) 
                res += cur.val;
            for (TrieNode child : cur.children.values())
                queue.offer(child);
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
