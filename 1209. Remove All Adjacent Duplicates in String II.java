class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == stack.peek()[0]) {
                int[] top = stack.peek();
                if (top[1] + 1 == k)
                    stack.pop();
                else
                    top[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            for (int i = 0; i < top[1]; i++)
                sb.append((char)top[0] + "");
        }
        return sb.reverse().toString();
    }
}
