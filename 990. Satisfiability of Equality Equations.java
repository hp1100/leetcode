class Solution {
    
    int[] uf = new int[26];    

    public boolean equationsPossible(String[] equations) {
        
        for (int i = 0; i < 26; ++i) uf[i] = i;
        
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int left = equation.charAt(0) - 'a';
                int right = equation.charAt(3) - 'a';
                uf[find(left)] = find(right);
            } 
        }
        
        for (String equation : equations) {
            if (equation.charAt(1) == '=')  continue;
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            if (find(left) == find(right)) return false;
        }
        
        return true;
    }
    
    private int find(int i) {
        if (i != uf[i]) uf[i] = find(uf[i]);
        return uf[i];
    }
}
