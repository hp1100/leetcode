class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
    	for (int i = 0; i < S.length(); i++) {
    		if (!stack.isEmpty() && S.charAt(i) == stack.peek()) {
    			stack.pop();
    		} else {
    			stack.push(S.charAt(i));
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	while (!stack.isEmpty())
    		sb.insert(0, stack.pop());
    	return sb.toString();
    }
}





  public String removeDuplicates(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) { 
                dq.pollLast();
            }else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }
