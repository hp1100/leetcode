public class Solution {
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            int temp = i;
            int count = 0;
            while(temp > 0){
                count += (temp % 2 == 1 ? 1 : 0);
                temp /= 2;
            }
            res[i] = count;
        }
        return res;
    }
}
