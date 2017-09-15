class Solution {
    public int[] plusOne(int[] digits) {
        //int flag = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
                if(i == 0){
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    for(int j = 1; j < res.length; j++)
                        res[j] = digits[j - 1];
                    return res;
                }
            }else{
                digits[i]++;
                break;
            }
        }
        return digits;
    }
}
