class Solution {
    public int scoreOfParentheses(String S) {
        int res = 0, level = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(-1);
                level = 1;
            }else {
                if(stack.peek() == -1) {
                    stack.pop();
                    stack.push(level * 1);
                }else {
                    int tmp = 0;
                    while(!stack.isEmpty()) {
                        int top = stack.pop();
                        if (top == -1) break;
                        tmp += top;
                    }
                    stack.push(level * tmp);
                }
                level = 2;
            }
        }
        while (!stack.isEmpty())
            res += stack.pop();
        return res;
    }
}
