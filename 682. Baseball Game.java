class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int penult = 0;
        //boolean haveTwo = false;
        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.peek();
                stack.push(penult + top);
                penult = top;    
            } else if (op.equals("D")) {
                penult = stack.peek();
                stack.push(penult * 2);
            } else if (op.equals("C")) {
                stack.pop();
                if (stack.size() >= 2) {
                    int top = stack.pop();
                    penult = stack.peek();
                    stack.push(top);
                }
            } else {
                if(!stack.isEmpty()) penult = stack.peek();
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }
}
