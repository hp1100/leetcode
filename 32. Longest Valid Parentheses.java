public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        if(stack.isEmpty()) return s.length();
        int a = s.length(), b = 0, res = 0;
        while(!stack.isEmpty()){
            b = stack.pop();
            res = Math.max(res, a - b - 1);
            a = b;
        }
        res = Math.max(a, res);
        return res;
    }
}
