class Solution {
    public String reverseParentheses(String s) {
        int level = 0;
        Map<Integer, Stack<String>> map = new HashMap<>();
        String prefix = "";
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!map.containsKey(level)) map.put(level, new Stack<>());
                map.get(level++).push(prefix);
                prefix = "";
            } else if (c == ')') {
                if (!map.containsKey(level)) map.put(level, new Stack<>());
                map.get(level--).push(prefix);
                prefix = "";
            } else {
                prefix += c;
            }
        }
        int i = 0;
        String res = "";
        while (map.containsKey(i)) {
            String cur = "";
            Stack<String> stack = map.get(i);
            while (!stack.isEmpty())
                cur += stack.pop();
            if (i % 2 == 0)
                res += cur;
            else
                res += new StringBuilder(cur).reverse().toString();
            i++;
        }
        return res;
    }
}
