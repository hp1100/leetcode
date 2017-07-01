public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    
    //backtracking
    public void helper(List<String> res, String str, int open, int close, int len){
        if(str.length() == len * 2){
            res.add(str);
            return;
        }
        
        if(open < len) helper(res, str + "(", open + 1, close, len);
        if(close < open) helper(res, str + ")", open, close + 1, len);
    }
}
