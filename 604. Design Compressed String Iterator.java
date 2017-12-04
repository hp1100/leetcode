class StringIterator {
    
    Queue<int[]> queue = new LinkedList<>();

    public StringIterator(String compressedString) {
        int i = 0, n = compressedString.length();
        while(i < n){
            int j = i + 1;
            while(j < n && compressedString.charAt(j) - 'A' < 0) j++;
            queue.offer(new int[]{compressedString.charAt(i) - 'A', Integer.parseInt(compressedString.substring(i+1, j))});
            i = j;
        }
    }
    
    public char next() {
        if(queue.isEmpty()) return ' ';
        int[] top = queue.peek();
        if(--top[1] == 0) queue.poll();
        return (char)(top[0] + 'A');
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
