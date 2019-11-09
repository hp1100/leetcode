class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(index < str.length() && str.charAt(index) == ' ')
            index ++;

        //3. Handle signs
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}

//===============================================================================================================

class Solution {
    public int myAtoi(String str) {
        boolean negative = false;
        boolean positive = false;
        Long res = null;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ' && res == null && !negative && !positive) {
                continue;
            } else if (str.charAt(i) == '+' && !negative && !positive && res == null) {
                positive = true;
            } else if (str.charAt(i) == '-' && !positive && !negative && res == null) {
                negative = true;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (res == null)
                    res = 0L;
                res = res * 10 + Character.getNumericValue(str.charAt(i));
                if (res > Integer.MAX_VALUE) break;
            } else {
                break;
            }
        }
        if (res == null) return 0;
        if (negative) res = 0 - res;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return res.intValue();
    }
}
