public class Solution {
    public int findComplement(int num) {
        int d = 0;
        int res = 0;
        while(num != 0){
            int k = num % 2 == 1 ? 0 : 1;
            res += Math.pow(2, d)*k;
            d++;
            num = num >> 1; 
        }
        return res;
    }
}
