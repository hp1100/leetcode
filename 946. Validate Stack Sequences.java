class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if (pushed.length == 0) return true;
        int i = 0, j = 0; // i for pushed, j for popped
        while (i < pushed.length) {
            stack.push(pushed[i++]);
            while(!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
