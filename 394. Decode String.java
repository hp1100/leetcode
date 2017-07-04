public class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> res = new Stack<>();
        res.push("");
        int idx = 0;
        while(idx < s.length()){
            char ch = s.charAt(idx);
            if(ch >= '0' && ch <= '9'){
                int start = idx;
                while(s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '9') idx++;
                count.push(Integer.parseInt(s.substring(start, idx + 1)));
            }else if(ch == '['){
                res.push("");
            }else if(ch == ']'){
                String str = res.pop();
                StringBuilder sb = new StringBuilder();
                for(int i = count.pop(); i > 0; i--){
                    sb.append(str);
                }
                res.push(res.pop() + sb.toString());
            }else{//repeated content
                res.push(res.pop() + ch);
            }
            idx++;
        }
        return res.pop();
    }
}
