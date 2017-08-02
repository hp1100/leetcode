public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    private void remove(String s, List<String> res, int last_i, int last_j, char[] par){
        for(int stack = 0, i = last_i; i < s.length(); i++){
            if(s.charAt(i) == par[0]) stack++;
            if(s.charAt(i) == par[1]) stack--;
            if(stack >= 0) continue;
            for(int j = last_j; j <= i; j++){
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])){
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0] == '('){ // finished left to right
            remove(reversed, res, 0, 0, new char[]{')', '('});
        }else{// finished right to left
            res.add(reversed);
        }
    }
}
